package abc.sound;

import java.util.ArrayList;
import java.util.List;

/**
 * Rest represents a pause in a piece of music.
 * @author Sarah
 */

public class Rest implements Music{
    private final int duration;
    
    // AF: Represents a rest in a piece of music that lasts for the
    //     number of ticks indicated by duration where one whole note
    //     is 96 ticks
    // Rep Invariant: 
    //      -duration > 0
    //Safety from rep exposure:
    //      -all fields are private, final, and immutable
    //      -all observers return immutable data types

    /**
     * Creates a rest with the specified duration
     * @param duration
     */
    Rest(int duration){
        this.duration = duration;
        checkRep();
    }
    
    private void checkRep(){
        assert duration > 0;
    }

    @Override
    public int duration() {
        return duration;
    }

    @Override
    public void play(SequencePlayer player, int atBeat) { }

    @Override
    public void add(SequencePlayer player, int atBeat) { }

    @Override
    public List<Note> getNotes() {
        return new ArrayList<>();
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
        return "z" + duration;
        
    }
    
    @Override
    public boolean equals(Object thatObject){
        if ( ! (thatObject instanceof Rest)) { return false; }
        Rest that = (Rest)thatObject;
        
        return (that.duration() == this.duration());
    }
    
    @Override
    public int hashCode(){
        return this.duration;
    }

}
