public class FileParser {
    private List<String> parsedLines;

    public FileParser() {
        this.parsedLines = new ArrayList<>();
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
                parsedLines.add(line);
            }
        }
    }

    public List<String> getParsedLines() {
        return parsedLines;
    }

    public void printParsedLines() {
        for (String line : parsedLines) {
            System.out.println(line);
        }
    }
}