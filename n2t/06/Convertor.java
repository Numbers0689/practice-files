
import java.util.*;
import java.io.*;

public class Convertor {
    private List<String> parsedLines;
    private Map<String, String> cIns = new HashMap<>();
    private Map<String, String> dIns = new HashMap<>();
    private Map<String, String> jIns = new HashMap<>();
    private List<String> binaryLines;

    public Convertor(List<String> parsedLines) {
        this.parsedLines = parsedLines;
        binaryLines = new ArrayList<>();

        cIns.put("0", "101010");
        cIns.put("1", "111111");
        cIns.put("-1", "111010");

        cIns.put("D", "001100");
        cIns.put("!D", "001101");
        cIns.put("-D", "001111");
        cIns.put("D+1", "011111");
        cIns.put("D-1", "001110");

        cIns.put("A", "110000");
        cIns.put("!A", "110001");
        cIns.put("-A", "110011");
        cIns.put("A+1", "110111");
        cIns.put("A-1", "110010");
        cIns.put("D+A", "000010");
        cIns.put("D-A", "010011");
        cIns.put("A-D", "000111");
        cIns.put("D&A", "000000");
        cIns.put("D|A", "010101");

        dIns.put("", "000");
        dIns.put("M", "001");
        dIns.put("D", "010");
        dIns.put("A", "100");
        dIns.put("DM", "011");
        dIns.put("MD", "011");
        dIns.put("AM", "101");
        dIns.put("MA", "101");
        dIns.put("AD", "110");
        dIns.put("DA", "110");

        dIns.put("ADM", "111");
        dIns.put("AMD", "111");
        dIns.put("DAM", "111");
        dIns.put("DMA", "111");
        dIns.put("MAD", "111");
        dIns.put("MDA", "111");    

        jIns.put("", "000");
        jIns.put("JGT", "001");
        jIns.put("JEQ", "010");
        jIns.put("JGE", "011");
        jIns.put("JLT", "100");
        jIns.put("JNE", "101");
        jIns.put("JLE", "110");
        jIns.put("JMP", "111");
    }

    public List<String> translate() {
        for (String line : parsedLines) {
            if (line.startsWith("@")) {
                String ALine = toBinary(Integer.parseInt(line.substring(1)));
                binaryLines.add(ALine);
            } else {
                String CLine = Ctobinary(line.split("[=;]"), line);
                binaryLines.add(CLine);
            }
        }

        return binaryLines;
    }

    private String Ctobinary(String[] c, String line) {
        StringBuilder b = new StringBuilder("111");
        String a, comp, dest, jump;
        int i;

        if (c.length == 3) {
            i = 1;
            dest = dIns.get(c[0]);
            jump = jIns.get(c[2]);
        } else if (c.length == 2 && line.contains("=")) {
            i = 1;
            dest = dIns.get(c[0]);
            jump = jIns.get("");
        } else if (c.length == 2 && line.contains(";")) {
            i = 0;
            dest = dIns.get("");
            jump = jIns.get(c[1]);
        } else {
            i = 0;
            dest = dIns.get("");
            jump = jIns.get("");
        }

        if (c[i].contains("M")) {
            a = "1";
            c[i] = c[i].replace("M", "A");
        }
        else {
            a = "0";
        }
        comp = cIns.get(c[i]);

        b.append(a);
        b.append(comp);
        b.append(dest);
        b.append(jump);

        return b.toString();
    }

    private String toBinary(int n) {
        StringBuilder b = new StringBuilder();
        for (int i = 14; i >= 0; i--) {
            int k = n >> i;
            if ((k & 1) > 0) b.append("1");
            else b.append("0");
        }

        return "0" + b.toString();
    }
}