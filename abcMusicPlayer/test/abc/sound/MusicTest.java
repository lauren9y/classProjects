package abc.sound;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;

import org.junit.Test;

import abc.player.Main;

/**
 * Tests for playing and parsing Music.
 * 
 * 
 */



public class MusicTest {

    /*
     * Testing Strategy:
     *      -create a note
     *      -create a rest
     *      -create a chord
     *          -notes with different duration
     *      -create a tuplet
     *          -of notes
     *          -of chords
     *          -of both
     *      -create a voice
     *          -one element
     *          -multiple elements
     *      -test play for each
     *      -test parse for each individually
     *      -test parse with accidentals
     *      -test parse with different lengths
     *      -test tuplet with different notes
     *      -test parse with one voice
     *      -test parse with multiple voices
     *      -test parse with repeats
     *      -test parse with accidentals in different octaves
     * 
     */

    private static final int DEFAULT_TEMPO = 140;
    private static final Header HEADER = new Header(1, "Title", "C");

    /**
     * Test creating, playing, and parsing one note
     * @category no_didit
     */
    @Test
    public void createOneNote() {
        SequencePlayer player1;
        SequencePlayer player2;
        SequencePlayer player3;
        Music note = Music.note(new Pitch('C'), 12);
        Music parsedMusic = Music.parse("C", HEADER);
        String play1 = "1";
        String play2 = "2";
        String play3 = "3";
        try{
            player1 = new SequencePlayer(DEFAULT_TEMPO, 24);
            note.play(player1, 0);
            play1 = player1.toString();
            player2 = new SequencePlayer(DEFAULT_TEMPO, 24);
            player2.addNote(new Pitch('C').toMidiNote(), 0, 12);
            play2 = player2.toString();
            player3 = new SequencePlayer(DEFAULT_TEMPO, 24);
            parsedMusic.play(player3, 0);
            play3 = player3.toString();
            assertEquals(play2, play1);
            assertEquals(play2, play3);
        } catch (MidiUnavailableException e) {
            assert false;
            e.printStackTrace();
        } catch (InvalidMidiDataException e) {
            assert false;
            e.printStackTrace();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }  
    }
    
    //Test One Note no playing
    @Test
    public void createOneNoteMusic() {
        SequencePlayer player1;
        SequencePlayer player2;
        SequencePlayer player3;
        Music note = Music.note(new Pitch('C'), 12);
        Music parsedMusic = Music.parse("C|", HEADER);
        String play1 = "1";
        String play2 = "2";
        String play3 = "3";
        try{
            player1 = new SequencePlayer(DEFAULT_TEMPO, 24);
            note.add(player1, 0);
            play1 = player1.toString();
            player2 = new SequencePlayer(DEFAULT_TEMPO, 24);
            player2.addNote(new Pitch('C').toMidiNote(), 0, 12);
            play2 = player2.toString();
            player3 = new SequencePlayer(DEFAULT_TEMPO, 24);
            parsedMusic.add(player3, 0);
            play3 = player3.toString();
            assertEquals(play2, play1);
            assertEquals(play2, play3);
        } catch (MidiUnavailableException e) {
            assert false;
            e.printStackTrace();
        } catch (InvalidMidiDataException e) {
            assert false;
            e.printStackTrace();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }  
    }
    
