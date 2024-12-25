import java.io.*;
import java.util.*;

public class FileParser {
    private List<String> parsedLines;
    Resolve r;

    public FileParser(Resolve r) {
        this.parsedLines = new ArrayList<>();
        this.r = r;
    }

    public void parseFile(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                line = line.replaceAll("\\s\\t", "").trim();
                if (line.isEmpty()) continue;
                int commentIndex = line.indexOf("//");
                if (commentIndex != -1) {
                    line = line.substring(0, commentIndex).trim();
                }
                if (line.isEmpty()) continue;
                
                if (line.startsWith("(")) {
                    r.check(line, parsedLines.size());
                    continue;
                }
                parsedLines.add(line);
            }
        }
        this.parsedLines = r.fix(parsedLines);
    }

    public List<String> getParsedLines() {
        printParsedLines();
        return parsedLines;
    }

    public void printParsedLines() {
        try {
            PrintWriter p = new PrintWriter(new BufferedWriter(new FileWriter("parsed.asm")));
            for (String line : parsedLines) {
                p.println(line);
            }
            p.close();
        } catch(IOException e) {}
    }
}