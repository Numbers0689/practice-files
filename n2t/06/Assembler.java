import java.io.*;
import java.util.*;

public class Assembler {
    public static void main(String[] args) throws IOException {
        String filename = args[0];
        String outfilename = filename.replace(".asm", ".hack");

        Convertor c;
        Resolve r = new Resolve();
        FileParser f = new FileParser(r);
        try {
            f.parseFile(filename);
            c = new Convertor(f.getParsedLines());
            Write w = new Write(c.translate(), outfilename);
            w.writeToFile();

        } catch (IOException e) {}
        
    }
}