    //Test creating, playing, and parsing one note with accidentals
    //Tests each accidental, and tests accidentals across measures as well as across octaves
    @Test
    public void createNoteAccidental() {
        SequencePlayer player1;
        SequencePlayer player2;
        SequencePlayer player3;
        Music note1 = Music.note(new Pitch('C').transpose(2), 12);
        Music note2 = Music.note(new Pitch('C').transpose(2), 12);
        Music note3 = Music.note(new Pitch('C').transpose(Pitch.OCTAVE), 12);
        Music note4 = Music.note(new Pitch('C').transpose(-1 + Pitch.OCTAVE), 12);
        Music note5 = Music.note(new Pitch('C'), 12);
        Music note6 = Music.note(new Pitch('C').transpose(-2), 12);
        Music note7 = Music.note(new Pitch('C').transpose(1), 12);
        Music voice = note7.appendTo(note6.appendTo(note5.appendTo(note4.appendTo(
                note3.appendTo(note2.appendTo(note1))))));
        Music parsedMusic = Music.parse("^^C C c _c| C __C ^C|", HEADER);
        String play1 = "1";
        String play2 = "2";
        String play3 = "3";
        try{
            player1 = new SequencePlayer(DEFAULT_TEMPO, 24);
            voice.add(player1, 0);
            //voice.play(player1, 0);
            play1 = player1.toString();
            player2 = new SequencePlayer(DEFAULT_TEMPO, 24);
            player2.addNote(new Pitch('C').transpose(2).toMidiNote(), 0, 12);
            player2.addNote(new Pitch('C').transpose(2).toMidiNote(), 12, 12);
            player2.addNote(new Pitch('C').transpose(Pitch.OCTAVE).toMidiNote(), 24, 12);
            player2.addNote(new Pitch('C').transpose(-1 + Pitch.OCTAVE).toMidiNote(), 36, 12);
            player2.addNote(new Pitch('C').toMidiNote(), 48, 12);
            player2.addNote(new Pitch('C').transpose(-2).toMidiNote(), 60, 12);
            player2.addNote(new Pitch('C').transpose(1).toMidiNote(), 72, 12);
            play2 = player2.toString();
            player3 = new SequencePlayer(DEFAULT_TEMPO, 24);
            //parsedMusic.play(player3, 0);
            parsedMusic.add(player3, 0);
            play3 = player3.toString();
            assertEquals(play2, play1);
            assertEquals(play2, play3);
        } catch (MidiUnavailableException e) {
            assert false;
            e.printStackTrace();
        } catch (InvalidMidiDataException e) {
            assert false;
            e.printStackTrace();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }  
    }
    
    //Test creating, playing, and parsing one note with length
    @Test
    public void createNoteLength() {
        SequencePlayer player1;
        SequencePlayer player2;
        SequencePlayer player3;
        Music note1 = Music.note(new Pitch('C'), 12);
        Music note2 = Music.note(new Pitch('C'), 6);
        Music note3 = Music.note(new Pitch('C'), 3);
        Music note4 = Music.note(new Pitch('C'), 18);
        Music voice = note4.appendTo(note3.appendTo(note2.appendTo(note1)));
        Music parsedMusic = Music.parse("C C/ C/4 C3/|", HEADER);
        String play1 = "1";
        String play2 = "2";
        String play3 = "3";
        try{
            player1 = new SequencePlayer(DEFAULT_TEMPO, 24);
            //voice.play(player1, 0);
            voice.add(player1, 0);
            play1 = player1.toString();
            player2 = new SequencePlayer(DEFAULT_TEMPO, 24);
            player2.addNote(new Pitch('C').toMidiNote(), 0, 12);
            player2.addNote(new Pitch('C').toMidiNote(), 12, 6);
            player2.addNote(new Pitch('C').toMidiNote(), 18, 3);
            player2.addNote(new Pitch('C').toMidiNote(), 21, 18);
            play2 = player2.toString();
            player3 = new SequencePlayer(DEFAULT_TEMPO, 24);
            //parsedMusic.play(player3, 0);
            parsedMusic.add(player3, 0);
            play3 = player3.toString();
            assertEquals(play2, play1);
            assertEquals(play2, play3);
        } catch (MidiUnavailableException e) {
            assert false;
            e.printStackTrace();
        } catch (InvalidMidiDataException e) {
            assert false;
            e.printStackTrace();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }  
    }

