package comp;

import java.util.ArrayList;
import java.util.Locale;

import static comp.CommandsEnum.*;
import static comp.Registers.*;

public class CodeGenerator
{
    ArrayList<String> wholeCodeBuilder = new ArrayList<>();
    public DataHandler dh;

    public CodeGenerator(DataHandler d)
    {
        this.dh = d;
    }

    void writeEnd() {
        wholeCodeBuilder.add("HALT\n");
    }




    /**
     * Writes wanted constant to given register.
     * Use registers A and B
     * ALL PREV DATA WILL BE LOST
     */
    public long genConst(long con, Registers reg, ArrayList<String> sb) //JEST GIT
    {
        long offset = 0;
        sb.add("RESET a\n");
        sb.add("RESET b\n");
        sb.add("INC b\n");
        offset+=3;
        String bo = Long.toBinaryString(con);
        char[] bits = bo.toCharArray();
        for(char bit : bits)
        {
            if(bit == '1')
            {
                sb.add("SHIFT b\n");
                sb.add("INC a\n");
                offset+=2;
            }
            else
            {
                sb.add("SHIFT b\n");
                offset++;
            }
        }
        sb.add("SWAP " + reg.toString().toLowerCase(Locale.ROOT) + "\n");
        offset++;

        return offset;

    }

    Variable copyVariable(Variable var, ArrayList<String> sb)
    {
        String temp_name = dh.addIteratorSymbol();
        Variable temp_var = dh.getVariable(temp_name);

        getVarVal(var, a, sb);
        saveRegToMem(temp_var, a, sb);

        return temp_var;
    }

    /**
     * Saves value from register to mem.
     */
    long saveRegToMem(Variable var, Registers r, ArrayList<String> sb) //POPRAWIĆ
    {
        long offset = 0;
        switch (r) {
            case a -> {
                sb.add("SWAP c\n");
                offset += getMemAddrInRegA(var, sb);
                sb.add("SWAP c\n");
                sb.add("STORE c\n");
                offset += 3;
            }
            case b -> {
                sb.add("SWAP c\n");
                sb.add("SWAP c\n");
                offset += getMemAddrInRegA(var, sb);
                sb.add("SWAP c\n");
                sb.add("STORE c\n");
                offset += 4;
            }
            default -> {
                offset += getMemAddrInRegA(var, sb);
                sb.add("SWAP " + r.toString().toLowerCase(Locale.ROOT) +"\n");
                sb.add("STORE " + r.toString().toLowerCase(Locale.ROOT) + "\n");
                offset += 2;
            }
        }

        return offset;
    }

    long getMemFromReg(Variable var, Registers r, ArrayList<String> sb)  //DO POPRAWY
    {
        long offset = 0;
        offset += getMemAddrInRegA(var, sb);
        sb.add("LOAD a\n");
        sb.add("SWAP " + r.toString().toLowerCase(Locale.ROOT) + "\n");
        offset += 2;
        return offset;
    }

    long getVarVal(Variable var, Registers r, ArrayList<String> sb)
    {
        long offset = 0;
        if(!var.isSet())
        {
            offset += genConst(var.getValue(), r, sb);
        }
        else if(var.getArrayAddress() != -1)
        {
            offset += getMemFromReg(var, r, sb);
        }
        else
        {
            offset += getMemFromReg(var, r, sb);
        }
        return offset;
    }

    long getVarValInAB(Variable var1, Variable var2, ArrayList<String> sb)
    {
        long offset = 0;
        offset += getVarVal(var1, a, sb);
        sb.add("SWAP c\n");
        offset += getVarVal(var2, b, sb);
        sb.add("SWAP c\n");
        offset += 2;
        return offset;
    }

    long getMemAddrInRegA(Variable var, ArrayList<String> sb) //DO POPRAWKI
    {
        long offset = genConst(var.getAddress(), a, sb);

        if(var.getArrayAddress() != -1)
        {
            sb.add(SWAP + " " + d + "\n");
            offset += genConst(var.getArrayAddress(), a, sb);
            sb.add(LOAD + " " + a + "\n");
            sb.add(ADD + " " + d + "\n");
            sb.add(SWAP + " " + d + "\n");
            offset += genConst(-var.arrayOffset, a, sb);
            sb.add(ADD + " " + d + "\n");
            offset += 5;
        }
        return  offset;
    }

