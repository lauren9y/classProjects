package abc.sound;

import java.util.ArrayList;
import java.util.List;

import javax.sound.midi.MidiUnavailableException;

/**
 * Chord is an immutable data type representing multiple notes, 
 * same or different pitches, when played at the same time.
 * Notes within the same chord may also have different duration, 
 * but all nodes are guaranteed to start playing at the same time
 * @author Lauren
 *
 */
public class Chord implements Music{
    
    
     // AF: All notes listed are notes part of the chord, 
     //     meant to be played together at the same time by abc music player.
     //     Chord duration is the duration where all notes will be played together.
     //     A whole note is defined as 96 ticks
     //     Some notes may last longer than other, in which case some notes will end early
     // Rep Invariant: 
     //     - There is more than 1 note in the list of notes (otherwise not a chord)
     //     - duration > 0
     // Safety Argument:
     //     - all fields are private and final
     //     - All observers return immutable data types, does not return mutable references
    
    private final List<Note> notes = new ArrayList<>();
    private final int duration;
    
    /**
     * Makes a chord consisting of the notes listed. The duration of the chord is determined
     * by the duration of the first note in the list of notes.
     * @param notes : list of Notes played in the chord
     */
    public Chord(List<Note> notes){
        for (Note note : notes){
            this.notes.add(note);
        }
        this.duration = notes.get(0).duration();
        checkRep();
    }
    
    private void checkRep(){
        assert notes.size() > 1;
        assert duration > 0;
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
        for (Note note : notes){
            player.addNote(note.pitch().toMidiNote(), atBeat, note.duration());
        }
    }

    @Override
    public List<Note> getNotes() {
        return new ArrayList<>(notes);
    }

    @Override
    public Music appendTo(Music m) {
        List<Music> elements = m.getElements();
        elements.add(this);
        return new Voice(elements);
    }

    @Override
    public List<Music> getElements() {
        List<Music> elements = new ArrayList<>();
        elements.add(this);
        return elements;
    }
    
    @Override
    public String toString() {
        String str = "[";
        for (Note n: this.notes){
            str += n.toString();
        }
        return str + "]";
        
    }
    
    @Override
    public boolean equals(Object thatObject){
        if ( ! (thatObject instanceof Rest)) { return false; }
        Chord that = (Chord)thatObject;
        
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