    //Test creating, playing, and parsing a rest followed by a note
    @Test
    public void createRestAndNote() {
        SequencePlayer player1;
        SequencePlayer player2;
        SequencePlayer player3;
        Music note = Music.note(new Pitch('C'), 12);
        Music rest = Music.rest(24);
        Music restAndNote = note.appendTo(rest);
        Music parsedMusic = Music.parse("z2 C|", HEADER);
        String play1 = "1";
        String play2 = "2";
        String play3 = "3";
        try{
            player1 = new SequencePlayer(DEFAULT_TEMPO, 24);
            //restAndNote.play(player1, 0);
            restAndNote.add(player1, 0);
            play1 = player1.toString();
            player2 = new SequencePlayer(DEFAULT_TEMPO, 24);
            player2.addNote(new Pitch('C').toMidiNote(), 24, 12);
            play2 = player2.toString();
            player3 = new SequencePlayer(DEFAULT_TEMPO, 24);
            //parsedMusic.play(player3, 0);
            parsedMusic.add(player3, 0);
            play3 = player3.toString();
            assertEquals(play2, play1);
            assertEquals(play2, play3);
        } catch (MidiUnavailableException e) {
            assert false;
            e.printStackTrace();
        } catch (InvalidMidiDataException e) {
            assert false;
            e.printStackTrace();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }  
    }

    //Test creating, playing, and parsing a chord
    @Test
    public void createChord() {
        SequencePlayer player1;
        SequencePlayer player2;
        SequencePlayer player3;
        SequencePlayer player4;
        Note note1 = (Note) Music.note(new Pitch('C'), 12);
        Note note2 = (Note) Music.note(new Pitch('E'), 12);
        Note note3 = (Note) Music.note(new Pitch('G'), 12);
        Music chord = Music.chord(Arrays.asList(note1, note2, note3));
        Music parsedMusic = Music.parse("[CEG]|", HEADER);
        String play1 = "1";
        String play2 = "2";
        String play3 = "3";
        String play4 = "4";
        try{
            player1 = new SequencePlayer(DEFAULT_TEMPO, 24);
            //chord.play(player1, 0);
            chord.add(player1, 0);
            play1 = player1.toString();
            player2 = new SequencePlayer(DEFAULT_TEMPO, 24);
            // notes added in any order are fine
            player2.addNote(new Pitch('G').toMidiNote(), 0, 12);
            player2.addNote(new Pitch('E').toMidiNote(), 0, 12);
            player2.addNote(new Pitch('C').toMidiNote(), 0, 12);
            play2 = player2.toString();
            player4 = new SequencePlayer(DEFAULT_TEMPO, 24);
            player4.addNote(new Pitch('C').toMidiNote(), 0, 12);
            player4.addNote(new Pitch('E').toMidiNote(), 0, 12);
            player4.addNote(new Pitch('G').toMidiNote(), 0, 12);
            play4 = player4.toString();
            player3 = new SequencePlayer(DEFAULT_TEMPO, 24);
            //parsedMusic.play(player3, 0);
            parsedMusic.add(player3, 0);
            play3 = player3.toString();
            assertEquals(play4, play1);
            assertEquals(play2, play3);
        } catch (MidiUnavailableException e) {
            assert false;
            e.printStackTrace();
        } catch (InvalidMidiDataException e) {
            assert false;
            e.printStackTrace();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }  
    }

