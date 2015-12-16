package abc.sound;

import java.util.ArrayList;
import java.util.List;

import javax.sound.midi.MidiUnavailableException;


/**
 * Note is an immutable data type representing a note played in a piece
 * of music with a given pitch and a given duration.
 * @author Sarah
 */
public class Note implements Music{
    private Pitch pitch;
    private int duration;
    
    // AF: pitch represents the pitch of the note and
    //     duration represents the number of ticks that the note is played for
    //     where one whole note is 96 ticks
    // Rep Invariant: 
    //     -duration > 0
    // Safety Argument:
    //     -all fields are final and immutable
    //     -all observers return immutable data types
    
    /**
     * Make a Note played by instrument for duration beats.
     * @param duration : duration in ticks, must be > 0
     * @param pitch : pitch to play
     */
    public Note(Pitch pitch, int duration) {
        this.pitch = pitch;
        this.duration = duration;
        checkRep();
    }
    
    private void checkRep() {
        assert duration > 0;
        assert pitch != null;
    }
    
    /**
     * @return the pitch of the note
     */
    public Pitch pitch() {
       return pitch;
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
    public Music appendTo(Music m) {
        List<Music> elements = m.getElements();
        elements.add(this);
        return new Voice(elements);
    }

    @Override
    public void add(SequencePlayer player, int atBeat) {
        player.addNote(pitch.toMidiNote(), atBeat, duration);
    }
    
    @Override
    public List<Note> getNotes(){
        List<Note> notes = new ArrayList<>();
        notes.add(this);
        return notes;
    }

    @Override
    public List<Music> getElements() {
        List<Music> elements = new ArrayList<>();
        elements.add(this);
        return elements;
    }
    
    @Override
    public String toString() {
        return pitch.toString()+' '+duration;
    }
    
    @Override
    public boolean equals(Object thatObject){
        if ( ! (thatObject instanceof Note)) { return false; }
        Note that = (Note)thatObject;
        
        if (that.pitch().equals(this.pitch()) && that.duration() == this.duration()){
            return true;
        }
        return false;
    }
    
    @Override
    public int hashCode(){
        return this.pitch.hashCode();
    }
}
