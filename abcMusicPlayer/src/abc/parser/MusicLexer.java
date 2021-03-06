// Generated from Music.g4 by ANTLR 4.5.1

package abc.parser;
// Do not edit this .java file! Edit the .g4 file and re-run Antlr.

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MusicLexer extends Lexer {
  static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

  protected static final DFA[] _decisionToDFA;
  protected static final PredictionContextCache _sharedContextCache =
    new PredictionContextCache();
  public static final int
    T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, DIVIDER=8, LOWERPITCH=9, 
    HIGHERPITCH=10, OCTAVE=11, ACCIDENTAL=12, NUMBER=13, SPACES=14, NEWLINE=15;
  public static String[] modeNames = {
    "DEFAULT_MODE"
  };

  public static final String[] ruleNames = {
    "T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "DIVIDER", "LOWERPITCH", 
    "HIGHERPITCH", "OCTAVE", "ACCIDENTAL", "NUMBER", "SPACES", "NEWLINE"
  };

  private static final String[] _LITERAL_NAMES = {
    null, "'/'", "'z'", "'['", "']'", "'(2'", "'(3'", "'(4'"
  };
  private static final String[] _SYMBOLIC_NAMES = {
    null, null, null, null, null, null, null, null, "DIVIDER", "LOWERPITCH", 
    "HIGHERPITCH", "OCTAVE", "ACCIDENTAL", "NUMBER", "SPACES", "NEWLINE"
  };
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


      // This method makes the parser stop running if it encounters
      // invalid input and throw a RuntimeException.
      public void reportErrorsAsExceptions() {
          // To prevent any reports to standard error, add this line:
          //removeErrorListeners();
          
          addErrorListener(new BaseErrorListener() {
              public void syntaxError(Recognizer<?, ?> recognizer,
                                      Object offendingSymbol, 
                                      int line, int charPositionInLine,
                                      String msg, RecognitionException e) {
                  throw new ParseCancellationException(msg, e);
              }
          });
      }


  public MusicLexer(CharStream input) {
    super(input);
    _interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
  }

  @Override
  public String getGrammarFileName() { return "Music.g4"; }

  @Override
  public String[] getRuleNames() { return ruleNames; }

  @Override
  public String getSerializedATN() { return _serializedATN; }

  @Override
  public String[] getModeNames() { return modeNames; }

  @Override
  public ATN getATN() { return _ATN; }

  public static final String _serializedATN =
    "\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\21i\b\1\4\2\t\2"+
      "\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
      "\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\3\3"+
      "\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3"+
      "\t\3\t\3\t\3\t\3\t\5\t:\n\t\3\n\3\n\3\13\3\13\3\f\6\fA\n\f\r\f\16"+
      "\fB\3\f\6\fF\n\f\r\f\16\fG\5\fJ\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5"+
      "\rS\n\r\3\16\6\16V\n\16\r\16\16\16W\3\17\6\17[\n\17\r\17\16\17\\\3"+
      "\17\3\17\5\17a\n\17\3\17\3\17\3\20\3\20\3\20\5\20h\n\20\2\2\21\3\3"+
      "\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20"+
      "\37\21\3\2\n\3\2CI\3\2ci\3\2..\3\2))\3\2\62;\3\2\"\"\3\2\13\13\4\2"+
      "\f\f\17\17w\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3"+
      "\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2"+
      "\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2"+
      "\2\2\3!\3\2\2\2\5#\3\2\2\2\7%\3\2\2\2\t\'\3\2\2\2\13)\3\2\2\2\r,\3"+
      "\2\2\2\17/\3\2\2\2\219\3\2\2\2\23;\3\2\2\2\25=\3\2\2\2\27I\3\2\2\2"+
      "\31R\3\2\2\2\33U\3\2\2\2\35`\3\2\2\2\37g\3\2\2\2!\"\7\61\2\2\"\4\3"+
      "\2\2\2#$\7|\2\2$\6\3\2\2\2%&\7]\2\2&\b\3\2\2\2\'(\7_\2\2(\n\3\2\2"+
      "\2)*\7*\2\2*+\7\64\2\2+\f\3\2\2\2,-\7*\2\2-.\7\65\2\2.\16\3\2\2\2"+
      "/\60\7*\2\2\60\61\7\66\2\2\61\20\3\2\2\2\62:\7~\2\2\63\64\7~\2\2\64"+
      ":\7~\2\2\65\66\7~\2\2\66:\7_\2\2\678\7]\2\28:\7~\2\29\62\3\2\2\29"+
      "\63\3\2\2\29\65\3\2\2\29\67\3\2\2\2:\22\3\2\2\2;<\t\2\2\2<\24\3\2"+
      "\2\2=>\t\3\2\2>\26\3\2\2\2?A\t\4\2\2@?\3\2\2\2AB\3\2\2\2B@\3\2\2\2"+
      "BC\3\2\2\2CJ\3\2\2\2DF\t\5\2\2ED\3\2\2\2FG\3\2\2\2GE\3\2\2\2GH\3\2"+
      "\2\2HJ\3\2\2\2I@\3\2\2\2IE\3\2\2\2J\30\3\2\2\2KS\7`\2\2LM\7`\2\2M"+
      "S\7`\2\2NS\7a\2\2OP\7a\2\2PS\7a\2\2QS\7?\2\2RK\3\2\2\2RL\3\2\2\2R"+
      "N\3\2\2\2RO\3\2\2\2RQ\3\2\2\2S\32\3\2\2\2TV\t\6\2\2UT\3\2\2\2VW\3"+
      "\2\2\2WU\3\2\2\2WX\3\2\2\2X\34\3\2\2\2Y[\t\7\2\2ZY\3\2\2\2[\\\3\2"+
      "\2\2\\Z\3\2\2\2\\]\3\2\2\2]a\3\2\2\2^a\t\b\2\2_a\5\37\20\2`Z\3\2\2"+
      "\2`^\3\2\2\2`_\3\2\2\2ab\3\2\2\2bc\b\17\2\2c\36\3\2\2\2dh\t\t\2\2"+
      "ef\7\17\2\2fh\7\f\2\2gd\3\2\2\2ge\3\2\2\2h \3\2\2\2\f\29BGIRW\\`g"+
      "\3\b\2\2";
  public static final ATN _ATN =
    new ATNDeserializer().deserialize(_serializedATN.toCharArray());
  static {
    _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
    for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
      _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
    }
  }
}