package abc.sound;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.gui.Trees;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import abc.parser.HeaderLexer;
import abc.parser.HeaderListener;

import abc.parser.HeaderParser;
import abc.parser.HeaderParser.ElementContext;
import abc.parser.HeaderParser.NotnewlineContext;
import abc.parser.HeaderParser.VContext;
/**
 * Mutable class that contains information that applies to a music piece, 
 * including index number, title, key, and optionally
 * tempo, meter, and default length of music notes.
 *
 */
public class Header {
    private String composer;
    private String key;
    private Map<Character, Integer> accidentals;
    private int lengthNum;
    private int lengthDenum;
    private int meterNum;
    private int meterDenum;
    private int tempoNumBeats;
    private int tempoNum;
    private int tempoDenom;
    private String title;
    private int index;
    private final List<String> voices = new ArrayList<>();

    private boolean lengthSet = false;

    private String DEFAULT_COMPOSER = "Unknown";
    private int DEFAULT_LENGTH_NUM = 1;
    private int DEFAULT_LENGTH_DENUM_EIGTHNOTE = 8;
    private int DEFAULT_LENGTH_DENUM_SIXTEENTH = 16;
    private int DEFAULT_METER_NUM = 4;
    private int DEFAULT_METER_DENUM = 4;
    private static int DEFAULT_TEMPO = 100;

