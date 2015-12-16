package abc.parser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import abc.parser.MusicParser.ChordContext;
import abc.parser.MusicParser.DenominatorContext;
import abc.parser.MusicParser.DupletContext;
import abc.parser.MusicParser.ElementContext;
import abc.parser.MusicParser.FractionContext;
import abc.parser.MusicParser.LengthContext;
import abc.parser.MusicParser.MeasureContext;
import abc.parser.MusicParser.NoteContext;
import abc.parser.MusicParser.PitchContext;
import abc.parser.MusicParser.QuadrupletContext;
import abc.parser.MusicParser.RestContext;
import abc.parser.MusicParser.RootContext;
import abc.parser.MusicParser.TripletContext;
import abc.parser.MusicParser.TupletContext;
import abc.parser.MusicParser.VoiceContext;
import abc.sound.Header;
import abc.sound.Music;
import abc.sound.Note;
import abc.sound.Pitch;

public class MakeMusic implements MusicListener{
    private Stack<Music> stack = new Stack<>();
    private Header header;
    private int numOctaves = 5;
    private int TICKS_PER_WHOLE = 96;
    private int defaultLength;
    private Map<Character, Integer> keySignature;
    private Map<Integer, Map<Character, Integer>> allAccidentals = new HashMap<>();

    public MakeMusic(Header header){
        this.header = header;
        defaultLength = TICKS_PER_WHOLE*header.getLengthNum()/header.getLengthDenum();
        keySignature = header.getAccidentals();
        for (int i = -1*numOctaves; i <= numOctaves; i++){
            allAccidentals.put(i, new HashMap<>(keySignature));
        }
    }

    public Music getMusic() {
        return stack.get(0);
    }

    @Override
    public void enterVoice(VoiceContext ctx) {
        stack.push(Music.voice());
    }

    @Override
    public void enterMeasure(MeasureContext ctx) {
        for (int i = -1*numOctaves; i <= numOctaves; i++){
            allAccidentals.put(i, new HashMap<>(keySignature));
        }
    }

    @Override
    public void exitMeasure(MeasureContext ctx) {
        for (int i = -1*numOctaves; i <= numOctaves; i++){
           allAccidentals.put(i, new HashMap<>(keySignature));
        }
    }
    
    @Override
    public void exitNote(NoteContext ctx) {
        PitchContext pitch = ctx.pitch();
        TerminalNode octave = ctx.OCTAVE();
        TerminalNode accidental = ctx.ACCIDENTAL();
        LengthContext length = ctx.length();

        Pitch notePitch;
        int octaves = 0;
        int semitones = 0; 
        if (pitch.LOWERPITCH() != null){
            notePitch = new Pitch(pitch.getText().charAt(0));
        }
        else{
            notePitch = new Pitch(pitch.getText().toUpperCase().charAt(0));
            //System.out.println(notePitch.toString());
            octaves += 1;
        }
        
        if (octave != null){
            char[] octaveChars = octave.getText().toCharArray();
            for (char octaveChar : octaveChars){
                if (octaveChar == ','){
                    octaves -= 1;
                }
                else{
                    octaves += 1;
                }
            }
        }
        
        semitones = allAccidentals.get(octaves).get(pitch.getText().toUpperCase().charAt(0));
        if (accidental != null){
            semitones = 0;
            char[] accidentalChars = accidental.getText().toCharArray();
            for (char accidentalChar : accidentalChars){
                if (accidentalChar == '^'){
                    semitones += 1;
                }
                else if (accidentalChar == '_'){
                    semitones -= 1;
                }
                else{
                    semitones = 0;
                }
            }
            Map<Character, Integer> accidentals = allAccidentals.get(octaves);
            accidentals.put(pitch.getText().toUpperCase().charAt(0), semitones);
            allAccidentals.put(octaves, accidentals);
        }
        int transpose = octaves*Pitch.OCTAVE + semitones;
        if (length != null){
            Music rightLength = stack.pop();
            stack.push(Music.note(notePitch.transpose(transpose), rightLength.duration()));
        }
        else{
            int rightLength = header.getLengthNum()*TICKS_PER_WHOLE/header.getLengthDenum();
            stack.push(Music.note(notePitch.transpose(transpose), rightLength));
        }
    }