    //Test creating, playing, and parsing a chord with notes of different duration
    @Test
    public void createChordDifferentDuration() {
        SequencePlayer player1;
        SequencePlayer player2;
        SequencePlayer player3;
        SequencePlayer player4;
        Note note1 = (Note) Music.note(new Pitch('C'), 12);
        Note note2 = (Note) Music.note(new Pitch('E'), 24);
        Note note3 = (Note) Music.note(new Pitch('G'), 12);
        Music chord = Music.chord(Arrays.asList(note1, note2, note3));
        Music parsedMusic = Music.parse("[CE2G]|", HEADER);
        String play1 = "1";
        String play2 = "2";
        String play3 = "3";
        String play4 = "4";
        try{
            player1 = new SequencePlayer(DEFAULT_TEMPO, 24);
            //chord.play(player1, 0);
            chord.add(player1, 0);
            play1 = player1.toString();
            player2 = new SequencePlayer(DEFAULT_TEMPO, 24);
            // notes added in any order are fine
            player2.addNote(new Pitch('G').toMidiNote(), 0, 12);
            player2.addNote(new Pitch('E').toMidiNote(), 0, 24);
            player2.addNote(new Pitch('C').toMidiNote(), 0, 12);
            play2 = player2.toString();
            player4 = new SequencePlayer(DEFAULT_TEMPO, 24);
            player4.addNote(new Pitch('C').toMidiNote(), 0, 12);
            player4.addNote(new Pitch('E').toMidiNote(), 0, 24);
            player4.addNote(new Pitch('G').toMidiNote(), 0, 12);
            play4 = player4.toString();
            player3 = new SequencePlayer(DEFAULT_TEMPO, 24);
            //parsedMusic.play(player3, 0);
            parsedMusic.add(player3, 0);
            play3 = player3.toString();
            assertEquals(play4, play1);
            assertEquals(play2, play3);
        } catch (MidiUnavailableException e) {
            assert false;
            e.printStackTrace();
        } catch (InvalidMidiDataException e) {
            assert false;
            e.printStackTrace();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }  
    }

    //Test creating, playing, and parsing a tuplet of notes
    @Test
    public void createTupletOfNotes() {
        SequencePlayer player1;
        SequencePlayer player2;
        SequencePlayer player3;
        Note note1 = (Note) Music.note(new Pitch('C'), 12);
        Note note2 = (Note) Music.note(new Pitch('E'), 12);
        Note note3 = (Note) Music.note(new Pitch('G'), 12);
        Music tuplet = Music.tuplet(Arrays.asList(note1, note2, note3));
        Music parsedMusic = Music.parse("(3CEG|", HEADER);
        String play1 = "1";
        String play2 = "2";
        String play3 = "3";
        try{
            player1 = new SequencePlayer(DEFAULT_TEMPO, 24);
            //tuplet.play(player1, 0);
            tuplet.add(player1, 0);
            play1 = player1.toString();
            player2 = new SequencePlayer(DEFAULT_TEMPO, 24);
            player2.addNote(new Pitch('C').toMidiNote(), 0, 8);
            player2.addNote(new Pitch('E').toMidiNote(), 8, 8);
            player2.addNote(new Pitch('G').toMidiNote(), 16, 8);
            play2 = player2.toString();
            player3 = new SequencePlayer(DEFAULT_TEMPO, 24);
            //parsedMusic.play(player3, 0);
            parsedMusic.add(player3, 0);
            play3 = player3.toString();
            assertEquals(play2, play1);
            assertEquals(play2, play3);
        } catch (MidiUnavailableException e) {
            assert false;
            e.printStackTrace();
        } catch (InvalidMidiDataException e) {
            assert false;
            e.printStackTrace();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }  
    }

