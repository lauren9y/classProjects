package abc.player;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;

import abc.sound.Header;
import abc.sound.Music;
import abc.sound.SequencePlayer;
import abc.sound.Voice;

/**
 * Main entry point of your application.
 */
public class Main {
    private static int TICKS_PER_WHOLE = 96;
    private static final String ABC_PKG = "sample_abc/";

    /**
     * Plays the input file using Java MIDI API and displays
     * header information to the standard output stream.
     * 
     * (Your code should not exit the application abnormally using
     * System.exit().)
     * 
     * @param file the name of input abc file
     */
    public static void play(String file) {
        System.out.println("playing file");
        String music = "";
        BufferedReader br = null;

        String currentLine;
        try {
            br = new BufferedReader(new FileReader(ABC_PKG + file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            while ((currentLine = br.readLine()) != null) {
                music += currentLine + "\n";

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (br != null) {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        String headerText;
        String musicText;
        Map<String, String> voices = new HashMap<>();
        String[] splitText = music.split("K:[A-G]^?_?m?");
        musicText = splitText[1].trim();
        headerText = music.substring(0, music.length() - splitText[1].length() +1);
        Header header = Header.parse(headerText);
        String[] splitInput = musicText.split("[\\n\\r]+");
        String voiceName = "default";
        for (int i = 0; i < splitInput.length; i++){
            String lineWithoutComments = "";
            String[] commentSplit = splitInput[i].split("%");
            // splits up the commented/uncommented sections
            for (int j = 0; j < commentSplit.length; j++) {
                if (j % 2 == 0){
                    lineWithoutComments += commentSplit[j];
                }
            }
            if (lineWithoutComments.contains("V:")){
                voiceName = lineWithoutComments.replace("V:", "").trim();
            }
            else{
                if (voices.containsKey(voiceName)){
                    voices.put(voiceName, voices.get(voiceName) + lineWithoutComments);
                }
                else{
                    voices.put(voiceName, lineWithoutComments);
                }
            }
        }
        for (String name : voices.keySet()){
            String finalVoiceText = "";
            String voiceText = voices.get(name);
            voiceText = voiceText.replace(":|", "r:|");
            String[] repeatSplit = voiceText.split(":\\|");
            //split into each section that needs a repeat
            //repeat signified by letter 'r'
            for (int i = 0; i < repeatSplit.length; i++){
                if (!repeatSplit[i].endsWith("r")){
                    repeatSplit[i] = repeatSplit[i].replace("[2", "");
                    finalVoiceText += repeatSplit[i];
                    //no repeat needed
                }
                else{
                    repeatSplit[i] = repeatSplit[i].replace("[2", "");
                    repeatSplit[i] = repeatSplit[i].replace("r", "|");
                    String[] repeatSection = repeatSplit[i].split("\\|:");
                    //divide from the non-repeated section at the beginning
                    int lastSectionNum;
                    // this is the section to be repeated
                    if (repeatSection.length > 1){
                        finalVoiceText += repeatSection[0];
                        // add non-repeated part once
                        lastSectionNum = 1;
                    }
                    else{
                        lastSectionNum = 0;
                    }
                    String[] endings = repeatSection[lastSectionNum].split("\\[1");
                    // splits repeated part into repeated portion and first ending (if it exists)
                    finalVoiceText += endings[0];
                    if (endings.length > 1){
                        finalVoiceText += endings[1];
                        // adds first ending if it exists
                    }
                    finalVoiceText += endings[0];
                    // repeats the original portion
                }
            }
            voices.put(name, finalVoiceText);
        }
        List<Voice> pieceVoices = new ArrayList<>(); 
        for (String voice : voices.values()){
            pieceVoices.add((Voice) Music.parse(voice, header));
        }
        Music piece = Music.piece(pieceVoices);
        SequencePlayer player;
        try {
            player = new SequencePlayer(header.getTempo(), TICKS_PER_WHOLE*header.getTempoNum()/header.getTempoDenom());
            piece.play(player, 0);
        } catch (MidiUnavailableException e1) {
            e1.printStackTrace();
        } catch (InvalidMidiDataException e1) {
            e1.printStackTrace();
        }
        try {
            Thread.sleep(50*piece.duration());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    
    /**
     * Adds the notes as the parser parses the abc file music
     * 
     * @param file the name of input abc file
     * @return Music file after final parsing
     */
    public static Music playMusic(String file){
        System.out.println("playing file");
        String music = "";
        BufferedReader br = null;

        String currentLine;
        try {
            br = new BufferedReader(new FileReader(ABC_PKG + file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            while ((currentLine = br.readLine()) != null) {
                music += currentLine + "\n";

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (br != null) {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        String headerText;
        String musicText;
        Map<String, String> voices = new HashMap<>();
        String[] splitText = music.split("K:[A-G]^?_?m?");
        musicText = splitText[1].trim();
        headerText = music.substring(0, music.length() - splitText[1].length() +1);
        System.out.println("Header text" + headerText);
        System.out.println("Music text" + musicText);
        Header header = Header.parse(headerText);
        String[] splitInput = musicText.split("[\\n\\r]+");
        String voiceName = "default";
        for (int i = 0; i < splitInput.length; i++){
            String lineWithoutComments = "";
            String[] commentSplit = splitInput[i].split("%");
            // splits up the commented/uncommented sections
            for (int j = 0; j < commentSplit.length; j++) {
                if (j % 2 == 0){
                    lineWithoutComments += commentSplit[j];
                }
            }
            if (lineWithoutComments.contains("V:")){
                voiceName = lineWithoutComments.replace("V:", "").trim();
            }
            else{
                if (voices.containsKey(voiceName)){
                    voices.put(voiceName, voices.get(voiceName) + lineWithoutComments);
                }
                else{
                    voices.put(voiceName, lineWithoutComments);
                }
            }
        }
        for (String name : voices.keySet()){
            String finalVoiceText = "";
            String voiceText = voices.get(name);
            voiceText = voiceText.replace(":|", "r:|");
            String[] repeatSplit = voiceText.split(":\\|");
            //split into each section that needs a repeat
            //repeat signified by letter 'r'
            for (int i = 0; i < repeatSplit.length; i++){
                if (!repeatSplit[i].endsWith("r")){
                    repeatSplit[i] = repeatSplit[i].replace("[2", "");
                    finalVoiceText += repeatSplit[i];
                    //no repeat needed
                }
                else{
                    repeatSplit[i] = repeatSplit[i].replace("[2", "");
                    repeatSplit[i] = repeatSplit[i].replace("r", "|");
                    String[] repeatSection = repeatSplit[i].split("\\|:");
                    //divide from the non-repeated section at the beginning
                    int lastSectionNum;
                    // this is the section to be repeated
                    if (repeatSection.length > 1){
                        finalVoiceText += repeatSection[0];
                        // add non-repeated part once
                        lastSectionNum = 1;
                    }
                    else{
                        lastSectionNum = 0;
                    }
                    String[] endings = repeatSection[lastSectionNum].split("\\[1");
                    // splits repeated part into repeated portion and first ending (if it exists)
                    finalVoiceText += endings[0];
                    if (endings.length > 1){
                        finalVoiceText += endings[1];
                        // adds first ending if it exists
                    }
                    finalVoiceText += endings[0];
                    // repeats the original portion
                }
            }
            voices.put(name, finalVoiceText);
        }
        List<Voice> pieceVoices = new ArrayList<>(); 
        for (String voice : voices.values()){
            pieceVoices.add((Voice) Music.parse(voice, header));
        }
        Music piece = Music.piece(pieceVoices);
        //SequencePlayer player;

        //player = new SequencePlayer(header.getTempo(), TICKS_PER_WHOLE*header.getTempoNum()/header.getTempoDenom());
        //piece.play(player, 0);
        //piece.add(player, 0);
        //System.out.println(player);
        return piece;
        

    }

    public static void main(String[] args) {
        play("piece1.abc");

    }
}
