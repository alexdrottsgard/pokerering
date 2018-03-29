// Generated from /home/student/Skrivbord/Kursmaterial/Pokerering language/src/Pokerering/grammar/Pokerering.g4 by ANTLR 4.5.1
package Pokerering.grammar;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PokereringParser}.
 */
public interface PokereringListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PokereringParser#file}.
	 * @param ctx the parse tree
	 */
	void enterFile(PokereringParser.FileContext ctx);
	/**
	 * Exit a parse tree produced by {@link PokereringParser#file}.
	 * @param ctx the parse tree
	 */
	void exitFile(PokereringParser.FileContext ctx);
	/**
	 * Enter a parse tree produced by {@link PokereringParser#code}.
	 * @param ctx the parse tree
	 */
	void enterCode(PokereringParser.CodeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PokereringParser#code}.
	 * @param ctx the parse tree
	 */
	void exitCode(PokereringParser.CodeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PokereringParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(PokereringParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PokereringParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(PokereringParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PokereringParser#loop}.
	 * @param ctx the parse tree
	 */
	void enterLoop(PokereringParser.LoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link PokereringParser#loop}.
	 * @param ctx the parse tree
	 */
	void exitLoop(PokereringParser.LoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link PokereringParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(PokereringParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link PokereringParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(PokereringParser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link PokereringParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterAssign(PokereringParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link PokereringParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitAssign(PokereringParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link PokereringParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrint(PokereringParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link PokereringParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrint(PokereringParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by {@link PokereringParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(PokereringParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link PokereringParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(PokereringParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link PokereringParser#atomicExpr}.
	 * @param ctx the parse tree
	 */
	void enterAtomicExpr(PokereringParser.AtomicExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link PokereringParser#atomicExpr}.
	 * @param ctx the parse tree
	 */
	void exitAtomicExpr(PokereringParser.AtomicExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link PokereringParser#compExpr}.
	 * @param ctx the parse tree
	 */
	void enterCompExpr(PokereringParser.CompExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link PokereringParser#compExpr}.
	 * @param ctx the parse tree
	 */
	void exitCompExpr(PokereringParser.CompExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link PokereringParser#compareOps}.
	 * @param ctx the parse tree
	 */
	void enterCompareOps(PokereringParser.CompareOpsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PokereringParser#compareOps}.
	 * @param ctx the parse tree
	 */
	void exitCompareOps(PokereringParser.CompareOpsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PokereringParser#addExpr}.
	 * @param ctx the parse tree
	 */
	void enterAddExpr(PokereringParser.AddExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link PokereringParser#addExpr}.
	 * @param ctx the parse tree
	 */
	void exitAddExpr(PokereringParser.AddExprContext ctx);
}