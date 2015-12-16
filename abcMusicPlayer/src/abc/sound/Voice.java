package abc.sound;

import java.util.ArrayList;
import java.util.List;
//plays multiple components of music in sequence

import javax.sound.midi.MidiUnavailableException;

public class Voice implements Music{
    private final List<Music> elements = new ArrayList<>();
    private final int duration;

    // AF: Represents a voice (sequence of notes, rests, tuplets, and chords)
    // within a piece of music
    // Rep Invariant: true
    // Safety Argument:
    //      - all fields are private
    //      - elements is final
    //      - all methods return immutable data types

    /**
     * Creates an empty voice
     */
    public Voice(){
        duration = 0;
    }

    public Voice(List<Music> elements){
        int tempDuration = 0;
        for (Music element : elements){
            this.elements.add(element);
            tempDuration += element.duration();
        }
        duration = tempDuration;
    }

    @Override
    public Music appendTo(Music m) {
        List<Music> elements = m.getElements();
        elements.addAll(this.elements);
        return new Voice(elements);
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
            element.add(player, currentPlace);
            currentPlace += element.duration();
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
    public List<Music> getElements() {
        return new ArrayList<>(elements);
    }

    @Override
    public String toString() {
        String result = "";
        for (Music element : elements){
            result += element.toString() + " ";
        }
        return result.trim();
    }
    
    @Override
    public boolean equals(Object thatObject){
        if ( ! (thatObject instanceof Piece)) { return false; }
        Voice that = (Voice)thatObject;
        
        return (that.toString().equals(this.toString()));
    }
    
    @Override
    public int hashCode(){
        return this.duration;
    }
}
