import java.io.*;
import java.util.*;
import parser.*;
import writer.*;

public class Assembler {
    public static void main(String[] args) throws IOException {
        String filename = args[0];

        FileParser f = new FileParser();
        Convertor c;
        try {
            f.parseFile(filename);
            f.printParsedLines();
            c = new Convertor(f.getParsedLines());
            c.translate();

        } catch (IOException e) {}
        
    }
}