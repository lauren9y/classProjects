package abc.sound;
import java.util.List;

import org.antlr.v4.gui.Trees;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import abc.parser.MakeMusic;
import abc.parser.MusicLexer;
import abc.parser.MusicParser;

/**
 * Music represents a piece of music composed of various notes, chords, rests, tuplets...
 */
public interface Music {

    //Music = Note(p : Pitch, int: duration) + Chord(notes : List<Music>) + Rest(int : duration)
    //        +Tuplet(notes: List<Music>) + Voice(List<Music>) + Piece(List<Music>)

    /**
    * Parse an expression.
    * @param input music in ABC to parse
    * @return Music object representing the music
    * @throws IllegalArgumentException if the expression is invalid
    */    
    public static Music parse(String input, Header header) throws IllegalArgumentException{
        CharStream stream = new ANTLRInputStream(input);
        MusicLexer lexer = new MusicLexer(stream);
        lexer.reportErrorsAsExceptions();
        TokenStream tokens = new CommonTokenStream(lexer);
        MusicParser parser = new MusicParser(tokens);
        parser.reportErrorsAsExceptions();
        try {
            ParseTree tree = parser.root();
            //System.err.println(tree.toStringTree(parser));
            //Trees.inspect(tree, parser);
            MakeMusic musicMaker = new MakeMusic(header);
            new ParseTreeWalker().walk(musicMaker, tree);
            return musicMaker.getMusic();
        } catch(RuntimeException e){
            throw new IllegalArgumentException("illegal argument");
        }
    }
    
        /**
         * Factory method to produce a note.
         * @param p : Pitch of the note
         * @param duration : duration of the note
         * @return Music object representing a note
         */
        public static Music note(Pitch p, int duration){
            return new Note(p, duration);
        }

        /**
         * Factory method to produce a chord.
         * @param notes : notes in the chord
         * @return Music object representing a chord
         */
        public static Music chord(List<Note> notes){
            return new Chord(notes);
        }

        /**
         * Factory method to produce a rest
         * @param duration : duration of the rest
         * @return Music object representing a rest
         */
        public static Music rest(int duration){
            return new Rest(duration);
        }

        /**
         * Factory method to produce a tuplet (duplet, triplet, or quadruplet)
         * @param elements : elements (either chords or notes) in the tuplet
         * @return Music object representing a tuplet
         */
        public static Music tuplet(List<Music> elements){
            return new Tuplet(elements);
        }

        /**
         * Factory method to produce an empty voice
         * @return Music object representing a voice
         */
        public static Music voice(){
            return new Voice();
        }

        /**
         * Factory method to produce a piece
         * @return Music object representing a piece
         */
        public static Music piece(List<Voice> voices){
            return new Piece(voices);
        }

        /**
         * Returns a new Music object which is this object appended to Music m
         * @param m : Music to append to
         * @return Music object representing Music m followed by this music
         */
        public Music appendTo(Music m);

        /**
         * @return total duration of this piece in ticks where one whole note
         *         is 96 ticks
         */
        public int duration();

        /**
         * 
         * @return a list of all the elements in the piece in the order they should
         *         be played
         */
        public List<Music> getElements();
        
        /**
         * 
         * @return a list of all notes in teh piece in the order they are played
         */
        public List<Note> getNotes();

        /**
         * Adds all the notes in the Music piece to the player.
         * @param player: SequencePlayer to play on
         * @param atBeat: beat to start playing
         */
        public void add(SequencePlayer player, int atBeat);

        /**
         * Play this piece.
         * @param player : SequencePlayer to play on
         * @param atBeat : beat to start playing
         */
        public void play(SequencePlayer player, int atBeat);
        
        /**
         * 
         * @param obj
         * @return object equality between the objects compared
         */
        public boolean equals(Object obj);
        
        /**
         * 
         * @return hashCode of the object used for equality
         */
        public int hashCode();
    }