    @Override
    public void exitLength(LengthContext ctx) {
        int length;
        if (ctx.NUMBER() != null){
            length = header.getLengthNum()*Integer.parseInt(ctx.NUMBER().getText());
            length *= TICKS_PER_WHOLE;
            length /= header.getLengthDenum();
            stack.push(Music.note(Pitch.MIDDLE_C, length));
        }
    }
    
    @Override
    public void exitRest(RestContext ctx) {
        if (ctx.length() != null){
            Music rightLength = stack.pop();
            stack.push(Music.rest(rightLength.duration()));
        }
        else{
            int rightLength = header.getLengthNum()*TICKS_PER_WHOLE/header.getLengthDenum();
            stack.push(Music.rest(rightLength));
        }
    }
    
    @Override
    public void exitChord(ChordContext ctx) {
        List<NoteContext> notes = ctx.note();
        List<Note> chordNotes = new ArrayList<>();
        for (int i = 0; i < notes.size(); i++) {
            chordNotes.add((Note) stack.pop());
        }
        stack.push(Music.chord(chordNotes));
    }

    @Override
    public void exitTuplet(TupletContext ctx) {
        int numNotes;
        if (ctx.duplet() != null){
            numNotes = 2;
        }
        else if (ctx.triplet() != null) {
            numNotes = 3;
        }
        else{
            numNotes = 4;
        }
        List<Music> notes = new ArrayList<>();
        for(int i = 0; i < numNotes; i++){
            notes.add(stack.pop());
        }
        Collections.reverse(notes);
        stack.push(Music.tuplet(notes));
    }
    
    @Override
    public void exitElement(ElementContext ctx) {
        Music first = stack.pop();
        Music second = stack.pop();
        stack.push(first.appendTo(second));
    }
    
    @Override
    public void exitFraction(FractionContext ctx) {
        List<TerminalNode> fraction = ctx.NUMBER();
        int fractionNum = Integer.parseInt(fraction.get(0).getText());
        int fractionDenom;
        if (ctx.NUMBER(1) != null) {
            fractionDenom = Integer.parseInt(fraction.get(1).getText());
        }
        else {
            fractionDenom = 2;
        }
        int length = defaultLength*fractionNum/fractionDenom;
        stack.push(Music.note(Pitch.MIDDLE_C, length));
    }

    @Override
    public void exitDenominator(DenominatorContext ctx) {
        int fractionDenom;
        if (ctx.NUMBER() != null){
            fractionDenom = Integer.parseInt(ctx.NUMBER().getText());
        }
        else{
            fractionDenom = 2;
        }
        int length = defaultLength/fractionDenom;
        stack.push(Music.note(Pitch.MIDDLE_C, length));
    }

    @Override
    public void enterEveryRule(ParserRuleContext arg0) { }
    @Override
    public void exitEveryRule(ParserRuleContext arg0) { }
    @Override
    public void visitErrorNode(ErrorNode arg0) { }
    @Override
    public void visitTerminal(TerminalNode arg0) { }
    @Override
    public void enterRoot(RootContext ctx) { }
    @Override
    public void exitRoot(RootContext ctx) { }
    @Override
    public void exitVoice(VoiceContext ctx) { }
    @Override
    public void enterNote(NoteContext ctx) { }
    @Override
    public void enterLength(LengthContext ctx) { }
    @Override
    public void enterRest(RestContext ctx) { }
    @Override
    public void enterChord(ChordContext ctx) { }
    @Override
    public void enterTuplet(TupletContext ctx) { }
    @Override
    public void enterElement(ElementContext ctx) { }
    @Override
    public void enterFraction(FractionContext ctx) { }
    @Override
    public void enterDenominator(DenominatorContext ctx) { }
    @Override
    public void enterPitch(PitchContext ctx) { }
    @Override
    public void exitPitch(PitchContext ctx) { }
    @Override
    public void enterDuplet(DupletContext ctx) { }
    @Override
    public void exitDuplet(DupletContext ctx) { }
    @Override
    public void enterTriplet(TripletContext ctx) { }
    @Override
    public void exitTriplet(TripletContext ctx) { }
    @Override
    public void enterQuadruplet(QuadrupletContext ctx) { }
    @Override
    public void exitQuadruplet(QuadrupletContext ctx) { }

}