    //
    //IO//
    //
    long read(Variable var, ArrayList<String> sb)
    {
        long offset = 0;
        sb.add("GET\n");
        offset += 1;
        offset += saveRegToMem(var, a, sb);

        var.setSet(true);
        return offset;
    }

    long write(Variable var, ArrayList<String> sb)
    {
        long offset = 0;
        offset += getVarVal(var, a, sb);
        sb.add("PUT\n");
        offset++;
        return offset;
    }

    //
    //ASSIGN//
    //
    long assign(Variable var, ArrayList<String> sb)
    {
        return saveRegToMem(var, a, sb);
    }


    //
    //OPERATIONS//
    //

    long getConstant(Variable var, ArrayList<String> sb)
    {
        return getVarVal(var, a, sb);
    }

    long add(Variable var1, Variable var2, ArrayList<String> sb)
    {
        long offset = 0;
        //sb.add("(START ADD)\n");
        offset += getVarValInAB(var1, var2, sb);
        sb.add("ADD b\n");
        offset++;
        return offset;
    }

    long sub(Variable var1, Variable var2, ArrayList<String> sb)
    {
        long offset = 0;
        //sb.add("(START SUB)\n");
        offset += getVarValInAB(var1, var2, sb);
        sb.add("SUB b\n");
        offset++;
        return offset;
    }

    long mul(Variable var1, Variable var2, ArrayList<String> sb)
    {
        long offset = 0;
        //sb.add("(START MUL)\n");

        offset += getVarValInAB(var1, var2, sb);
//        sb.add("PUT\n");
//        sb.add("SWAP b");
//        sb.add("PUT\n");
//        sb.add("SWAP b");

        sb.add("JZERO 37\n"); //JUMP IF VAR1 0
        sb.add("SWAP b\n");
        sb.add("JZERO 35\n"); //JUMP IF VAR2 0
        sb.add("SWAP b\n");

        sb.add("SWAP c\n");
        sb.add("RESET a\n");
        sb.add("JPOS 4\n"); //JUMP TO IF A > 0
        sb.add("SWAP b\n"); //SWAP Bval -> Areg
        sb.add("JPOS 22\n"); //JUMP TO IF A < 0 & B > 0
        sb.add("JNEG 15\n"); //JUMP TO IF A < 0 & B < 0
        sb.add("SWAP b\n");  // SWAP Bval -> Areg
        sb.add("JPOS 7\n"); //JUMP TO IF A > 0 & B > 0

        //Code If A > 0 & B < 0
        sb.add("SWAP b\n");
        sb.add("SUB c\n");
        sb.add("INC b\n");
        sb.add("SWAP b\n");
        sb.add("JNEG -4\n");
        sb.add("JUMP 18\n");

        //Code If A > 0 & B > 0
        sb.add("SWAP b\n");
        sb.add("ADD c\n");
        sb.add("DEC b\n");
        sb.add("SWAP b\n");
        sb.add("JPOS -4\n");
        sb.add("JUMP 12\n");

        //Code If A < 0 & B < 0
        sb.add("SWAP b\n");
        sb.add("SUB c\n");
        sb.add("INC b\n");
        sb.add("SWAP b\n");
        sb.add("JNEG -4\n");
        sb.add("JUMP 6\n");

        //Code If A < 0 & B > 0
        sb.add("SWAP b\n");
        sb.add("ADD c\n");
        sb.add("DEC b\n");
        sb.add("SWAP b\n");
        sb.add("JPOS -4\n");
        sb.add("JUMP 1\n");
        sb.add("SWAP b\n");

        offset += 38;
        return offset;
    }

