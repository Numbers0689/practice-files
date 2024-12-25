import java.util.*;
import java.io.*;

public class Write {
    List<String> binaryLines;
    PrintWriter writer;

    public Write(List<String> binaryLines, String filename) {
        this.binaryLines = binaryLines;
        try {
            writer = new PrintWriter(new BufferedWriter(new FileWriter(filename)));
        } catch (IOException e) {}
    }

    public void writeToFile() {
        for (String s : binaryLines) {
            writer.println(s);
        }
        writer.close();
    }
}
