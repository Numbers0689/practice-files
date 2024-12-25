import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Resolve {
    String line;
    Map<String, String> symbols = new HashMap<>();
    int index;

    public Resolve() {
        index = 16;

        for (int i = 0; i < 16; i++) {
            symbols.put("R" + i, Integer.toString(i));
        }

        symbols.put("SCREEN", "16384");
        symbols.put("KBD", "24576");
        symbols.put("SP", "0");
        symbols.put("LCL", "1");
        symbols.put("ARG", "2");
        symbols.put("THIS", "3");
        symbols.put("THAT", "4");
    }

    public void check(String l, int size) {
        this.line = l;
        line = line.replaceAll("[()]", "");
        symbols.put(line, Integer.toString(size));
    }

    public List<String> fix(List<String> lines) {
        List<String> pLines = new ArrayList<>();

        for (String s : lines) {
            String changed = s;
            if (s.startsWith("@") && !s.substring(1).matches("[0-9]+")) {
                String lable = s.substring(1);
                if (symbols.containsKey(lable)) {
                    changed = s.replace(lable, symbols.get(lable));
                } else {
                    symbols.put(lable, Integer.toString(index));
                    changed = s.replace(lable, Integer.toString(index));
                    index++;
                }
            }
            pLines.add(changed);
        }

        return pLines;
    }
}