    private static Map<Character, Integer> C_MAJOR = new HashMap<Character, Integer>() {/**
         * 
         */
        private static final long serialVersionUID = 1L;

    {
        put('C', 0);
        put('D', 0);
        put('E', 0);
        put('F', 0);
        put('G', 0);
        put('A', 0);
        put('B', 0); 
    }};
    private static Map<Character, Integer> A_MINOR = new HashMap<Character, Integer>() {/**
         * 
         */
        private static final long serialVersionUID = 1L;

    {
        put('C', 0);
        put('D', 0);
        put('E', 0);
        put('F', 0);
        put('G', 0);
        put('A', 0);
        put('B', 0); 
    }};
    private static Map<Character, Integer> G_MAJOR = new HashMap<Character, Integer>() {/**
         * 
         */
        private static final long serialVersionUID = 1L;

    {
        put('C', 0);
        put('D', 0);
        put('E', 0);
        put('F', 1);
        put('G', 0);
        put('A', 0);
        put('B', 0); 
    }};
    private static Map<Character, Integer> E_MINOR = new HashMap<Character, Integer>() {/**
         * 
         */
        private static final long serialVersionUID = 1L;

    {
        put('C', 0);
        put('D', 0);
        put('E', 0);
        put('F', 1);
        put('G', 0);
        put('A', 0);
        put('B', 0); 
    }};
    private static Map<Character, Integer> D_MAJOR = new HashMap<Character, Integer>() {/**
         * 
         */
        private static final long serialVersionUID = 1L;

    {
        put('C', 1);
        put('D', 0);
        put('E', 0);
        put('F', 1);
        put('G', 0);
        put('A', 0);
        put('B', 0); 
    }};
    private static Map<Character, Integer> B_MINOR = new HashMap<Character, Integer>() {/**
         * 
         */
        private static final long serialVersionUID = 1L;

    {
        put('C', 1);
        put('D', 0);
        put('E', 0);
        put('F', 1);
        put('G', 0);
        put('A', 0);
        put('B', 0); 
    }};
    private static Map<Character, Integer> A_MAJOR = new HashMap<Character, Integer>() {/**
         * 
         */
        private static final long serialVersionUID = 1L;

    {
        put('C', 1);
        put('D', 0);
        put('E', 0);
        put('F', 1);
        put('G', 1);
        put('A', 0);
        put('B', 0); 
    }};
    private static Map<Character, Integer> F_SHARP_MINOR = new HashMap<Character, Integer>() {/**
         * 
         */
        private static final long serialVersionUID = 1L;

    {
        put('C', 1);
        put('D', 0);
        put('E', 0);
        put('F', 1);
        put('G', 1);
        put('A', 0);
        put('B', 0); 
    }};
    private static Map<Character, Integer> E_MAJOR = new HashMap<Character, Integer>() {/**
         * 
         */
        private static final long serialVersionUID = 1L;

    {
        put('C', 1);
        put('D', 1);
        put('E', 0);
        put('F', 1);
        put('G', 1);
        put('A', 0);
        put('B', 0); 
    }};
    private static Map<Character, Integer> C_SHARP_MINOR = new HashMap<Character, Integer>() {/**
         * 
         */
        private static final long serialVersionUID = 1L;

    {
        put('C', 1);
        put('D', 1);
        put('E', 0);
        put('F', 1);
        put('G', 1);
        put('A', 0);
        put('B', 0); 
    }};
    private static Map<Character, Integer> B_MAJOR = new HashMap<Character, Integer>() {/**
         * 
         */
        private static final long serialVersionUID = 1L;

    {
        put('C', 1);
        put('D', 1);
        put('E', 0);
        put('F', 1);
        put('G', 1);
        put('A', 1);
        put('B', 0); 
    }};
    private static Map<Character, Integer> F_SHARP_MAJOR = new HashMap<Character, Integer>() {/**
         * 
         */
        private static final long serialVersionUID = 1L;

    {
        put('C', 1);
        put('D', 1);
        put('E', 1);
        put('F', 1);
        put('G', 1);
        put('A', 1);
        put('B', 0); 
    }};
    private static Map<Character, Integer> F_MAJOR = new HashMap<Character, Integer>() {/**
         * 
         */
        private static final long serialVersionUID = 1L;

    {
        put('C', 0);
        put('D', 0);
        put('E', 0);
        put('F', 0);
        put('G', 0);
        put('A', 0);
        put('B', -1); 
    }};
    private static Map<Character, Integer> D_MINOR = new HashMap<Character, Integer>() {/**
         * 
         */
        private static final long serialVersionUID = 1L;

    {
        put('C', 0);
        put('D', 0);
        put('E', 0);
        put('F', 0);
        put('G', 0);
        put('A', 0);
        put('B', -1); 
    }};
    private static Map<Character, Integer> B_FLAT_MAJOR = new HashMap<Character, Integer>() {/**
         * 
         */
        private static final long serialVersionUID = 1L;

    {
        put('C', 0);
        put('D', 0);
        put('E', -1);
        put('F', 0);
        put('G', 0);
        put('A', 0);
        put('B', -1); 
    }};
    private static Map<Character, Integer> G_MINOR = new HashMap<Character, Integer>() {/**
         * 
         */
        private static final long serialVersionUID = 1L;

    {
        put('C', 0);
        put('D', 0);
        put('E', -1);
        put('F', 0);
        put('G', 0);
        put('A', 0);
        put('B', -1); 
    }};
    private static Map<Character, Integer> E_FLAT_MAJOR = new HashMap<Character, Integer>() {/**
         * 
         */
        private static final long serialVersionUID = 1L;

    {
        put('C', 0);
        put('D', 0);
        put('E', -1);
        put('F', 0);
        put('G', 0);
        put('A', -1);
        put('B', -1); 
    }};
    private static Map<Character, Integer> C_MINOR = new HashMap<Character, Integer>() {/**
         * 
         */
        private static final long serialVersionUID = 1L;

    {
        put('C', 0);
        put('D', 0);
        put('E', -1);
        put('F', 0);
        put('G', 0);
        put('A', -1);
        put('B', -1); 
    }};
    private static Map<Character, Integer> A_FLAT_MAJOR = new HashMap<Character, Integer>() {/**
         * 
         */
        private static final long serialVersionUID = 1L;

    {
        put('C', 0);
        put('D', -1);
        put('E', -1);
        put('F', 0);
        put('G', 0);
        put('A', -1);
        put('B', -1); 
    }};
    private static Map<Character, Integer> F_MINOR = new HashMap<Character, Integer>() {/**
         * 
         */
        private static final long serialVersionUID = 1L;

    {
        put('C', 0);
        put('D', -1);
        put('E', -1);
        put('F', 0);
        put('G', 0);
        put('A', -1);
        put('B', -1); 
    }};
    private static Map<Character, Integer> D_FLAT_MAJOR = new HashMap<Character, Integer>() {/**
         * 
         */
        private static final long serialVersionUID = 1L;

    {
        put('C', 0);
        put('D', -1);
        put('E', -1);
        put('F', 0);
        put('G', -1);
        put('A', -1);
        put('B', -1); 
    }};
    private static Map<Character, Integer> B_FLAT_MINOR = new HashMap<Character, Integer>() {/**
         * 
         */
        private static final long serialVersionUID = 1L;

    {
        put('C', 0);
        put('D', -1);
        put('E', -1);
        put('F', 0);
        put('G', -1);
        put('A', -1);
        put('B', -1); 
    }};
    private static Map<Character, Integer> G_FLAT_MAJOR = new HashMap<Character, Integer>() {/**
         * 
         */
        private static final long serialVersionUID = 1L;

    {
        put('C', -1);
        put('D', -1);
        put('E', -1);
        put('F', 0);
        put('G', -1);
        put('A', -1);
        put('B', -1); 
    }};
    private static Map<Character, Integer> E_FLAT_MINOR = new HashMap<Character, Integer>() {/**
         * 
         */
        private static final long serialVersionUID = 1L;

    {
        put('C', -1);
        put('D', -1);
        put('E', -1);
        put('F', 0);
        put('G', -1);
        put('A', -1);
        put('B', -1); 
    }};
    private static Map<Character, Integer> A_FLAT_MINOR = new HashMap<Character, Integer>() {/**
         * 
         */
        private static final long serialVersionUID = 1L;

    {
        put('C', -1);
        put('D', -1);
        put('E', -1);
        put('F', -1);
        put('G', -1);
        put('A', -1);
        put('B', -1); 
    }};
    