    /**
     * Writes division operation to code, res in reg A
     */
    long div(Variable var1, Variable var2, ArrayList<String> sb)
    {
        long offset = 0;
        //sb.add("(START DIV)\n");
        offset += getVarValInAB(var1, var2, sb);
        sb.add("RESET c\n");

        sb.add("JZERO 35\n");
        sb.add("SWAP b\n"); //SWAP Bval -> Areg
        sb.add("JZERO 33\n");
        sb.add("SWAP b\n"); //SWAP Aval -> Areg
        sb.add("JPOS 4\n"); //JUMP TO IF A > 0
        sb.add("SWAP b\n"); //SWAP Bval -> Areg
        sb.add("JPOS 24\n"); //JUMP TO IF A < 0 & B > 0
        sb.add("JNEG 16\n"); //JUMP TO IF A < 0 & B < 0
        sb.add("SWAP b\n");  // SWAP Bval -> Areg
        sb.add("JPOS 7\n"); //JUMP TO IF A > 0 & B > 0
        //Code If A > 0 & B < 0
        sb.add("SWAP b\n");  //SWAP Aval -> Areg
        sb.add("ADD b\n");
        sb.add("DEC c\n");
        sb.add("JPOS -2\n");
        sb.add("SWAP c\n");
        sb.add("JUMP 20\n");
        //Code If A > 0 & B > 0
        sb.add("SWAP b\n");
        sb.add("SUB b\n");
        sb.add("JNEG 3\n");
        sb.add("INC c\n");
        sb.add("JPOS -3\n");
        sb.add("SWAP c\n");
        sb.add("JUMP 13\n");
        //Code If A < 0 & B < 0
        sb.add("SWAP b\n");
        sb.add("SUB b\n");
        sb.add("JPOS 3\n");
        sb.add("INC c\n");
        sb.add("JNEG -3\n");
        sb.add("SWAP c\n");
        sb.add("JUMP 6\n");
        //Code If A < 0 & B > 0
        sb.add("SWAP b\n");
        sb.add("ADD b\n");
        sb.add("DEC c\n");
        sb.add("JNEG -2\n");
        sb.add("SWAP c\n");
        sb.add("JUMP 1\n");
        offset += 37;
        return offset;
    }

    /**
     * Writes modulo operation to code, res in reg A
     */
    long mod(Variable var1, Variable var2, ArrayList<String> sb)
    {
        long offset = 0;
        //sb.add("(START MOD)\n");
        offset += getVarValInAB(var1, var2, sb);
        sb.add("RESET c\n");



        sb.add("JZERO 29\n");
        sb.add("SWAP b\n"); //SWAP Bval -> Areg
        sb.add("JZERO 27\n");
        sb.add("SWAP b\n"); //SWAP Aval -> Areg
        sb.add("JPOS 4\n"); //JUMP TO IF A > 0
        sb.add("SWAP b\n"); //SWAP Bval -> Areg
        sb.add("JPOS 20\n"); //JUMP TO IF A < 0 & B > 0
        sb.add("JNEG 13\n"); //JUMP TO IF A < 0 & B < 0
        sb.add("SWAP b\n");  // SWAP Bval -> Areg
        sb.add("JPOS 5\n"); //JUMP TO IF A > 0 & B > 0
        //Code If A > 0 & B < 0
        sb.add("SWAP b\n");  //SWAP Aval -> Areg
        sb.add("ADD b\n");
        sb.add("JPOS -1\n");
        sb.add("JUMP 16\n");
        //Code If A > 0 & B > 0
        sb.add("SWAP b\n");
        sb.add("SUB b\n");
        sb.add("JPOS -1\n");
        sb.add("JZERO 2\n");
        sb.add("ADD b\n");
        sb.add("JUMP 10\n");
        //Code If A < 0 & B < 0
        sb.add("SWAP b\n");
        sb.add("SUB b\n");
        sb.add("JNEG -1\n");
        sb.add("JZERO 2\n");
        sb.add("ADD b\n");
        sb.add("JUMP 4\n");
        //Code If A < 0 & B > 0
        sb.add("SWAP b\n");
        sb.add("ADD b\n");
        sb.add("JNEG -1\n");
        sb.add("JUMP 1\n");
        offset += 31;
        return offset;
    }


    //
    //COMPARATIVES
    //

    long eq(Variable var1, Variable var2, ArrayList<String> sb)
    {
        long offset = 0;
        offset += getVarValInAB(var1, var2, sb);
        sb.add("SUB b\n");
        sb.add("JZERO 2\n");
        offset += 2;
        return offset;
    }


