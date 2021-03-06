package comp.gen;// Generated from /home/adam/Uczelnia/JFTT/L3/Compiler/src/main/language.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class languageLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, COMMENT=2, IF=3, COMMA=4, NUM=5, LSQBRACKET=6, RSQBRACKET=7, SEMICOLON=8, 
		VAR=9, BEGIN=10, END=11, ASSIGN=12, ELSE=13, THEN=14, ENDIF=15, WHILE=16, 
		REPEAT=17, DO=18, ENDWHILE=19, UNTIL=20, FOR=21, FROM=22, DOWNTO=23, TO=24, 
		ENDFOR=25, READ=26, WRITE=27, PLUS=28, MINUS=29, DIV=30, TIMES=31, MOD=32, 
		EQ=33, NEQ=34, LE=35, GE=36, LEQ=37, GEQ=38, WHITESPACE=39, PIDENTIFIER=40, 
		CHARACTER=41;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "COMMENT", "IF", "COMMA", "NUM", "LSQBRACKET", "RSQBRACKET", 
			"SEMICOLON", "VAR", "BEGIN", "END", "ASSIGN", "ELSE", "THEN", "ENDIF", 
			"WHILE", "REPEAT", "DO", "ENDWHILE", "UNTIL", "FOR", "FROM", "DOWNTO", 
			"TO", "ENDFOR", "READ", "WRITE", "PLUS", "MINUS", "DIV", "TIMES", "MOD", 
			"EQ", "NEQ", "LE", "GE", "LEQ", "GEQ", "WHITESPACE", "PIDENTIFIER", "CHARACTER"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "':'", null, "'IF'", "','", null, "'['", "']'", "';'", "'VAR'", 
			"'BEGIN'", "'END'", "'ASSIGN'", "'ELSE'", "'THEN'", "'ENDIF'", "'WHILE'", 
			"'REPEAT'", "'DO'", "'ENDWHILE'", "'UNTIL'", "'FOR'", "'FROM'", "'DOWNTO'", 
			"'TO'", "'ENDFOR'", "'READ'", "'WRITE'", "'PLUS'", "'MINUS'", "'DIV'", 
			"'TIMES'", "'MOD'", "'EQ'", "'NEQ'", "'LE'", "'GE'", "'LEQ'", "'GEQ'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "COMMENT", "IF", "COMMA", "NUM", "LSQBRACKET", "RSQBRACKET", 
			"SEMICOLON", "VAR", "BEGIN", "END", "ASSIGN", "ELSE", "THEN", "ENDIF", 
			"WHILE", "REPEAT", "DO", "ENDWHILE", "UNTIL", "FOR", "FROM", "DOWNTO", 
			"TO", "ENDFOR", "READ", "WRITE", "PLUS", "MINUS", "DIV", "TIMES", "MOD", 
			"EQ", "NEQ", "LE", "GE", "LEQ", "GEQ", "WHITESPACE", "PIDENTIFIER", "CHARACTER"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public languageLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "language.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2+\u011b\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\3\2\3\2"+
		"\3\3\3\3\7\3Z\n\3\f\3\16\3]\13\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3"+
		"\6\5\6i\n\6\3\6\6\6l\n\6\r\6\16\6m\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n"+
		"\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3"+
		"\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3"+
		"\22\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3"+
		"\24\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3"+
		"\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3"+
		"\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3"+
		"\34\3\34\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3"+
		"\37\3\37\3\37\3 \3 \3 \3 \3 \3 \3!\3!\3!\3!\3\"\3\"\3\"\3#\3#\3#\3#\3"+
		"$\3$\3$\3%\3%\3%\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3(\6(\u010e\n(\r(\16(\u010f"+
		"\3)\6)\u0113\n)\r)\16)\u0114\3*\6*\u0118\n*\r*\16*\u0119\3[\2+\3\3\5\4"+
		"\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22"+
		"#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C"+
		"#E$G%I&K\'M(O)Q*S+\3\2\6\3\2\62;\5\2\13\f\16\17\"\"\4\2aac|\4\2C\\c|\2"+
		"\u0120\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2"+
		"\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3"+
		"\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2"+
		"\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2"+
		"/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2"+
		"\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2"+
		"G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3"+
		"\2\2\2\3U\3\2\2\2\5W\3\2\2\2\7b\3\2\2\2\te\3\2\2\2\13h\3\2\2\2\ro\3\2"+
		"\2\2\17q\3\2\2\2\21s\3\2\2\2\23u\3\2\2\2\25y\3\2\2\2\27\177\3\2\2\2\31"+
		"\u0083\3\2\2\2\33\u008a\3\2\2\2\35\u008f\3\2\2\2\37\u0094\3\2\2\2!\u009a"+
		"\3\2\2\2#\u00a0\3\2\2\2%\u00a7\3\2\2\2\'\u00aa\3\2\2\2)\u00b3\3\2\2\2"+
		"+\u00b9\3\2\2\2-\u00bd\3\2\2\2/\u00c2\3\2\2\2\61\u00c9\3\2\2\2\63\u00cc"+
		"\3\2\2\2\65\u00d3\3\2\2\2\67\u00d8\3\2\2\29\u00de\3\2\2\2;\u00e3\3\2\2"+
		"\2=\u00e9\3\2\2\2?\u00ed\3\2\2\2A\u00f3\3\2\2\2C\u00f7\3\2\2\2E\u00fa"+
		"\3\2\2\2G\u00fe\3\2\2\2I\u0101\3\2\2\2K\u0104\3\2\2\2M\u0108\3\2\2\2O"+
		"\u010d\3\2\2\2Q\u0112\3\2\2\2S\u0117\3\2\2\2UV\7<\2\2V\4\3\2\2\2W[\7*"+
		"\2\2XZ\13\2\2\2YX\3\2\2\2Z]\3\2\2\2[\\\3\2\2\2[Y\3\2\2\2\\^\3\2\2\2]["+
		"\3\2\2\2^_\7+\2\2_`\3\2\2\2`a\b\3\2\2a\6\3\2\2\2bc\7K\2\2cd\7H\2\2d\b"+
		"\3\2\2\2ef\7.\2\2f\n\3\2\2\2gi\7/\2\2hg\3\2\2\2hi\3\2\2\2ik\3\2\2\2jl"+
		"\t\2\2\2kj\3\2\2\2lm\3\2\2\2mk\3\2\2\2mn\3\2\2\2n\f\3\2\2\2op\7]\2\2p"+
		"\16\3\2\2\2qr\7_\2\2r\20\3\2\2\2st\7=\2\2t\22\3\2\2\2uv\7X\2\2vw\7C\2"+
		"\2wx\7T\2\2x\24\3\2\2\2yz\7D\2\2z{\7G\2\2{|\7I\2\2|}\7K\2\2}~\7P\2\2~"+
		"\26\3\2\2\2\177\u0080\7G\2\2\u0080\u0081\7P\2\2\u0081\u0082\7F\2\2\u0082"+
		"\30\3\2\2\2\u0083\u0084\7C\2\2\u0084\u0085\7U\2\2\u0085\u0086\7U\2\2\u0086"+
		"\u0087\7K\2\2\u0087\u0088\7I\2\2\u0088\u0089\7P\2\2\u0089\32\3\2\2\2\u008a"+
		"\u008b\7G\2\2\u008b\u008c\7N\2\2\u008c\u008d\7U\2\2\u008d\u008e\7G\2\2"+
		"\u008e\34\3\2\2\2\u008f\u0090\7V\2\2\u0090\u0091\7J\2\2\u0091\u0092\7"+
		"G\2\2\u0092\u0093\7P\2\2\u0093\36\3\2\2\2\u0094\u0095\7G\2\2\u0095\u0096"+
		"\7P\2\2\u0096\u0097\7F\2\2\u0097\u0098\7K\2\2\u0098\u0099\7H\2\2\u0099"+
		" \3\2\2\2\u009a\u009b\7Y\2\2\u009b\u009c\7J\2\2\u009c\u009d\7K\2\2\u009d"+
		"\u009e\7N\2\2\u009e\u009f\7G\2\2\u009f\"\3\2\2\2\u00a0\u00a1\7T\2\2\u00a1"+
		"\u00a2\7G\2\2\u00a2\u00a3\7R\2\2\u00a3\u00a4\7G\2\2\u00a4\u00a5\7C\2\2"+
		"\u00a5\u00a6\7V\2\2\u00a6$\3\2\2\2\u00a7\u00a8\7F\2\2\u00a8\u00a9\7Q\2"+
		"\2\u00a9&\3\2\2\2\u00aa\u00ab\7G\2\2\u00ab\u00ac\7P\2\2\u00ac\u00ad\7"+
		"F\2\2\u00ad\u00ae\7Y\2\2\u00ae\u00af\7J\2\2\u00af\u00b0\7K\2\2\u00b0\u00b1"+
		"\7N\2\2\u00b1\u00b2\7G\2\2\u00b2(\3\2\2\2\u00b3\u00b4\7W\2\2\u00b4\u00b5"+
		"\7P\2\2\u00b5\u00b6\7V\2\2\u00b6\u00b7\7K\2\2\u00b7\u00b8\7N\2\2\u00b8"+
		"*\3\2\2\2\u00b9\u00ba\7H\2\2\u00ba\u00bb\7Q\2\2\u00bb\u00bc\7T\2\2\u00bc"+
		",\3\2\2\2\u00bd\u00be\7H\2\2\u00be\u00bf\7T\2\2\u00bf\u00c0\7Q\2\2\u00c0"+
		"\u00c1\7O\2\2\u00c1.\3\2\2\2\u00c2\u00c3\7F\2\2\u00c3\u00c4\7Q\2\2\u00c4"+
		"\u00c5\7Y\2\2\u00c5\u00c6\7P\2\2\u00c6\u00c7\7V\2\2\u00c7\u00c8\7Q\2\2"+
		"\u00c8\60\3\2\2\2\u00c9\u00ca\7V\2\2\u00ca\u00cb\7Q\2\2\u00cb\62\3\2\2"+
		"\2\u00cc\u00cd\7G\2\2\u00cd\u00ce\7P\2\2\u00ce\u00cf\7F\2\2\u00cf\u00d0"+
		"\7H\2\2\u00d0\u00d1\7Q\2\2\u00d1\u00d2\7T\2\2\u00d2\64\3\2\2\2\u00d3\u00d4"+
		"\7T\2\2\u00d4\u00d5\7G\2\2\u00d5\u00d6\7C\2\2\u00d6\u00d7\7F\2\2\u00d7"+
		"\66\3\2\2\2\u00d8\u00d9\7Y\2\2\u00d9\u00da\7T\2\2\u00da\u00db\7K\2\2\u00db"+
		"\u00dc\7V\2\2\u00dc\u00dd\7G\2\2\u00dd8\3\2\2\2\u00de\u00df\7R\2\2\u00df"+
		"\u00e0\7N\2\2\u00e0\u00e1\7W\2\2\u00e1\u00e2\7U\2\2\u00e2:\3\2\2\2\u00e3"+
		"\u00e4\7O\2\2\u00e4\u00e5\7K\2\2\u00e5\u00e6\7P\2\2\u00e6\u00e7\7W\2\2"+
		"\u00e7\u00e8\7U\2\2\u00e8<\3\2\2\2\u00e9\u00ea\7F\2\2\u00ea\u00eb\7K\2"+
		"\2\u00eb\u00ec\7X\2\2\u00ec>\3\2\2\2\u00ed\u00ee\7V\2\2\u00ee\u00ef\7"+
		"K\2\2\u00ef\u00f0\7O\2\2\u00f0\u00f1\7G\2\2\u00f1\u00f2\7U\2\2\u00f2@"+
		"\3\2\2\2\u00f3\u00f4\7O\2\2\u00f4\u00f5\7Q\2\2\u00f5\u00f6\7F\2\2\u00f6"+
		"B\3\2\2\2\u00f7\u00f8\7G\2\2\u00f8\u00f9\7S\2\2\u00f9D\3\2\2\2\u00fa\u00fb"+
		"\7P\2\2\u00fb\u00fc\7G\2\2\u00fc\u00fd\7S\2\2\u00fdF\3\2\2\2\u00fe\u00ff"+
		"\7N\2\2\u00ff\u0100\7G\2\2\u0100H\3\2\2\2\u0101\u0102\7I\2\2\u0102\u0103"+
		"\7G\2\2\u0103J\3\2\2\2\u0104\u0105\7N\2\2\u0105\u0106\7G\2\2\u0106\u0107"+
		"\7S\2\2\u0107L\3\2\2\2\u0108\u0109\7I\2\2\u0109\u010a\7G\2\2\u010a\u010b"+
		"\7S\2\2\u010bN\3\2\2\2\u010c\u010e\t\3\2\2\u010d\u010c\3\2\2\2\u010e\u010f"+
		"\3\2\2\2\u010f\u010d\3\2\2\2\u010f\u0110\3\2\2\2\u0110P\3\2\2\2\u0111"+
		"\u0113\t\4\2\2\u0112\u0111\3\2\2\2\u0113\u0114\3\2\2\2\u0114\u0112\3\2"+
		"\2\2\u0114\u0115\3\2\2\2\u0115R\3\2\2\2\u0116\u0118\t\5\2\2\u0117\u0116"+
		"\3\2\2\2\u0118\u0119\3\2\2\2\u0119\u0117\3\2\2\2\u0119\u011a\3\2\2\2\u011a"+
		"T\3\2\2\2\t\2[hm\u010f\u0114\u0119\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}