    private static Map<String, Map<Character, Integer>> KEY_SIGNATURES = new HashMap<String, Map<Character, Integer>>() {/**
         * 
         */
        private static final long serialVersionUID = 1L;

    {
       put("C", C_MAJOR);
       put("C^", D_FLAT_MAJOR);
       put("D_", D_FLAT_MAJOR);
       put("D", D_MAJOR);
       put("D^", E_FLAT_MAJOR);
       put("E_", E_FLAT_MAJOR);
       put("F_", E_MAJOR);
       put("F", F_MAJOR);
       put("F^", F_SHARP_MAJOR);
       put("G_", G_FLAT_MAJOR);
       put("G", G_MAJOR);
       put("G^", A_FLAT_MAJOR);
       put("A_", A_FLAT_MAJOR);
       put("A", A_MAJOR);
       put("A^", B_FLAT_MAJOR);
       put("B_", B_FLAT_MAJOR);
       put("B", B_MAJOR);
       put("B^", C_MAJOR);
       put("C_", B_MAJOR);
       put("Cm", C_MINOR);
       put("C^m", C_SHARP_MINOR);
       put("D_m", C_SHARP_MINOR);
       put("Dm", D_MINOR);
       put("D^m", E_FLAT_MINOR);
       put("E_m", E_FLAT_MINOR);
       put("F_m", E_MINOR);
       put("Fm", F_MINOR);
       put("F^m", F_SHARP_MINOR);
       put("G_m", F_SHARP_MINOR);
       put("Gm", G_MINOR);
       put("G^m", A_FLAT_MINOR);
       put("A_m", A_FLAT_MINOR);
       put("Am", A_MINOR);
       put("A^m", B_FLAT_MINOR);
       put("B_m", B_FLAT_MINOR);
       put("Bm", B_MINOR);
       put("B^m", C_MINOR);
       put("C_m", B_MINOR);
    }};





    /**
     * AF: Stores musical information that applies to the entire piece of music. 
     *     Each field stores a different piece of information.
     * RI: Title, index, and key are always specified, key is greater than or equal to 0
     * Safety Argument: All fields are final and observer methods return immutable types.
     */

    /**
     * Parse a header
     * @param input header file to parse
     * @return a Header that matches the information in the file
     * @throws IllegalArgumentException
     */
    public static Header parse(String input) throws IllegalArgumentException{
        //     // Create a stream of characters from the string
        CharStream stream = new ANTLRInputStream(input);

        HeaderLexer lexer = new HeaderLexer(stream);
        lexer.reportErrorsAsExceptions();
        TokenStream tokens = new CommonTokenStream(lexer);

        HeaderParser parser = new HeaderParser(tokens);
        parser.reportErrorsAsExceptions();

        try {
            ParseTree tree = parser.root();
            //System.err.println(tree.toStringTree(parser));
            //Trees.inspect(tree, parser);

            MakeHeader headerMaker = new MakeHeader();
            new ParseTreeWalker().walk(headerMaker, tree);

            return headerMaker.getHeader();
        } catch(RuntimeException e){
            throw new IllegalArgumentException("illegal argument");
        }
    }

