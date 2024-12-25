public class Convertor {
    private List<String> parsedLines;
    private Map<String, Integer> cIns = new HashMap<>();
    private List<String> binaryLines;

    Convertor(List<String> parsedLines) {
        this.parsedLines = parsedLines;
        binaryLines = new ArrayList<>();
    }

    public void translate() {
        for (String line : parsedLines) {
            if (line.startsWith("@")) {
                String ALine = toBinary(Integer.parseInt(line.substring(1)));
                binaryLines.add(ALine);
                System.out.println(ALine);
            }
        }
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