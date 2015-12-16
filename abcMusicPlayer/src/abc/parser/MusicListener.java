// Generated from Music.g4 by ANTLR 4.5.1

package abc.parser;
// Do not edit this .java file! Edit the .g4 file and re-run Antlr.

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MusicParser}.
 */
public interface MusicListener extends ParseTreeListener {
  /**
   * Enter a parse tree produced by {@link MusicParser#root}.
   * @param ctx the parse tree
   */
  void enterRoot(MusicParser.RootContext ctx);
  /**
   * Exit a parse tree produced by {@link MusicParser#root}.
   * @param ctx the parse tree
   */
  void exitRoot(MusicParser.RootContext ctx);
  /**
   * Enter a parse tree produced by {@link MusicParser#voice}.
   * @param ctx the parse tree
   */
  void enterVoice(MusicParser.VoiceContext ctx);
  /**
   * Exit a parse tree produced by {@link MusicParser#voice}.
   * @param ctx the parse tree
   */
  void exitVoice(MusicParser.VoiceContext ctx);
  /**
   * Enter a parse tree produced by {@link MusicParser#measure}.
   * @param ctx the parse tree
   */
  void enterMeasure(MusicParser.MeasureContext ctx);
  /**
   * Exit a parse tree produced by {@link MusicParser#measure}.
   * @param ctx the parse tree
   */
  void exitMeasure(MusicParser.MeasureContext ctx);
  /**
   * Enter a parse tree produced by {@link MusicParser#note}.
   * @param ctx the parse tree
   */
  void enterNote(MusicParser.NoteContext ctx);
  /**
   * Exit a parse tree produced by {@link MusicParser#note}.
   * @param ctx the parse tree
   */
  void exitNote(MusicParser.NoteContext ctx);
  /**
   * Enter a parse tree produced by {@link MusicParser#pitch}.
   * @param ctx the parse tree
   */
  void enterPitch(MusicParser.PitchContext ctx);
  /**
   * Exit a parse tree produced by {@link MusicParser#pitch}.
   * @param ctx the parse tree
   */
  void exitPitch(MusicParser.PitchContext ctx);
  /**
   * Enter a parse tree produced by {@link MusicParser#length}.
   * @param ctx the parse tree
   */
  void enterLength(MusicParser.LengthContext ctx);
  /**
   * Exit a parse tree produced by {@link MusicParser#length}.
   * @param ctx the parse tree
   */
  void exitLength(MusicParser.LengthContext ctx);
  /**
   * Enter a parse tree produced by {@link MusicParser#fraction}.
   * @param ctx the parse tree
   */
  void enterFraction(MusicParser.FractionContext ctx);
  /**
   * Exit a parse tree produced by {@link MusicParser#fraction}.
   * @param ctx the parse tree
   */
  void exitFraction(MusicParser.FractionContext ctx);
  /**
   * Enter a parse tree produced by {@link MusicParser#denominator}.
   * @param ctx the parse tree
   */
  void enterDenominator(MusicParser.DenominatorContext ctx);
  /**
   * Exit a parse tree produced by {@link MusicParser#denominator}.
   * @param ctx the parse tree
   */
  void exitDenominator(MusicParser.DenominatorContext ctx);
  /**
   * Enter a parse tree produced by {@link MusicParser#rest}.
   * @param ctx the parse tree
   */
  void enterRest(MusicParser.RestContext ctx);
  /**
   * Exit a parse tree produced by {@link MusicParser#rest}.
   * @param ctx the parse tree
   */
  void exitRest(MusicParser.RestContext ctx);
  /**
   * Enter a parse tree produced by {@link MusicParser#chord}.
   * @param ctx the parse tree
   */
  void enterChord(MusicParser.ChordContext ctx);
  /**
   * Exit a parse tree produced by {@link MusicParser#chord}.
   * @param ctx the parse tree
   */
  void exitChord(MusicParser.ChordContext ctx);
  /**
   * Enter a parse tree produced by {@link MusicParser#duplet}.
   * @param ctx the parse tree
   */
  void enterDuplet(MusicParser.DupletContext ctx);
  /**
   * Exit a parse tree produced by {@link MusicParser#duplet}.
   * @param ctx the parse tree
   */
  void exitDuplet(MusicParser.DupletContext ctx);
  /**
   * Enter a parse tree produced by {@link MusicParser#triplet}.
   * @param ctx the parse tree
   */
  void enterTriplet(MusicParser.TripletContext ctx);
  /**
   * Exit a parse tree produced by {@link MusicParser#triplet}.
   * @param ctx the parse tree
   */
  void exitTriplet(MusicParser.TripletContext ctx);
  /**
   * Enter a parse tree produced by {@link MusicParser#quadruplet}.
   * @param ctx the parse tree
   */
  void enterQuadruplet(MusicParser.QuadrupletContext ctx);
  /**
   * Exit a parse tree produced by {@link MusicParser#quadruplet}.
   * @param ctx the parse tree
   */
  void exitQuadruplet(MusicParser.QuadrupletContext ctx);
  /**
   * Enter a parse tree produced by {@link MusicParser#tuplet}.
   * @param ctx the parse tree
   */
  void enterTuplet(MusicParser.TupletContext ctx);
  /**
   * Exit a parse tree produced by {@link MusicParser#tuplet}.
   * @param ctx the parse tree
   */
  void exitTuplet(MusicParser.TupletContext ctx);
  /**
   * Enter a parse tree produced by {@link MusicParser#element}.
   * @param ctx the parse tree
   */
  void enterElement(MusicParser.ElementContext ctx);
  /**
   * Exit a parse tree produced by {@link MusicParser#element}.
   * @param ctx the parse tree
   */
  void exitElement(MusicParser.ElementContext ctx);
}