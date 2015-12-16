package abc.sound;

/**
 * Represents a tuplet in a piece of music.
 * @author Sarah
 */

import java.util.ArrayList;
import java.util.List;

import javax.sound.midi.MidiUnavailableException;

public class Tuplet implements Music{
    private final double DUPLE_LENGTH = 3.0/2.0;
    private final double TRIPLE_LENGTH = 2.0/3.0;
    private final double QUADRUPLE_LENGTH = 3.0/4.0;

    private final int numNotes;
    private final List<Music> elements = new ArrayList<>();
    private final int duration;
    private final int noteDuration;

    // AF: represents a tuplet of numNotes notes or chords given
    //     by the ArrayList elements. The tuplet has total length duration
    //     and each note has duration noteDuration.
    //     -Duplet: 2 notes in the time of 3 notes
    //     -Triplet: 3 notes in the time of 2 notes
    //     -Quadruplet: 4 notes in the time of 3 notes
    // Rep invariant:
    //     -numNotes == 2, 3, or 4
    //     -elements has length numNotes
    //     -elements contains only chords or notes
    //     -duration > 0
    //     -each element in elements has the same duration

    /**
     * Creates a tuplet out of the elements
     * @param elements
     */
    public Tuplet(List<Music> elements){
        for (Music element : elements){
            this.elements.add(element);
        }
        numNotes = elements.size();
        int writtenNoteDuration = elements.get(0).duration();
        if (numNotes == 2){
            noteDuration = (int) (writtenNoteDuration*DUPLE_LENGTH);
            duration = noteDuration*numNotes;
        }
        else if (numNotes == 3){
            noteDuration = (int) (writtenNoteDuration*TRIPLE_LENGTH);
            duration = noteDuration*numNotes;
        }
        else if (numNotes == 4){
            noteDuration = (int) (writtenNoteDuration*QUADRUPLE_LENGTH);
            duration = noteDuration*numNotes;
        }
        else{
            noteDuration = 0;
            duration = 0;
        }
        checkRep();
    }


    private void checkRep(){
        assert numNotes == 2 || numNotes == 3 || numNotes == 4;
        assert elements.size() == numNotes;
        assert duration > 0;
        int noteDuration = elements.get(0).duration();
        for (Music element : elements){
            assert element.duration() == noteDuration;
        }
    }

    @Override
    public int duration() {
        return duration;
    }

    @Override
    public void play(SequencePlayer player, int atBeat) {
        add(player, atBeat);
        try {
            player.play();
        } catch (MidiUnavailableException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add(SequencePlayer player, int atBeat) {
        int currentPlace = atBeat;
        for (Music element : elements){
            List<Note> notes = element.getNotes();
            for (Note note : notes){
                player.addNote(note.pitch().toMidiNote(), currentPlace, noteDuration);
            }
            currentPlace += noteDuration;
        }
    }

    @Override
    public List<Note> getNotes() {
        List<Note> notes = new ArrayList<>();
        for (Music element : elements){
            notes.addAll(element.getNotes());
        }
        return notes;
    }


    @Override
    public Music appendTo(Music m) {
        List<Music> elements = m.getElements();
        elements.add(this);
        return new Voice(elements);
    }

    @Override
    public List<Music> getElements() {
        return new ArrayList<>(elements);
    }
    
    @Override
    public String toString(){
        String result = "";
        for (Music element : elements){
            result += element.toString() +" " + noteDuration + " ";
        }
        return result.trim();
    }
    
    @Override
    public boolean equals(Object thatObject){
        if ( ! (thatObject instanceof Rest)) { return false; }
        Tuplet that = (Tuplet)thatObject;
        
        if (that.getNotes().equals(this.getNotes()) && that.duration() == this.duration()){
            return true;
        }
        return false;
    }
    
    @Override
    public int hashCode(){
        return this.duration;
    }

}
