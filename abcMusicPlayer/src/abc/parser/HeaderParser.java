// Generated from Header.g4 by ANTLR 4.5.1

package abc.parser;
// Do not edit this .java file! Edit the .g4 file and re-run Antlr.

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class HeaderParser extends Parser {
  static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

  protected static final DFA[] _decisionToDFA;
  protected static final PredictionContextCache _sharedContextCache =
    new PredictionContextCache();
  public static final int
    T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
    T__9=10, T__10=11, NUMBER=12, K=13, SPACES=14, NEWLINE=15, ANYCHAR=16, 
    COMMENT=17;
  public static final int
    RULE_root = 0, RULE_header = 1, RULE_element = 2, RULE_x = 3, RULE_t = 4, 
    RULE_c = 5, RULE_l = 6, RULE_m = 7, RULE_q = 8, RULE_v = 9, RULE_notnewline = 10;
  public static final String[] ruleNames = {
    "root", "header", "element", "x", "t", "c", "l", "m", "q", "v", "notnewline"
  };

  private static final String[] _LITERAL_NAMES = {
    null, "'X:'", "'T:'", "'C:'", "'L:'", "'/'", "'M:'", "'C'", "'C|'", 
    "'Q:'", "'='", "'V:'"
  };
  private static final String[] _SYMBOLIC_NAMES = {
    null, null, null, null, null, null, null, null, null, null, null, null, 
    "NUMBER", "K", "SPACES", "NEWLINE", "ANYCHAR", "COMMENT"
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

  @Override
  public String getGrammarFileName() { return "Header.g4"; }

  @Override
  public String[] getRuleNames() { return ruleNames; }

  @Override
  public String getSerializedATN() { return _serializedATN; }

  @Override
  public ATN getATN() { return _ATN; }


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

  public HeaderParser(TokenStream input) {
    super(input);
    _interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
  }
  public static class RootContext extends ParserRuleContext {
    public HeaderContext header() {
      return getRuleContext(HeaderContext.class,0);
    }
    public TerminalNode EOF() { return getToken(HeaderParser.EOF, 0); }
    public RootContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_root; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).enterRoot(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).exitRoot(this);
    }
  }

  public final RootContext root() throws RecognitionException {
    RootContext _localctx = new RootContext(_ctx, getState());
    enterRule(_localctx, 0, RULE_root);
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(22);
      header();
      setState(23);
      match(EOF);
      }
    }
    catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    }
    finally {
      exitRule();
    }
    return _localctx;
  }

  public static class HeaderContext extends ParserRuleContext {
    public XContext x() {
      return getRuleContext(XContext.class,0);
    }
    public TContext t() {
      return getRuleContext(TContext.class,0);
    }
    public TerminalNode K() { return getToken(HeaderParser.K, 0); }
    public List<ElementContext> element() {
      return getRuleContexts(ElementContext.class);
    }
    public ElementContext element(int i) {
      return getRuleContext(ElementContext.class,i);
    }
    public HeaderContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_header; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).enterHeader(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).exitHeader(this);
    }
  }

  public final HeaderContext header() throws RecognitionException {
    HeaderContext _localctx = new HeaderContext(_ctx, getState());
    enterRule(_localctx, 2, RULE_header);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(25);
      x();
      setState(26);
      t();
      setState(30);
      _errHandler.sync(this);
      _la = _input.LA(1);
      while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__5) | (1L << T__8) | (1L << T__10))) != 0)) {
        {
        {
        setState(27);
        element();
        }
        }
        setState(32);
        _errHandler.sync(this);
        _la = _input.LA(1);
      }
      setState(33);
      match(K);
      }
    }
    catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    }
    finally {
      exitRule();
    }
    return _localctx;
  }

  public static class ElementContext extends ParserRuleContext {
    public CContext c() {
      return getRuleContext(CContext.class,0);
    }
    public LContext l() {
      return getRuleContext(LContext.class,0);
    }
    public MContext m() {
      return getRuleContext(MContext.class,0);
    }
    public QContext q() {
      return getRuleContext(QContext.class,0);
    }
    public VContext v() {
      return getRuleContext(VContext.class,0);
    }
    public ElementContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_element; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).enterElement(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).exitElement(this);
    }
  }

  public final ElementContext element() throws RecognitionException {
    ElementContext _localctx = new ElementContext(_ctx, getState());
    enterRule(_localctx, 4, RULE_element);
    try {
      setState(40);
      switch (_input.LA(1)) {
      case T__2:
        enterOuterAlt(_localctx, 1);
        {
        setState(35);
        c();
        }
        break;
      case T__3:
        enterOuterAlt(_localctx, 2);
        {
        setState(36);
        l();
        }
        break;
      case T__5:
        enterOuterAlt(_localctx, 3);
        {
        setState(37);
        m();
        }
        break;
      case T__8:
        enterOuterAlt(_localctx, 4);
        {
        setState(38);
        q();
        }
        break;
      case T__10:
        enterOuterAlt(_localctx, 5);
        {
        setState(39);
        v();
        }
        break;
      default:
        throw new NoViableAltException(this);
      }
    }
    catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    }
    finally {
      exitRule();
    }
    return _localctx;
  }

  public static class XContext extends ParserRuleContext {
    public TerminalNode NUMBER() { return getToken(HeaderParser.NUMBER, 0); }
    public TerminalNode NEWLINE() { return getToken(HeaderParser.NEWLINE, 0); }
    public XContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_x; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).enterX(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).exitX(this);
    }
  }

  public final XContext x() throws RecognitionException {
    XContext _localctx = new XContext(_ctx, getState());
    enterRule(_localctx, 6, RULE_x);
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(42);
      match(T__0);
      setState(43);
      match(NUMBER);
      setState(44);
      match(NEWLINE);
      }
    }
    catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    }
    finally {
      exitRule();
    }
    return _localctx;
  }

  public static class TContext extends ParserRuleContext {
    public TerminalNode NEWLINE() { return getToken(HeaderParser.NEWLINE, 0); }
    public List<NotnewlineContext> notnewline() {
      return getRuleContexts(NotnewlineContext.class);
    }
    public NotnewlineContext notnewline(int i) {
      return getRuleContext(NotnewlineContext.class,i);
    }
    public TContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_t; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).enterT(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).exitT(this);
    }
  }

  public final TContext t() throws RecognitionException {
    TContext _localctx = new TContext(_ctx, getState());
    enterRule(_localctx, 8, RULE_t);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(46);
      match(T__1);
      setState(48); 
      _errHandler.sync(this);
      _la = _input.LA(1);
      do {
        {
        {
        setState(47);
        notnewline();
        }
        }
        setState(50); 
        _errHandler.sync(this);
        _la = _input.LA(1);
      } while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << NUMBER) | (1L << K) | (1L << SPACES) | (1L << ANYCHAR) | (1L << COMMENT))) != 0) );
      setState(52);
      match(NEWLINE);
      }
    }
    catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    }
    finally {
      exitRule();
    }
    return _localctx;
  }

  public static class CContext extends ParserRuleContext {
    public TerminalNode NEWLINE() { return getToken(HeaderParser.NEWLINE, 0); }
    public List<NotnewlineContext> notnewline() {
      return getRuleContexts(NotnewlineContext.class);
    }
    public NotnewlineContext notnewline(int i) {
      return getRuleContext(NotnewlineContext.class,i);
    }
    public CContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_c; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).enterC(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).exitC(this);
    }
  }

  public final CContext c() throws RecognitionException {
    CContext _localctx = new CContext(_ctx, getState());
    enterRule(_localctx, 10, RULE_c);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(54);
      match(T__2);
      setState(56); 
      _errHandler.sync(this);
      _la = _input.LA(1);
      do {
        {
        {
        setState(55);
        notnewline();
        }
        }
        setState(58); 
        _errHandler.sync(this);
        _la = _input.LA(1);
      } while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << NUMBER) | (1L << K) | (1L << SPACES) | (1L << ANYCHAR) | (1L << COMMENT))) != 0) );
      setState(60);
      match(NEWLINE);
      }
    }
    catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    }
    finally {
      exitRule();
    }
    return _localctx;
  }

  public static class LContext extends ParserRuleContext {
    public List<TerminalNode> NUMBER() { return getTokens(HeaderParser.NUMBER); }
    public TerminalNode NUMBER(int i) {
      return getToken(HeaderParser.NUMBER, i);
    }
    public TerminalNode NEWLINE() { return getToken(HeaderParser.NEWLINE, 0); }
    public LContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_l; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).enterL(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).exitL(this);
    }
  }

  public final LContext l() throws RecognitionException {
    LContext _localctx = new LContext(_ctx, getState());
    enterRule(_localctx, 12, RULE_l);
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(62);
      match(T__3);
      setState(63);
      match(NUMBER);
      setState(64);
      match(T__4);
      setState(65);
      match(NUMBER);
      setState(66);
      match(NEWLINE);
      }
    }
    catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    }
    finally {
      exitRule();
    }
    return _localctx;
  }

  public static class MContext extends ParserRuleContext {
    public TerminalNode NEWLINE() { return getToken(HeaderParser.NEWLINE, 0); }
    public List<TerminalNode> NUMBER() { return getTokens(HeaderParser.NUMBER); }
    public TerminalNode NUMBER(int i) {
      return getToken(HeaderParser.NUMBER, i);
    }
    public MContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_m; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).enterM(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).exitM(this);
    }
  }

  public final MContext m() throws RecognitionException {
    MContext _localctx = new MContext(_ctx, getState());
    enterRule(_localctx, 14, RULE_m);
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(68);
      match(T__5);
      setState(74);
      switch (_input.LA(1)) {
      case NUMBER:
        {
        {
        setState(69);
        match(NUMBER);
        setState(70);
        match(T__4);
        setState(71);
        match(NUMBER);
        }
        }
        break;
      case T__6:
        {
        setState(72);
        match(T__6);
        }
        break;
      case T__7:
        {
        setState(73);
        match(T__7);
        }
        break;
      default:
        throw new NoViableAltException(this);
      }
      setState(76);
      match(NEWLINE);
      }
    }
    catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    }
    finally {
      exitRule();
    }
    return _localctx;
  }

  public static class QContext extends ParserRuleContext {
    public List<TerminalNode> NUMBER() { return getTokens(HeaderParser.NUMBER); }
    public TerminalNode NUMBER(int i) {
      return getToken(HeaderParser.NUMBER, i);
    }
    public TerminalNode NEWLINE() { return getToken(HeaderParser.NEWLINE, 0); }
    public QContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_q; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).enterQ(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).exitQ(this);
    }
  }

  public final QContext q() throws RecognitionException {
    QContext _localctx = new QContext(_ctx, getState());
    enterRule(_localctx, 16, RULE_q);
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(78);
      match(T__8);
      setState(79);
      match(NUMBER);
      setState(80);
      match(T__4);
      setState(81);
      match(NUMBER);
      setState(82);
      match(T__9);
      setState(83);
      match(NUMBER);
      setState(84);
      match(NEWLINE);
      }
    }
    catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    }
    finally {
      exitRule();
    }
    return _localctx;
  }

  public static class VContext extends ParserRuleContext {
    public TerminalNode NEWLINE() { return getToken(HeaderParser.NEWLINE, 0); }
    public List<NotnewlineContext> notnewline() {
      return getRuleContexts(NotnewlineContext.class);
    }
    public NotnewlineContext notnewline(int i) {
      return getRuleContext(NotnewlineContext.class,i);
    }
    public VContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_v; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).enterV(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).exitV(this);
    }
  }

  public final VContext v() throws RecognitionException {
    VContext _localctx = new VContext(_ctx, getState());
    enterRule(_localctx, 18, RULE_v);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(86);
      match(T__10);
      setState(88); 
      _errHandler.sync(this);
      _la = _input.LA(1);
      do {
        {
        {
        setState(87);
        notnewline();
        }
        }
        setState(90); 
        _errHandler.sync(this);
        _la = _input.LA(1);
      } while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << NUMBER) | (1L << K) | (1L << SPACES) | (1L << ANYCHAR) | (1L << COMMENT))) != 0) );
      setState(92);
      match(NEWLINE);
      }
    }
    catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    }
    finally {
      exitRule();
    }
    return _localctx;
  }

  public static class NotnewlineContext extends ParserRuleContext {
    public TerminalNode NEWLINE() { return getToken(HeaderParser.NEWLINE, 0); }
    public NotnewlineContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_notnewline; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).enterNotnewline(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).exitNotnewline(this);
    }
  }

  public final NotnewlineContext notnewline() throws RecognitionException {
    NotnewlineContext _localctx = new NotnewlineContext(_ctx, getState());
    enterRule(_localctx, 20, RULE_notnewline);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(94);
      _la = _input.LA(1);
      if ( _la <= 0 || (_la==NEWLINE) ) {
      _errHandler.recoverInline(this);
      } else {
        consume();
      }
      }
    }
    catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    }
    finally {
      exitRule();
    }
    return _localctx;
  }

  public static final String _serializedATN =
    "\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\23c\4\2\t\2\4\3"+
      "\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
      "\t\13\4\f\t\f\3\2\3\2\3\2\3\3\3\3\3\3\7\3\37\n\3\f\3\16\3\"\13\3\3"+
      "\3\3\3\3\4\3\4\3\4\3\4\3\4\5\4+\n\4\3\5\3\5\3\5\3\5\3\6\3\6\6\6\63"+
      "\n\6\r\6\16\6\64\3\6\3\6\3\7\3\7\6\7;\n\7\r\7\16\7<\3\7\3\7\3\b\3"+
      "\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\5\tM\n\t\3\t\3\t\3\n\3"+
      "\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\6\13[\n\13\r\13\16\13\\\3\13"+
      "\3\13\3\f\3\f\3\f\2\2\r\2\4\6\b\n\f\16\20\22\24\26\2\3\3\2\21\21a"+
      "\2\30\3\2\2\2\4\33\3\2\2\2\6*\3\2\2\2\b,\3\2\2\2\n\60\3\2\2\2\f8\3"+
      "\2\2\2\16@\3\2\2\2\20F\3\2\2\2\22P\3\2\2\2\24X\3\2\2\2\26`\3\2\2\2"+
      "\30\31\5\4\3\2\31\32\7\2\2\3\32\3\3\2\2\2\33\34\5\b\5\2\34 \5\n\6"+
      "\2\35\37\5\6\4\2\36\35\3\2\2\2\37\"\3\2\2\2 \36\3\2\2\2 !\3\2\2\2"+
      "!#\3\2\2\2\" \3\2\2\2#$\7\17\2\2$\5\3\2\2\2%+\5\f\7\2&+\5\16\b\2\'"+
      "+\5\20\t\2(+\5\22\n\2)+\5\24\13\2*%\3\2\2\2*&\3\2\2\2*\'\3\2\2\2*"+
      "(\3\2\2\2*)\3\2\2\2+\7\3\2\2\2,-\7\3\2\2-.\7\16\2\2./\7\21\2\2/\t"+
      "\3\2\2\2\60\62\7\4\2\2\61\63\5\26\f\2\62\61\3\2\2\2\63\64\3\2\2\2"+
      "\64\62\3\2\2\2\64\65\3\2\2\2\65\66\3\2\2\2\66\67\7\21\2\2\67\13\3"+
      "\2\2\28:\7\5\2\29;\5\26\f\2:9\3\2\2\2;<\3\2\2\2<:\3\2\2\2<=\3\2\2"+
      "\2=>\3\2\2\2>?\7\21\2\2?\r\3\2\2\2@A\7\6\2\2AB\7\16\2\2BC\7\7\2\2"+
      "CD\7\16\2\2DE\7\21\2\2E\17\3\2\2\2FL\7\b\2\2GH\7\16\2\2HI\7\7\2\2"+
      "IM\7\16\2\2JM\7\t\2\2KM\7\n\2\2LG\3\2\2\2LJ\3\2\2\2LK\3\2\2\2MN\3"+
      "\2\2\2NO\7\21\2\2O\21\3\2\2\2PQ\7\13\2\2QR\7\16\2\2RS\7\7\2\2ST\7"+
      "\16\2\2TU\7\f\2\2UV\7\16\2\2VW\7\21\2\2W\23\3\2\2\2XZ\7\r\2\2Y[\5"+
      "\26\f\2ZY\3\2\2\2[\\\3\2\2\2\\Z\3\2\2\2\\]\3\2\2\2]^\3\2\2\2^_\7\21"+
      "\2\2_\25\3\2\2\2`a\n\2\2\2a\27\3\2\2\2\b *\64<L\\";
  public static final ATN _ATN =
    new ATNDeserializer().deserialize(_serializedATN.toCharArray());
  static {
    _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
    for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
      _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
    }
  }
}