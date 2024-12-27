package writer;

import parser.Command;
import java.io.*;

public class Writer {
    PrintWriter outFile;

    public Writer(String filename) {
        try {
            outFile = new PrintWriter(new BufferedWriter(new FileWriter(filename)));
        } catch (IOException e) {}
    }

    public void writeArithmetic(String command) {

    }

    public void writePushPop(Command c) {

    }

    public void close() {

    }
}