    //Test creating, playing, and parsing a tuplet of chords
    @Test
    public void createTupletOfChords() {
        SequencePlayer player1;
        SequencePlayer player2;
        SequencePlayer player3;
        Note note1 = (Note) Music.note(new Pitch('C'), 12);
        Note note2 = (Note) Music.note(new Pitch('E'), 12);
        Note note3 = (Note) Music.note(new Pitch('G'), 12);
        Music chord1 = Music.chord(Arrays.asList(note1, note2, note3));

        Note note4 = (Note) Music.note(new Pitch('F'), 12);
        Note note5 = (Note) Music.note(new Pitch('A'), 12);
        Note note6 = (Note) Music.note(new Pitch('C'), 12);
        Music chord2 = Music.chord(Arrays.asList(note4, note5, note6));

        Note note7 = (Note) Music.note(new Pitch('G'), 12);
        Note note8 = (Note) Music.note(new Pitch('B'), 12);
        Note note9 = (Note) Music.note(new Pitch('D'), 12);
        Music chord3 = Music.chord(Arrays.asList(note7, note8, note9));

        Music tuplet = Music.tuplet(Arrays.asList(chord1, chord2, chord3));
        Music parsedMusic = Music.parse("(3[GEC][CAF][DBG]|", HEADER);
        String play1 = "1";
        String play2 = "2";
        String play3 = "3";
        try{
            player1 = new SequencePlayer(DEFAULT_TEMPO, 24);
            //tuplet.play(player1, 0);
            tuplet.add(player1, 0);
            play1 = player1.toString();
            player2 = new SequencePlayer(DEFAULT_TEMPO, 24);
            player2.addNote(new Pitch('C').toMidiNote(), 0, 8);
            player2.addNote(new Pitch('E').toMidiNote(), 0, 8);
            player2.addNote(new Pitch('G').toMidiNote(), 0, 8);
            player2.addNote(new Pitch('F').toMidiNote(), 8, 8);
            player2.addNote(new Pitch('A').toMidiNote(), 8, 8);
            player2.addNote(new Pitch('C').toMidiNote(), 8, 8);
            player2.addNote(new Pitch('G').toMidiNote(), 16, 8);
            player2.addNote(new Pitch('B').toMidiNote(), 16, 8);
            player2.addNote(new Pitch('D').toMidiNote(), 16, 8);
            play2 = player2.toString();
            player3 = new SequencePlayer(DEFAULT_TEMPO, 24);
            //parsedMusic.play(player3, 0);
            parsedMusic.add(player3, 0);
            play3 = player3.toString();
            assertEquals(play2, play1);
            assertEquals(play2, play3);
        } catch (MidiUnavailableException e) {
            assert false;
            e.printStackTrace();
        } catch (InvalidMidiDataException e) {
            assert false;
            e.printStackTrace();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }  
    }

    //Test creating, playing, and parsing a tuplet of chords and notes
    @Test
    public void createTupletOfBoth() {
        SequencePlayer player1;
        SequencePlayer player2;
        SequencePlayer player3;
        Note note1 = (Note) Music.note(new Pitch('C'), 12);
        Note note2 = (Note) Music.note(new Pitch('E'), 12);
        Note note3 = (Note) Music.note(new Pitch('G'), 12);
        Music chord1 = Music.chord(Arrays.asList(note1, note2, note3));

        Note note4 = (Note) Music.note(new Pitch('F'), 12);

        Note note7 = (Note) Music.note(new Pitch('G'), 12);
        Note note8 = (Note) Music.note(new Pitch('B'), 12);
        Note note9 = (Note) Music.note(new Pitch('D'), 12);
        Music chord3 = Music.chord(Arrays.asList(note7, note8, note9));

        Music tuplet = Music.tuplet(Arrays.asList(chord1, note4, chord3));
        Music parsedMusic = Music.parse("(3[GEC]F[DBG]|", HEADER);
        String play1 = "1";
        String play2 = "2";
        String play3 = "3";
        try{
            player1 = new SequencePlayer(DEFAULT_TEMPO, 24);
            //tuplet.play(player1, 0);
            tuplet.add(player1, 0);
            play1 = player1.toString();
            player2 = new SequencePlayer(DEFAULT_TEMPO, 24);
            player2.addNote(new Pitch('C').toMidiNote(), 0, 8);
            player2.addNote(new Pitch('E').toMidiNote(), 0, 8);
            player2.addNote(new Pitch('G').toMidiNote(), 0, 8);
            player2.addNote(new Pitch('F').toMidiNote(), 8, 8);
            player2.addNote(new Pitch('G').toMidiNote(), 16, 8);
            player2.addNote(new Pitch('B').toMidiNote(), 16, 8);
            player2.addNote(new Pitch('D').toMidiNote(), 16, 8);
            play2 = player2.toString();
            player3 = new SequencePlayer(DEFAULT_TEMPO, 24);
            //parsedMusic.play(player3, 0);
            parsedMusic.add(player3, 0);
            play3 = player3.toString();
            assertEquals(play2, play1);
            assertEquals(play2, play3);
        } catch (MidiUnavailableException e) {
            assert false;
            e.printStackTrace();
        } catch (InvalidMidiDataException e) {
            assert false;
            e.printStackTrace();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }  
    }