    /**
     * Constructor for Header
     * @param index index number that identifies the piece
     * @param title name identification of the music piece
     * @param key name of key music is played in
     */
    public Header(int index, String title, String key){
        this.title = title;
        this.index = index;
        this.key = key;
        this.accidentals = KEY_SIGNATURES.get(key); 
        this.composer = DEFAULT_COMPOSER;
        this.lengthNum = DEFAULT_LENGTH_NUM;
        this.lengthDenum = DEFAULT_LENGTH_DENUM_EIGTHNOTE;
        this.meterNum = DEFAULT_METER_NUM;
        this.meterDenum = DEFAULT_METER_DENUM;
        this.tempoNumBeats = DEFAULT_TEMPO;
        this.tempoNum = lengthNum;
        this.tempoDenom = lengthDenum;
        checkRep();
    }

    /**
     * Assert Rep Invariants
     */
    private void checkRep(){
        assert this.title != null;
        assert this.key != null;
        assert this.index >= 0;
    }

    /**
     * Change title of musical piece
     * @param title name of the piece
     */
    public void setTitle(String title){
        this.title = title;
    }

    /**
     * Change the key of musical piece
     * @param key name of key of the piece
     */
    public void setKey(String key){
        this.key = key;
        this.accidentals = KEY_SIGNATURES.get(key); 
    }

    /**
     * Change index number
     * @param index number to be changed to
     */
    public void setIndex(int index){
        this.index = index;
    }

    /**
     * Change composer
     * @param composer to be changed to
     */
    public void setComposer(String composer){
        this.composer = composer;
    }

    /**
     * Change default length of note
     * @param lengthNum numerator of length
     * @param lengthDenum denominator of piece
     */
    public void setLength(int lengthNum, int lengthDenum){
        this.lengthNum = lengthNum;
        this.lengthDenum = lengthDenum;
        lengthSet = true;
    }

    /**
     * Change the meter
     * @param meterNum numerator of meter
     * @param meterDenum denominator of meter
     */
    public void setMeter(int meterNum, int meterDenum){
        this.meterNum = meterNum;
        this.meterDenum = meterDenum;
        if (!lengthSet){
            if (((double) meterNum)/meterDenum < 0.75){
                this.lengthDenum = DEFAULT_LENGTH_DENUM_SIXTEENTH;
            }
        }
    }

    /**
     * Change tempo (beats per min) of the piece
     * @param tempo tempo to be changed to
     */
    public void setTempo(int tempo, int tempoNum, int tempoDenom){
        this.tempoNumBeats = tempo;
        this.tempoNum = tempoNum;
        this.tempoDenom = tempoDenom;
    }
    
    /**
     * TODO
     * @param voice
     */
    public void addVoice(String voice) {
        voices.add(voice);
    }
    
    public List<String> getVoices(){
        return new ArrayList<>(voices);
    }

    /**
     * 
     * @return numerator of length of note
     */
    public int getLengthNum(){
        return this.lengthNum;
    }

    /**
     * 
     * @return denominator of length of note
     */
    public int getLengthDenum(){
        return this.lengthDenum;
    }

    /**
     * 
     * @return numerator of meter
     */
    public int getMeterNum(){
        return this.meterNum;
    }

    /**
     * 
     * @return denominator of meter
     */
    public int getMeterDenum(){
        return this.meterDenum;
    }

    /**
     * 
     * @return tempo (beats per min) of the piece
     */
    public int getTempo(){
        return this.tempoNumBeats;
    }
    
    /**
     * TODO
     * @return tempo (beats per min) of the piece
     */
    public int getTempoNum(){
        return this.tempoNum;
    }
    
    /**
     * TODO
     * @return tempo (beats per min) of the piece
     */
    public int getTempoDenom(){
        return this.tempoDenom;
    }

    /**
     * 
     * @return key of the piece
     */
    public String getKey(){
        return this.key;
    }

