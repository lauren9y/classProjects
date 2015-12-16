// Generated from Header.g4 by ANTLR 4.5.1

package abc.parser;
// Do not edit this .java file! Edit the .g4 file and re-run Antlr.

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link HeaderParser}.
 */
public interface HeaderListener extends ParseTreeListener {
  /**
   * Enter a parse tree produced by {@link HeaderParser#root}.
   * @param ctx the parse tree
   */
  void enterRoot(HeaderParser.RootContext ctx);
  /**
   * Exit a parse tree produced by {@link HeaderParser#root}.
   * @param ctx the parse tree
   */
  void exitRoot(HeaderParser.RootContext ctx);
  /**
   * Enter a parse tree produced by {@link HeaderParser#header}.
   * @param ctx the parse tree
   */
  void enterHeader(HeaderParser.HeaderContext ctx);
  /**
   * Exit a parse tree produced by {@link HeaderParser#header}.
   * @param ctx the parse tree
   */
  void exitHeader(HeaderParser.HeaderContext ctx);
  /**
   * Enter a parse tree produced by {@link HeaderParser#element}.
   * @param ctx the parse tree
   */
  void enterElement(HeaderParser.ElementContext ctx);
  /**
   * Exit a parse tree produced by {@link HeaderParser#element}.
   * @param ctx the parse tree
   */
  void exitElement(HeaderParser.ElementContext ctx);
  /**
   * Enter a parse tree produced by {@link HeaderParser#x}.
   * @param ctx the parse tree
   */
  void enterX(HeaderParser.XContext ctx);
  /**
   * Exit a parse tree produced by {@link HeaderParser#x}.
   * @param ctx the parse tree
   */
  void exitX(HeaderParser.XContext ctx);
  /**
   * Enter a parse tree produced by {@link HeaderParser#t}.
   * @param ctx the parse tree
   */
  void enterT(HeaderParser.TContext ctx);
  /**
   * Exit a parse tree produced by {@link HeaderParser#t}.
   * @param ctx the parse tree
   */
  void exitT(HeaderParser.TContext ctx);
  /**
   * Enter a parse tree produced by {@link HeaderParser#c}.
   * @param ctx the parse tree
   */
  void enterC(HeaderParser.CContext ctx);
  /**
   * Exit a parse tree produced by {@link HeaderParser#c}.
   * @param ctx the parse tree
   */
  void exitC(HeaderParser.CContext ctx);
  /**
   * Enter a parse tree produced by {@link HeaderParser#l}.
   * @param ctx the parse tree
   */
  void enterL(HeaderParser.LContext ctx);
  /**
   * Exit a parse tree produced by {@link HeaderParser#l}.
   * @param ctx the parse tree
   */
  void exitL(HeaderParser.LContext ctx);
  /**
   * Enter a parse tree produced by {@link HeaderParser#m}.
   * @param ctx the parse tree
   */
  void enterM(HeaderParser.MContext ctx);
  /**
   * Exit a parse tree produced by {@link HeaderParser#m}.
   * @param ctx the parse tree
   */
  void exitM(HeaderParser.MContext ctx);
  /**
   * Enter a parse tree produced by {@link HeaderParser#q}.
   * @param ctx the parse tree
   */
  void enterQ(HeaderParser.QContext ctx);
  /**
   * Exit a parse tree produced by {@link HeaderParser#q}.
   * @param ctx the parse tree
   */
  void exitQ(HeaderParser.QContext ctx);
  /**
   * Enter a parse tree produced by {@link HeaderParser#v}.
   * @param ctx the parse tree
   */
  void enterV(HeaderParser.VContext ctx);
  /**
   * Exit a parse tree produced by {@link HeaderParser#v}.
   * @param ctx the parse tree
   */
  void exitV(HeaderParser.VContext ctx);
  /**
   * Enter a parse tree produced by {@link HeaderParser#notnewline}.
   * @param ctx the parse tree
   */
  void enterNotnewline(HeaderParser.NotnewlineContext ctx);
  /**
   * Exit a parse tree produced by {@link HeaderParser#notnewline}.
   * @param ctx the parse tree
   */
  void exitNotnewline(HeaderParser.NotnewlineContext ctx);
}