    //Test parsing one voice (test by ears)
    @Test
    public void parseOneVoice(){
        Header header = new Header(1, "Title", "C");
        header.setLength(1, 4);
        Music piece1 = Music.parse("C C C3/4 D/4 E | E3/4 D/4 E3/4 F/4 G2 | (3c/2c/2c/2 (3G/2G/2G/2"
                + " (3E/2E/2E/2 (3C/2C/2C/2 | G3/4 F/4 E3/4 D/4 C2 |]", header);
        System.out.println(piece1.duration());
        System.out.println(piece1.getNotes());
        System.out.println(piece1.getElements());
        assertEquals(384, piece1.duration());
        assertEquals("[C 24, C 24, C 18, D 6, E 24, E 18, D 6, E 18, F 6, G 48, C' 12, C' 12, C' 12, G 12, G 12, G 12, E 12, E 12, E 12, C 12, C 12, C 12, G 18, F 6, E 18, D 6, C 48]", piece1.getNotes().toString());
        
//        try {
//            SequencePlayer player = new SequencePlayer(140, 24);
//            piece1.play(player, 0);
//            assert true;
//        } catch (MidiUnavailableException e1) {
//            assert false;
//            e1.printStackTrace();
//        } catch (InvalidMidiDataException e1) {
//            assert false;
//            e1.printStackTrace();
//        }
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            assert false;
//            e.printStackTrace();
//        }
    }
    
    //Test Main play(file) method and music with multiple voices
    @Test
    public void playPieceFurElise(){
        Main.play("fur_elise.abc");
        assert true;
    }
    
    @Test
    public void playMusicPieceFurElise(){
        System.out.println(Main.playMusic("fur_elise.abc"));
        System.out.println(Main.playMusic("fur_elise.abc").getNotes());
        assert true;
    }
    
    //Test playing a file with comments making sure that comments are ignored (test by ears)
    @Test
    public void playMusicWithComment(){
        int duration = Main.playMusic("abc_song_comments.abc").duration();
        int durationOriginal = Main.playMusic("abc_song.abc").duration();
        assertEquals(durationOriginal, duration);
        
        List<Note> notes = Main.playMusic("abc_song_comments.abc").getNotes();
        List<Note> notesOriginal = Main.playMusic("abc_song_comments.abc").getNotes();
        assertEquals(notesOriginal, notes);
    }
    
    //Test repeat 
    @Test
    public void parseRepeatPiece(){
        Music repeat = Main.playMusic("repeat.abc");
        Music repeatSound = Main.playMusic("repeat_sound.abc");
        assertEquals(repeatSound.duration(), repeat.duration());
        assertEquals(repeatSound.getNotes(), repeat.getNotes());
    }
    
    //Test repeat with alternate endings
    @Test
    public void parseRepeatAlternativeEnding(){
        Music repeatAlternative = Main.playMusic("repeat_alternative_endings.abc");
        Music repeatSound = Main.playMusic("repeat_alternative_sound.abc");
        assertEquals(repeatSound.duration(), repeatAlternative.duration());
        assertEquals(repeatSound.getNotes(), repeatAlternative.getNotes());
    }
    
    //Test paddy.abc for repeats in music files
    @Test
    public void playPaddy(){
        Main.play("paddy.abc");
        assert true;
    }
}