    public long neq(Variable var1, Variable var2, ArrayList<String> sb)
    {
        long offset = 0;
        offset += getVarValInAB(var1, var2, sb);
        sb.add("SUB b\n");
        sb.add("JPOS 3\n");
        sb.add("JNEG 2\n");
        offset += 3;
        return offset;
    }

    long leq(Variable var1, Variable var2, ArrayList<String> sb)
    {
        long offset = 0;
        offset += getVarValInAB(var1, var2, sb);
        sb.add("SUB b\n");
        sb.add("JNEG 3\n");
        sb.add("JZERO 2\n");
        offset += 3;
        return offset;
    }

    long geq(Variable var1, Variable var2, ArrayList<String> sb)
    {
        long offset = 0;
        offset += getVarValInAB(var1, var2, sb);
        sb.add("SUB b\n");
        sb.add("JPOS 3\n");
        sb.add("JZERO 2\n");
        offset += 3;
        return offset;
    }

    long le(Variable var1, Variable var2, ArrayList<String> sb)
    {
        long offset = 0;
        offset += getVarValInAB(var1, var2, sb);
        sb.add("SUB b\n");
        sb.add("JNEG 2\n");
        offset += 2;
        return offset;
    }

    long ge(Variable var1, Variable var2, ArrayList<String> sb)
    {
        long offset = 0;
        offset += getVarValInAB(var1, var2, sb);
        sb.add("SUB b\n");
        sb.add("JPOS 2\n");
        offset += 2;
        return offset;
    }
    //
    //IFs
    //

    long if_block(long offset, ArrayList<String> sb)
    {
        sb.add(JUMP + " " + (offset+1) + "\n");
        return 1;
    }

    void if_else_block_first(long offset, ArrayList<String> sb)
    {
        sb.add(JUMP + " " + (offset+2) + "\n");
    }


    void if_else_block_second(long offset, ArrayList<String> sb)
    {
        sb.add(JUMP + " " + (offset+1) + "\n");
    }


    //
    //LOOPs
    //

    void while_block_first(long offset, ArrayList<String> sb)
    {
        sb.add(JUMP + " " + (offset+2) + "\n");
    }

    void while_block_second(long offsetCommands, long offsetCond, ArrayList<String> sb)
    {
        sb.add(JUMP + " " + -(offsetCommands + offsetCond + 1) + "\n");
    }

    void repeat_block(long offsetCommands, long offsetCond, ArrayList<String> sb)
    {
        sb.add(JUMP + " " + -(offsetCommands+offsetCond) + "\n");
    }

    void for_block_init(ForLabel label, ArrayList<String> sb)
    {
//        sb.add("(START INIT)\n");
        label.setStart(copyVariable(label.getStart(), sb));
        label.setEnd(copyVariable(label.getEnd(), sb));

        getConstant(label.getStart(), sb);
        assign(label.getIterator(), sb);
//        sb.add("(END INIT)\n");
    }

    void for_to_block_first(ForLabel label, ArrayList<String> sb)
    {
        leq(label.getIterator(), label.getEnd(), sb);
    }

    void for_downto_block_first(ForLabel label, ArrayList<String> sb)
    {
        geq(label.getIterator(), label.getEnd(), sb);
    }

    void for_to_block_second(ForLabel label, ArrayList<String> sb, long offsetCond)
    {
//        sb.add("(START AFTER)\n");
        getVarVal(label.getIterator(), a, sb);
        sb.add("INC a\n");
        saveRegToMem(label.getIterator(), a, sb);
        sb.add("JUMP " + -(offsetCond + sb.size()+1) + "\n");
//        sb.add("(END AFTER)\n");
    }

    void for_downto_block_second(ForLabel label, ArrayList<String> sb, long offsetCond)
    {
//        sb.add("(START AFTER)\n");
        getVarVal(label.getIterator(), a, sb);
        sb.add("DEC a\n");
        saveRegToMem(label.getIterator(), a, sb);
        sb.add("JUMP " + -(offsetCond + sb.size()+1) + "\n");
//        sb.add("(END AFTER)\n");
    }

    void for_block_addJump(long offsetCommands, ArrayList<String> sb)
    {
        sb.add("JUMP " + (offsetCommands+1) + "\n");
    }

}
