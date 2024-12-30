import java.util.*;
import java.io.*;
import parser.*;

public class VMtranslator {
    public static void main(String[] args) {
        String inFileName = args[0];
        String outFileName = inFileName.replace(".vm", "..asm");

        Parser p = new Parser(inFileName);

        // try {
        // } catch (IOException e) {}

        p.printParsed();
    }
} 