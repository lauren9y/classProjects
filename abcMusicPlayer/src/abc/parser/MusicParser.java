// Generated from Music.g4 by ANTLR 4.5.1

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
public class MusicParser extends Parser {
  static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

  protected static final DFA[] _decisionToDFA;
  protected static final PredictionContextCache _sharedContextCache =
    new PredictionContextCache();
  public static final int
    T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, DIVIDER=8, LOWERPITCH=9, 
    HIGHERPITCH=10, OCTAVE=11, ACCIDENTAL=12, NUMBER=13, SPACES=14, NEWLINE=15;
  public static final int
    RULE_root = 0, RULE_voice = 1, RULE_measure = 2, RULE_note = 3, RULE_pitch = 4, 
    RULE_length = 5, RULE_fraction = 6, RULE_denominator = 7, RULE_rest = 8, 
    RULE_chord = 9, RULE_duplet = 10, RULE_triplet = 11, RULE_quadruplet = 12, 
    RULE_tuplet = 13, RULE_element = 14;
  public static final String[] ruleNames = {
    "root", "voice", "measure", "note", "pitch", "length", "fraction", "denominator", 
    "rest", "chord", "duplet", "triplet", "quadruplet", "tuplet", "element"
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

  @Override
  public String getGrammarFileName() { return "Music.g4"; }

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

  public MusicParser(TokenStream input) {
    super(input);
    _interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
  }
  public static class RootContext extends ParserRuleContext {
    public VoiceContext voice() {
      return getRuleContext(VoiceContext.class,0);
    }
    public TerminalNode EOF() { return getToken(MusicParser.EOF, 0); }
    public RootContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_root; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof MusicListener ) ((MusicListener)listener).enterRoot(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof MusicListener ) ((MusicListener)listener).exitRoot(this);
    }
  }

  public final RootContext root() throws RecognitionException {
    RootContext _localctx = new RootContext(_ctx, getState());
    enterRule(_localctx, 0, RULE_root);
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(30);
      voice();
      setState(31);
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

  public static class VoiceContext extends ParserRuleContext {
    public List<TerminalNode> DIVIDER() { return getTokens(MusicParser.DIVIDER); }
    public TerminalNode DIVIDER(int i) {
      return getToken(MusicParser.DIVIDER, i);
    }
    public List<MeasureContext> measure() {
      return getRuleContexts(MeasureContext.class);
    }
    public MeasureContext measure(int i) {
      return getRuleContext(MeasureContext.class,i);
    }
    public VoiceContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_voice; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof MusicListener ) ((MusicListener)listener).enterVoice(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof MusicListener ) ((MusicListener)listener).exitVoice(this);
    }
  }

  public final VoiceContext voice() throws RecognitionException {
    VoiceContext _localctx = new VoiceContext(_ctx, getState());
    enterRule(_localctx, 2, RULE_voice);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(34);
      _la = _input.LA(1);
      if (_la==DIVIDER) {
        {
        setState(33);
        match(DIVIDER);
        }
      }

      setState(40); 
      _errHandler.sync(this);
      _la = _input.LA(1);
      do {
        {
        {
        setState(36);
        measure();
        setState(38);
        _la = _input.LA(1);
        if (_la==DIVIDER) {
          {
          setState(37);
          match(DIVIDER);
          }
        }

        }
        }
        setState(42); 
        _errHandler.sync(this);
        _la = _input.LA(1);
      } while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__2) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << LOWERPITCH) | (1L << HIGHERPITCH) | (1L << ACCIDENTAL))) != 0) );
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

  public static class MeasureContext extends ParserRuleContext {
    public List<ElementContext> element() {
      return getRuleContexts(ElementContext.class);
    }
    public ElementContext element(int i) {
      return getRuleContext(ElementContext.class,i);
    }
    public MeasureContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_measure; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof MusicListener ) ((MusicListener)listener).enterMeasure(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof MusicListener ) ((MusicListener)listener).exitMeasure(this);
    }
  }

  public final MeasureContext measure() throws RecognitionException {
    MeasureContext _localctx = new MeasureContext(_ctx, getState());
    enterRule(_localctx, 4, RULE_measure);
    try {
      int _alt;
      enterOuterAlt(_localctx, 1);
      {
      setState(45); 
      _errHandler.sync(this);
      _alt = 1;
      do {
        switch (_alt) {
        case 1:
          {
          {
          setState(44);
          element();
          }
          }
          break;
        default:
          throw new NoViableAltException(this);
        }
        setState(47); 
        _errHandler.sync(this);
        _alt = getInterpreter().adaptivePredict(_input,3,_ctx);
      } while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

  public static class NoteContext extends ParserRuleContext {
    public PitchContext pitch() {
      return getRuleContext(PitchContext.class,0);
    }
    public TerminalNode ACCIDENTAL() { return getToken(MusicParser.ACCIDENTAL, 0); }
    public TerminalNode OCTAVE() { return getToken(MusicParser.OCTAVE, 0); }
    public LengthContext length() {
      return getRuleContext(LengthContext.class,0);
    }
    public NoteContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_note; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof MusicListener ) ((MusicListener)listener).enterNote(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof MusicListener ) ((MusicListener)listener).exitNote(this);
    }
  }

  public final NoteContext note() throws RecognitionException {
    NoteContext _localctx = new NoteContext(_ctx, getState());
    enterRule(_localctx, 6, RULE_note);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(50);
      _la = _input.LA(1);
      if (_la==ACCIDENTAL) {
        {
        setState(49);
        match(ACCIDENTAL);
        }
      }

      setState(52);
      pitch();
      setState(54);
      _la = _input.LA(1);
      if (_la==OCTAVE) {
        {
        setState(53);
        match(OCTAVE);
        }
      }

      setState(57);
      _la = _input.LA(1);
      if (_la==T__0 || _la==NUMBER) {
        {
        setState(56);
        length();
        }
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

  public static class PitchContext extends ParserRuleContext {
    public TerminalNode LOWERPITCH() { return getToken(MusicParser.LOWERPITCH, 0); }
    public TerminalNode HIGHERPITCH() { return getToken(MusicParser.HIGHERPITCH, 0); }
    public PitchContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_pitch; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof MusicListener ) ((MusicListener)listener).enterPitch(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof MusicListener ) ((MusicListener)listener).exitPitch(this);
    }
  }

  public final PitchContext pitch() throws RecognitionException {
    PitchContext _localctx = new PitchContext(_ctx, getState());
    enterRule(_localctx, 8, RULE_pitch);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(59);
      _la = _input.LA(1);
      if ( !(_la==LOWERPITCH || _la==HIGHERPITCH) ) {
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

  public static class LengthContext extends ParserRuleContext {
    public TerminalNode NUMBER() { return getToken(MusicParser.NUMBER, 0); }
    public FractionContext fraction() {
      return getRuleContext(FractionContext.class,0);
    }
    public DenominatorContext denominator() {
      return getRuleContext(DenominatorContext.class,0);
    }
    public LengthContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_length; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof MusicListener ) ((MusicListener)listener).enterLength(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof MusicListener ) ((MusicListener)listener).exitLength(this);
    }
  }

  public final LengthContext length() throws RecognitionException {
    LengthContext _localctx = new LengthContext(_ctx, getState());
    enterRule(_localctx, 10, RULE_length);
    try {
      setState(64);
      switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
      case 1:
        enterOuterAlt(_localctx, 1);
        {
        setState(61);
        match(NUMBER);
        }
        break;
      case 2:
        enterOuterAlt(_localctx, 2);
        {
        setState(62);
        fraction();
        }
        break;
      case 3:
        enterOuterAlt(_localctx, 3);
        {
        setState(63);
        denominator();
        }
        break;
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

  public static class FractionContext extends ParserRuleContext {
    public List<TerminalNode> NUMBER() { return getTokens(MusicParser.NUMBER); }
    public TerminalNode NUMBER(int i) {
      return getToken(MusicParser.NUMBER, i);
    }
    public FractionContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_fraction; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof MusicListener ) ((MusicListener)listener).enterFraction(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof MusicListener ) ((MusicListener)listener).exitFraction(this);
    }
  }

  public final FractionContext fraction() throws RecognitionException {
    FractionContext _localctx = new FractionContext(_ctx, getState());
    enterRule(_localctx, 12, RULE_fraction);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(66);
      match(NUMBER);
      setState(67);
      match(T__0);
      setState(69);
      _la = _input.LA(1);
      if (_la==NUMBER) {
        {
        setState(68);
        match(NUMBER);
        }
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

  public static class DenominatorContext extends ParserRuleContext {
    public TerminalNode NUMBER() { return getToken(MusicParser.NUMBER, 0); }
    public DenominatorContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_denominator; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof MusicListener ) ((MusicListener)listener).enterDenominator(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof MusicListener ) ((MusicListener)listener).exitDenominator(this);
    }
  }

  public final DenominatorContext denominator() throws RecognitionException {
    DenominatorContext _localctx = new DenominatorContext(_ctx, getState());
    enterRule(_localctx, 14, RULE_denominator);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(71);
      match(T__0);
      setState(73);
      _la = _input.LA(1);
      if (_la==NUMBER) {
        {
        setState(72);
        match(NUMBER);
        }
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

  public static class RestContext extends ParserRuleContext {
    public LengthContext length() {
      return getRuleContext(LengthContext.class,0);
    }
    public RestContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_rest; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof MusicListener ) ((MusicListener)listener).enterRest(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof MusicListener ) ((MusicListener)listener).exitRest(this);
    }
  }

  public final RestContext rest() throws RecognitionException {
    RestContext _localctx = new RestContext(_ctx, getState());
    enterRule(_localctx, 16, RULE_rest);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(75);
      match(T__1);
      setState(77);
      _la = _input.LA(1);
      if (_la==T__0 || _la==NUMBER) {
        {
        setState(76);
        length();
        }
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

  public static class ChordContext extends ParserRuleContext {
    public List<NoteContext> note() {
      return getRuleContexts(NoteContext.class);
    }
    public NoteContext note(int i) {
      return getRuleContext(NoteContext.class,i);
    }
    public ChordContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_chord; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof MusicListener ) ((MusicListener)listener).enterChord(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof MusicListener ) ((MusicListener)listener).exitChord(this);
    }
  }

  public final ChordContext chord() throws RecognitionException {
    ChordContext _localctx = new ChordContext(_ctx, getState());
    enterRule(_localctx, 18, RULE_chord);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(79);
      match(T__2);
      setState(81); 
      _errHandler.sync(this);
      _la = _input.LA(1);
      do {
        {
        {
        setState(80);
        note();
        }
        }
        setState(83); 
        _errHandler.sync(this);
        _la = _input.LA(1);
      } while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LOWERPITCH) | (1L << HIGHERPITCH) | (1L << ACCIDENTAL))) != 0) );
      setState(85);
      match(T__3);
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

  public static class DupletContext extends ParserRuleContext {
    public List<NoteContext> note() {
      return getRuleContexts(NoteContext.class);
    }
    public NoteContext note(int i) {
      return getRuleContext(NoteContext.class,i);
    }
    public List<ChordContext> chord() {
      return getRuleContexts(ChordContext.class);
    }
    public ChordContext chord(int i) {
      return getRuleContext(ChordContext.class,i);
    }
    public DupletContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_duplet; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof MusicListener ) ((MusicListener)listener).enterDuplet(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof MusicListener ) ((MusicListener)listener).exitDuplet(this);
    }
  }

  public final DupletContext duplet() throws RecognitionException {
    DupletContext _localctx = new DupletContext(_ctx, getState());
    enterRule(_localctx, 20, RULE_duplet);
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(87);
      match(T__4);
      setState(90);
      switch (_input.LA(1)) {
      case LOWERPITCH:
      case HIGHERPITCH:
      case ACCIDENTAL:
        {
        setState(88);
        note();
        }
        break;
      case T__2:
        {
        setState(89);
        chord();
        }
        break;
      default:
        throw new NoViableAltException(this);
      }
      setState(94);
      switch (_input.LA(1)) {
      case LOWERPITCH:
      case HIGHERPITCH:
      case ACCIDENTAL:
        {
        setState(92);
        note();
        }
        break;
      case T__2:
        {
        setState(93);
        chord();
        }
        break;
      default:
        throw new NoViableAltException(this);
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

  public static class TripletContext extends ParserRuleContext {
    public List<NoteContext> note() {
      return getRuleContexts(NoteContext.class);
    }
    public NoteContext note(int i) {
      return getRuleContext(NoteContext.class,i);
    }
    public List<ChordContext> chord() {
      return getRuleContexts(ChordContext.class);
    }
    public ChordContext chord(int i) {
      return getRuleContext(ChordContext.class,i);
    }
    public TripletContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_triplet; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof MusicListener ) ((MusicListener)listener).enterTriplet(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof MusicListener ) ((MusicListener)listener).exitTriplet(this);
    }
  }

  public final TripletContext triplet() throws RecognitionException {
    TripletContext _localctx = new TripletContext(_ctx, getState());
    enterRule(_localctx, 22, RULE_triplet);
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(96);
      match(T__5);
      setState(99);
      switch (_input.LA(1)) {
      case LOWERPITCH:
      case HIGHERPITCH:
      case ACCIDENTAL:
        {
        setState(97);
        note();
        }
        break;
      case T__2:
        {
        setState(98);
        chord();
        }
        break;
      default:
        throw new NoViableAltException(this);
      }
      setState(103);
      switch (_input.LA(1)) {
      case LOWERPITCH:
      case HIGHERPITCH:
      case ACCIDENTAL:
        {
        setState(101);
        note();
        }
        break;
      case T__2:
        {
        setState(102);
        chord();
        }
        break;
      default:
        throw new NoViableAltException(this);
      }
      setState(107);
      switch (_input.LA(1)) {
      case LOWERPITCH:
      case HIGHERPITCH:
      case ACCIDENTAL:
        {
        setState(105);
        note();
        }
        break;
      case T__2:
        {
        setState(106);
        chord();
        }
        break;
      default:
        throw new NoViableAltException(this);
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

  public static class QuadrupletContext extends ParserRuleContext {
    public List<NoteContext> note() {
      return getRuleContexts(NoteContext.class);
    }
    public NoteContext note(int i) {
      return getRuleContext(NoteContext.class,i);
    }
    public List<ChordContext> chord() {
      return getRuleContexts(ChordContext.class);
    }
    public ChordContext chord(int i) {
      return getRuleContext(ChordContext.class,i);
    }
    public QuadrupletContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_quadruplet; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof MusicListener ) ((MusicListener)listener).enterQuadruplet(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof MusicListener ) ((MusicListener)listener).exitQuadruplet(this);
    }
  }

  public final QuadrupletContext quadruplet() throws RecognitionException {
    QuadrupletContext _localctx = new QuadrupletContext(_ctx, getState());
    enterRule(_localctx, 24, RULE_quadruplet);
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(109);
      match(T__6);
      setState(112);
      switch (_input.LA(1)) {
      case LOWERPITCH:
      case HIGHERPITCH:
      case ACCIDENTAL:
        {
        setState(110);
        note();
        }
        break;
      case T__2:
        {
        setState(111);
        chord();
        }
        break;
      default:
        throw new NoViableAltException(this);
      }
      setState(116);
      switch (_input.LA(1)) {
      case LOWERPITCH:
      case HIGHERPITCH:
      case ACCIDENTAL:
        {
        setState(114);
        note();
        }
        break;
      case T__2:
        {
        setState(115);
        chord();
        }
        break;
      default:
        throw new NoViableAltException(this);
      }
      setState(120);
      switch (_input.LA(1)) {
      case LOWERPITCH:
      case HIGHERPITCH:
      case ACCIDENTAL:
        {
        setState(118);
        note();
        }
        break;
      case T__2:
        {
        setState(119);
        chord();
        }
        break;
      default:
        throw new NoViableAltException(this);
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

  public static class TupletContext extends ParserRuleContext {
    public DupletContext duplet() {
      return getRuleContext(DupletContext.class,0);
    }
    public TripletContext triplet() {
      return getRuleContext(TripletContext.class,0);
    }
    public QuadrupletContext quadruplet() {
      return getRuleContext(QuadrupletContext.class,0);
    }
    public TupletContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_tuplet; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof MusicListener ) ((MusicListener)listener).enterTuplet(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof MusicListener ) ((MusicListener)listener).exitTuplet(this);
    }
  }

  public final TupletContext tuplet() throws RecognitionException {
    TupletContext _localctx = new TupletContext(_ctx, getState());
    enterRule(_localctx, 26, RULE_tuplet);
    try {
      setState(125);
      switch (_input.LA(1)) {
      case T__4:
        enterOuterAlt(_localctx, 1);
        {
        setState(122);
        duplet();
        }
        break;
      case T__5:
        enterOuterAlt(_localctx, 2);
        {
        setState(123);
        triplet();
        }
        break;
      case T__6:
        enterOuterAlt(_localctx, 3);
        {
        setState(124);
        quadruplet();
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

  public static class ElementContext extends ParserRuleContext {
    public NoteContext note() {
      return getRuleContext(NoteContext.class,0);
    }
    public RestContext rest() {
      return getRuleContext(RestContext.class,0);
    }
    public ChordContext chord() {
      return getRuleContext(ChordContext.class,0);
    }
    public TupletContext tuplet() {
      return getRuleContext(TupletContext.class,0);
    }
    public ElementContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_element; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof MusicListener ) ((MusicListener)listener).enterElement(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof MusicListener ) ((MusicListener)listener).exitElement(this);
    }
  }

  public final ElementContext element() throws RecognitionException {
    ElementContext _localctx = new ElementContext(_ctx, getState());
    enterRule(_localctx, 28, RULE_element);
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(131);
      switch (_input.LA(1)) {
      case LOWERPITCH:
      case HIGHERPITCH:
      case ACCIDENTAL:
        {
        setState(127);
        note();
        }
        break;
      case T__1:
        {
        setState(128);
        rest();
        }
        break;
      case T__2:
        {
        setState(129);
        chord();
        }
        break;
      case T__4:
      case T__5:
      case T__6:
        {
        setState(130);
        tuplet();
        }
        break;
      default:
        throw new NoViableAltException(this);
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
    "\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\21\u0088\4\2\t"+
      "\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n"+
      "\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\3"+
      "\2\3\3\5\3%\n\3\3\3\3\3\5\3)\n\3\6\3+\n\3\r\3\16\3,\3\4\6\4\60\n\4"+
      "\r\4\16\4\61\3\5\5\5\65\n\5\3\5\3\5\5\59\n\5\3\5\5\5<\n\5\3\6\3\6"+
      "\3\7\3\7\3\7\5\7C\n\7\3\b\3\b\3\b\5\bH\n\b\3\t\3\t\5\tL\n\t\3\n\3"+
      "\n\5\nP\n\n\3\13\3\13\6\13T\n\13\r\13\16\13U\3\13\3\13\3\f\3\f\3\f"+
      "\5\f]\n\f\3\f\3\f\5\fa\n\f\3\r\3\r\3\r\5\rf\n\r\3\r\3\r\5\rj\n\r\3"+
      "\r\3\r\5\rn\n\r\3\16\3\16\3\16\5\16s\n\16\3\16\3\16\5\16w\n\16\3\16"+
      "\3\16\5\16{\n\16\3\17\3\17\3\17\5\17\u0080\n\17\3\20\3\20\3\20\3\20"+
      "\5\20\u0086\n\20\3\20\2\2\21\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36"+
      "\2\3\3\2\13\f\u0092\2 \3\2\2\2\4$\3\2\2\2\6/\3\2\2\2\b\64\3\2\2\2"+
      "\n=\3\2\2\2\fB\3\2\2\2\16D\3\2\2\2\20I\3\2\2\2\22M\3\2\2\2\24Q\3\2"+
      "\2\2\26Y\3\2\2\2\30b\3\2\2\2\32o\3\2\2\2\34\177\3\2\2\2\36\u0085\3"+
      "\2\2\2 !\5\4\3\2!\"\7\2\2\3\"\3\3\2\2\2#%\7\n\2\2$#\3\2\2\2$%\3\2"+
      "\2\2%*\3\2\2\2&(\5\6\4\2\')\7\n\2\2(\'\3\2\2\2()\3\2\2\2)+\3\2\2\2"+
      "*&\3\2\2\2+,\3\2\2\2,*\3\2\2\2,-\3\2\2\2-\5\3\2\2\2.\60\5\36\20\2"+
      "/.\3\2\2\2\60\61\3\2\2\2\61/\3\2\2\2\61\62\3\2\2\2\62\7\3\2\2\2\63"+
      "\65\7\16\2\2\64\63\3\2\2\2\64\65\3\2\2\2\65\66\3\2\2\2\668\5\n\6\2"+
      "\679\7\r\2\28\67\3\2\2\289\3\2\2\29;\3\2\2\2:<\5\f\7\2;:\3\2\2\2;"+
      "<\3\2\2\2<\t\3\2\2\2=>\t\2\2\2>\13\3\2\2\2?C\7\17\2\2@C\5\16\b\2A"+
      "C\5\20\t\2B?\3\2\2\2B@\3\2\2\2BA\3\2\2\2C\r\3\2\2\2DE\7\17\2\2EG\7"+
      "\3\2\2FH\7\17\2\2GF\3\2\2\2GH\3\2\2\2H\17\3\2\2\2IK\7\3\2\2JL\7\17"+
      "\2\2KJ\3\2\2\2KL\3\2\2\2L\21\3\2\2\2MO\7\4\2\2NP\5\f\7\2ON\3\2\2\2"+
      "OP\3\2\2\2P\23\3\2\2\2QS\7\5\2\2RT\5\b\5\2SR\3\2\2\2TU\3\2\2\2US\3"+
      "\2\2\2UV\3\2\2\2VW\3\2\2\2WX\7\6\2\2X\25\3\2\2\2Y\\\7\7\2\2Z]\5\b"+
      "\5\2[]\5\24\13\2\\Z\3\2\2\2\\[\3\2\2\2]`\3\2\2\2^a\5\b\5\2_a\5\24"+
      "\13\2`^\3\2\2\2`_\3\2\2\2a\27\3\2\2\2be\7\b\2\2cf\5\b\5\2df\5\24\13"+
      "\2ec\3\2\2\2ed\3\2\2\2fi\3\2\2\2gj\5\b\5\2hj\5\24\13\2ig\3\2\2\2i"+
      "h\3\2\2\2jm\3\2\2\2kn\5\b\5\2ln\5\24\13\2mk\3\2\2\2ml\3\2\2\2n\31"+
      "\3\2\2\2or\7\t\2\2ps\5\b\5\2qs\5\24\13\2rp\3\2\2\2rq\3\2\2\2sv\3\2"+
      "\2\2tw\5\b\5\2uw\5\24\13\2vt\3\2\2\2vu\3\2\2\2wz\3\2\2\2x{\5\b\5\2"+
      "y{\5\24\13\2zx\3\2\2\2zy\3\2\2\2{\33\3\2\2\2|\u0080\5\26\f\2}\u0080"+
      "\5\30\r\2~\u0080\5\32\16\2\177|\3\2\2\2\177}\3\2\2\2\177~\3\2\2\2"+
      "\u0080\35\3\2\2\2\u0081\u0086\5\b\5\2\u0082\u0086\5\22\n\2\u0083\u0086"+
      "\5\24\13\2\u0084\u0086\5\34\17\2\u0085\u0081\3\2\2\2\u0085\u0082\3"+
      "\2\2\2\u0085\u0083\3\2\2\2\u0085\u0084\3\2\2\2\u0086\37\3\2\2\2\30"+
      "$(,\61\648;BGKOU\\`eimrvz\177\u0085";
  public static final ATN _ATN =
    new ATNDeserializer().deserialize(_serializedATN.toCharArray());
  static {
    _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
    for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
      _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
    }
  }
}