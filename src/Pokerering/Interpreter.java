package Pokerering;


import com.sun.org.apache.bcel.internal.generic.GOTO;
import org.antlr.v4.runtime.Token;
import Pokerering.grammar.*;

import java.util.HashMap;
import java.util.Stack;

public class Interpreter extends PokereringBaseListener {
    private static class Var { int val; }
    
    private final String infnam;
    private final HashMap<String, Var> vars = new HashMap<String, Var>();
    private Stack<Integer> exprVal = new Stack<Integer>();


    Interpreter(String infnam) { this.infnam = infnam; }

    private Var getVar(Token tok) {
        String name = tok.getText();
        Var v = vars.get(name);
        if (v == null) {
            error(tok.getLine(), "undefined " + name);
            return new Var();   // avoid null pointer exception
        } else {
            return v;
        }
    }
    
    private void error(int line, String msg) {
        System.err.println(infnam + ":" + line + ": " + msg);
    }
    
    @Override
    public void enterDecl(PokereringParser.DeclContext ctx) {
        String name = ctx.ID().getText();
        Var old = vars.put(name, new Var());
        if (old != null) {
            error(ctx.ID().getSymbol().getLine(), "redefined " + name);
        }
    }

    @Override
    public void exitAssign(PokereringParser.AssignContext ctx) {
        getVar(ctx.ID().getSymbol()).val = exprVal.pop();
    }

    @Override
    public void exitPrint(PokereringParser.PrintContext ctx) {
        System.out.println(exprVal.pop());
    }

    @Override
    public void exitExpr(PokereringParser.ExprContext ctx) {
       /* if (ctx.atomicExpr() != null || ctx.addExpr() != null) {
            exprVal.push(exprVal.pop() + exprVal.pop());
        }*/

        if(ctx.atomicExpr() != null) {
            exprVal.push(exprVal.pop());
        }else if(ctx.addExpr() != null) {
            exprVal.push(exprVal.pop() + exprVal.pop());
        }
    }

    /*
    @Override
    public void enterExpr(PokereringParser.ExprContext ctx) {
        if(ctx.addExpr() != null) {
            int atomic;
            if(ctx.addExpr().atomicExpr().ID() != null) {
                atomic = getVar(ctx.addExpr().atomicExpr().ID().getSymbol()).val;
            }else {
                atomic = getVar(ctx.addExpr().atomicExpr().INT().getSymbol()).val;
            }

        } else {
            if (ctx.atomicExpr().ID() != null) {
                exprVal = getVar(ctx.atomicExpr().ID().getSymbol()).val;
            } else {
                exprVal = Integer.parseInt(ctx.atomicExpr().INT().getText());
            }
        }
    }*/

    public void enterExpr(PokereringParser.ExprContext ctx) {
        if (ctx.atomicExpr() != null) {
            System.out.println("ENTEREXPR: Detta är atomic expression");
            if(ctx.atomicExpr().ID() != null) {
                System.out.println("ENTEREXPR: atomic expression är ett ID");
                exprVal.push(getVar(ctx.atomicExpr().ID().getSymbol()).val);
            } else {
                System.out.println("ENTEREXPR: atomic expression är en INT");
                exprVal.push(Integer.parseInt(ctx.atomicExpr().INT().getText()));
            }

        } else  {
            System.out.println("ENTEREXPR: Det är ett addExpr");
            enterAddExpr(ctx.addExpr());
            //exprVal.push(Integer.parseInt(ctx.INT().getText()));
        }

    }

    public void enterAddExpr(PokereringParser.AddExprContext ctx) {
        if (ctx.atomicExpr() != null) {
            if(ctx.atomicExpr().ID() != null) {
                exprVal.push(getVar(ctx.atomicExpr().ID().getSymbol()).val);
            } else {
                exprVal.push(Integer.parseInt(ctx.atomicExpr().INT().getText()));
            }

        }

        if(ctx.expr() != null) {
            enterExpr(ctx.expr());
        }
    }

    @Override
    public void enterLoop(PokereringParser.LoopContext ctx) {
        super.enterLoop(ctx);
        /*int op1;
        int op2;
        if(ctx.compExpr().expr(0).atomicExpr().ID() != null) {
            op1 = getVar(ctx.compExpr().expr(0).atomicExpr().ID().getSymbol()).val;
        }else{
            op1 = Integer.parseInt(ctx.compExpr().expr(0).atomicExpr().INT().getText());
        }

        if(ctx.compExpr().expr(1).atomicExpr().ID() != null) {
            op2 = getVar(ctx.compExpr().expr(1).atomicExpr().ID().getSymbol()).val;
        }else{
            op2 = Integer.parseInt(ctx.compExpr().expr(1).atomicExpr().INT().getText());
        }
        */

    }

    @Override
    public void exitLoop(PokereringParser.LoopContext ctx) {
        /*
        super.exitLoop(ctx);
        int op1;
        int op2;
        if(ctx.compExpr().expr(0).atomicExpr().ID() != null) {
            op1 = getVar(ctx.compExpr().expr(0).atomicExpr().ID().getSymbol()).val;
        }else{
            op1 = Integer.parseInt(ctx.compExpr().expr(0).atomicExpr().INT().getText());
        }

        if(ctx.compExpr().expr(1).atomicExpr().ID() != null) {
            op2 = getVar(ctx.compExpr().expr(1).atomicExpr().ID().getSymbol()).val;
        }else{
            op2 = Integer.parseInt(ctx.compExpr().expr(1).atomicExpr().INT().getText());
        }

        String compOp = ctx.compExpr().compareOps().getText();
        System.out.println(compOp);
        switch(compOp) {
            case "airpocketpair":
                if(op1 <= op2) {

                }
                break;
            case "air":
                if(op1 < op2) {

                }
                break;
            case "pocketpair":
                if(op1 == op2) {

                }
                break;
            case "airlines":
                if(op1 > op2) {

                }
                break;
            case "airlinespocketpair":
                if(op1 >= op2) {

                }
                break;
        }
        */
        //System.out.println("op1: " + op1 + " op2: " + op2);

        //if(op1 <= op2) {
        //    System.out.println("op1: " + op1 + " op2: " + op2);
          //  enterLoop(ctx);
        //}
    }

    @Override
    public void enterCompExpr(PokereringParser.CompExprContext ctx) {
        super.enterCompExpr(ctx);

    }

    public void enterAtomExpr(PokereringParser.AtomicExprContext ctx) {
        if (ctx.ID() != null) {
            exprVal.push(getVar(ctx.ID().getSymbol()).val);
        } else if (ctx.INT() != null) {
            exprVal.push(Integer.parseInt(ctx.INT().getText()));
        }
    }
}