    /**
     * 
     * @return the key signature of the piece represented as a map between
     *         the pitches A-G and the semitones up specified by the key
     */
    public Map<Character, Integer> getAccidentals(){
        return new HashMap<>(accidentals);
    }

    /**
     * 
     * @return composer of the piece
     */
    public String getComposer(){
        return this.composer;
    }

    /**
     * 
     * @return index that indentifies the piece
     */
    public int getIndex(){
        return this.index;
    }

    /**
     * 
     * @return title of the piece
     */
    public String getTitle(){
        return this.title;
    }

    //finish specs and get methods




}

class MakeHeader implements HeaderListener {
    private Header header = new Header(0, " ", " ");

    /**
     * Returns the Header constructed by this object.
     * Requires that this object has completely walked over a Header parse tree 
     * using ParseTreeWalker.
     * @return Header for the parse tree that was walked
     */
    public Header getHeader() {
        return this.header;
    }

    @Override
    public void enterRoot(HeaderParser.RootContext ctx){
    }

    @Override
    public void exitRoot(HeaderParser.RootContext ctx) {

    }

    @Override
    public void enterHeader(HeaderParser.HeaderContext ctx) {
    }

    @Override
    public void exitHeader(HeaderParser.HeaderContext ctx) {
        TerminalNode key = ctx.K();
        String keyText = key.getText();
        keyText = keyText.substring(2);
        header.setKey(keyText.trim());
    }

    @Override
    public void enterC(HeaderParser.CContext ctx) {
    }

    @Override
    public void exitC(HeaderParser.CContext ctx) {
      String composer = "";
      for (NotnewlineContext w : ctx.notnewline()){
          String word = w.getText();
          composer = composer + word;
      }
      this.header.setComposer(composer);
    }

    @Override
    public void enterL(HeaderParser.LContext ctx) {
    }

    @Override
    public void exitL(HeaderParser.LContext ctx) {
        int num = Integer.valueOf(ctx.NUMBER().get(0).getText());
        int denom = Integer.valueOf(ctx.NUMBER().get(1).getText());
        this.header.setLength(num, denom);
    }

    @Override
    public void enterM(HeaderParser.MContext ctx) { }

    @Override
    public void exitM(HeaderParser.MContext ctx) {
        
        if (ctx.NUMBER().size() != 0){
            int num = Integer.valueOf(ctx.NUMBER().get(0).getText());
            int denom = Integer.valueOf(ctx.NUMBER().get(1).getText());
            this.header.setMeter(num, denom);
        }
        else{
            if (ctx.getText().contains("|")){
                this.header.setMeter(2, 2);
            }
            else{
                this.header.setMeter(4, 4);
            }
        }
    }

    @Override
    public void enterQ(HeaderParser.QContext ctx) {
    }

    @Override
    public void exitQ(HeaderParser.QContext ctx) {
        List<TerminalNode> numbers = ctx.NUMBER();
        header.setTempo(Integer.parseInt(numbers.get(2).getText()), Integer.parseInt(numbers.get(0).getText()),
                Integer.parseInt(numbers.get(1).getText()));
    }

    @Override
    public void enterT(HeaderParser.TContext ctx) {
    }

    @Override
    public void exitT(HeaderParser.TContext ctx) {
        String title = "";
        for (NotnewlineContext w : ctx.notnewline()){
            String word = w.getText();
            title = title + word;
        }
        this.header.setTitle(title);
    }

    @Override
    public void enterX(HeaderParser.XContext ctx) {
    }

    @Override
    public void exitX(HeaderParser.XContext ctx) {
        int n = Integer.valueOf(ctx.NUMBER().getText());
        this.header.setIndex(n);
    }

    @Override
    public void enterEveryRule(ParserRuleContext arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void exitEveryRule(ParserRuleContext arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void visitErrorNode(ErrorNode arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void visitTerminal(TerminalNode arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void enterElement(ElementContext ctx) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void exitElement(ElementContext ctx) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void enterV(VContext ctx) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void exitV(VContext ctx) {
        String voice = "";
        for (NotnewlineContext w : ctx.notnewline()){
            String word = w.getText();
            voice = voice + word;
        }
        this.header.addVoice(voice);
    }

    @Override
    public void enterNotnewline(NotnewlineContext ctx) { }

    @Override
    public void exitNotnewline(NotnewlineContext ctx) { }       
}
