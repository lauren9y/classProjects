package abc.sound;

import java.util.ArrayList;
import java.util.List;
//Allows multiple voices to be played at simultaneously

import javax.sound.midi.MidiUnavailableException;


/**
 * Represents a full piece of music.
 */

public class Piece implements Music{
    private final List<Voice> voices = new ArrayList<>();
    private final int duration;
    
    // AF: Represents a piece of music as a list of Voices, voices
    // Rep Invariant: voices has at least one element
    //                duration > 0
    // Safety Argument:
    //      - all fields are private
    //      - elements is final
    //      - all methods return immutable data types
    
    /**
     * Creates a piece containing the voices in voices
     * @param voices
     */
    public Piece(List<Voice> voices){
        int tempDuration = 0;
        for (Voice voice : voices){
            this.voices.add(voice);
            if (voice.duration() > tempDuration) {
                tempDuration = voice.duration();
            }
        }
        duration = tempDuration;
        checkRep();
    }
    
    private void checkRep() {
        assert voices.size() >= 1;
        assert duration >= 0;
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
       for (Voice voice : voices){
           voice.add(player, atBeat);
       } 
    }

    @Override
    public List<Note> getNotes() {
        List<Note> notes = new ArrayList<>();
        for (Music voice : voices){
            notes.addAll(voice.getNotes());
        }
        return notes;
    }

    @Override
    public Music appendTo(Music m) {
        return null;
    }

    @Override
    public List<Music> getElements() {
        List<Music> elements = new ArrayList<>();
        for (Music voice : voices){
            elements.addAll(voice.getElements());
        }
        return elements;
    }
    
    @Override
    public String toString() {
        String str = this.voices.get(0).toString();
        for (Voice v: this.voices){
            if (this.voices.indexOf(v) != 0){
                str += "/n" + v.toString();
            }
        }
        return str;
        
    }
    
    @Override
    public boolean equals(Object thatObject){
        if ( ! (thatObject instanceof Piece)) { return false; }
        Piece that = (Piece)thatObject;
        
        return (that.toString().equals(this.toString()));
    }
    
    @Override
    public int hashCode(){
        return this.duration;
    }

}