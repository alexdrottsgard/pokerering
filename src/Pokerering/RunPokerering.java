package Pokerering;

import Pokerering.grammar.gen.PseudoCrafter;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import Pokerering.grammar.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class RunPokerering {
    public static void main(String[] args) throws IOException {
        String infnam;
        if (args.length > 0) {
            infnam = args[0];
        } else {
            System.out.println("Vilken fil vill du köra?");
            Scanner scanner = new Scanner(System.in);
            infnam = scanner.nextLine();
        }
        ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(infnam));
        PokereringLexer lexer = new PokereringLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        PokereringParser parser = new PokereringParser(tokens);
        ParseTree tree = parser.code();
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(new PseudoCrafter(), tree);
    }
}

