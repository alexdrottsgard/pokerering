// Generated from /home/student/Skrivbord/Kursmaterial/Pokerering language/src/Pokerering/grammar/Pokerering.g4 by ANTLR 4.5.1
package Pokerering.grammar;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PokereringParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PokereringVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link PokereringParser#file}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFile(PokereringParser.FileContext ctx);
	/**
	 * Visit a parse tree produced by {@link PokereringParser#code}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCode(PokereringParser.CodeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PokereringParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(PokereringParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PokereringParser#loop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoop(PokereringParser.LoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link PokereringParser#decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecl(PokereringParser.DeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link PokereringParser#assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(PokereringParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by {@link PokereringParser#print}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(PokereringParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by {@link PokereringParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(PokereringParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PokereringParser#atomicExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomicExpr(PokereringParser.AtomicExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PokereringParser#compExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompExpr(PokereringParser.CompExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PokereringParser#compareOps}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompareOps(PokereringParser.CompareOpsContext ctx);
	/**
	 * Visit a parse tree produced by {@link PokereringParser#addExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddExpr(PokereringParser.AddExprContext ctx);
}