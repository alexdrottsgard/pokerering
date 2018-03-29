package Pokerering.grammar.gen;

import Pokerering.grammar.PokereringBaseListener;
import Pokerering.grammar.PokereringParser.AddExprContext;
import Pokerering.grammar.PokereringParser.AssignContext;
import Pokerering.grammar.PokereringParser.AtomicExprContext;
import Pokerering.grammar.PokereringParser.CodeContext;
import Pokerering.grammar.PokereringParser.DeclContext;
import Pokerering.grammar.PokereringParser.ExprContext;
import Pokerering.grammar.PokereringParser.FileContext;
import Pokerering.grammar.PokereringParser.LoopContext;
import Pokerering.grammar.PokereringParser.LoopHeadContext;
import Pokerering.grammar.PokereringParser.PrintContext;
import Pokerering.grammar.PokereringParser.StatementContext;

import java.util.Stack;

public class PseudoCrafter extends PokereringBaseListener {
    private int count = 1;
    private Stack<Integer> loopStack = new Stack<Integer>();

    public PseudoCrafter() {
    }

    public void enterCode(CodeContext ctx) {
    }

    public void enterFile(FileContext ctx) {
    }

    public void enterStatement(StatementContext ctx) {
    }

    public void enterAssign(AssignContext ctx) {
    }

    public void exitAssign(AssignContext ctx) {
        super.exitAssign(ctx);
        System.out.println("pop " + ctx.ID());
    }

    public void enterExpr(ExprContext ctx) {
    }

    public void enterAtomicExpr(AtomicExprContext ctx) {
        super.enterAtomicExpr(ctx);
    }

    public void exitAtomicExpr(AtomicExprContext ctx) {
        super.exitAtomicExpr(ctx);
        if(ctx.ID() != null) {
            System.out.println("push " + ctx.ID().getText());
        } else {
            System.out.println("push " + ctx.INT().getText());
        }

    }

    public void exitDecl(DeclContext ctx) {
        super.exitDecl(ctx);
    }

    public void enterAddExpr(AddExprContext ctx) {
    }

    public void exitAddExpr(AddExprContext ctx) {
        super.exitAddExpr(ctx);
        System.out.println("add");
    }

    public void enterLoop(LoopContext ctx) {
        loopStack.push(count);
        System.out.println("enterloop" + count);
    }

    public void exitLoopHead(LoopHeadContext ctx) {
        System.out.println("if " + ctx.compExpr().expr(1).getText() + " < " + ctx.compExpr().expr(0).getText() + " goto exitloop" + loopStack.peek());
        count++;
    }

    public void exitLoop(LoopContext ctx) {
        System.out.println("goto enterloop" + loopStack.peek());
        System.out.println("exitloop" + loopStack.pop() + ":");
    }

    public void enterPrint(PrintContext ctx) {
    }

    public void exitPrint(PrintContext ctx) {
        super.exitPrint(ctx);
        System.out.println("print " + ctx.expr().atomicExpr().ID().getText());
    }
}