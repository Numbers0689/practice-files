package parser;
import java.util.*;
import java.io.*;

public class Parser {
    private List<String> parsedLines;
    private String currentCommand;
    private int index;

    public Parser(File file) {

        this.parsedLines = new ArrayList<>();
        this.index = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = reader.readLine()) != null) {
                line = line.replaceAll("\\s\\t", "").trim();
                if (line.isEmpty()) continue;
                int commentIndex = line.indexOf("//");
                if (commentIndex != -1) {
                    line = line.substring(0, commentIndex).trim();
                }
                if (line.isEmpty()) continue;

                this.parsedLines.add(line);
            }
        } catch(IOException e) {
            System.out.println("Problem opening and reading file: " + file.getName());
        }
    }

    public boolean hasMoreLines() {
        return (parsedLines.size() > index);
    }

    public void advance() {
        currentCommand = parsedLines.get(index);
        index++;
    }

    public Command commandType() {
        Command c;

        String ctype = currentCommand.split(" ")[0];

        switch (ctype) {
            case "push":
                c = Command.C_PUSH;
                break;
            
            case "pop":
                c = Command.C_POP;
                break;
            
            case "add":
            case "sub":
            case "neg":
            case "eq":
            case "gt":
            case "lt":
            case "and":
            case "or":
            case "not":
                c = Command.C_ARITHMETIC;
                break;

            case "call":
                c = Command.C_CALL;
                break;

            case "function":
                c = Command.C_FUNCTION;
                break;
            
            case "goto":
                c = Command.C_GOTO;
                break;

            case "if-goto":
                c = Command.C_IF;
                break;

            case "return":
                c = Command.C_RETURN;
                break;

            case "label":
                c = Command.C_LABEL;
                break;
                
            default:
                c = Command.C_ERROR;
                break;
        }
        return c;
    }

    public String arg1() {
        Command curr = commandType();
        if (curr == Command.C_ARITHMETIC) return currentCommand.split(" ")[0];
        else return currentCommand.split(" ")[1];
    }

    public int arg2() {
        return Integer.parseInt(currentCommand.split(" ")[2]);
    }

    public void printParsed() {
        for (String s : parsedLines) {
            System.out.println(s);
        }
    }
}