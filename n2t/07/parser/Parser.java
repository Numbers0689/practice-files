package parser;
import java.util.*;
import java.io.*;

public class Parser {
    public Parser(String filename) {

    }

    public boolean hasMoreLines() {
        return false;
    }

    public void advance() {

    }

    public Command commandType() {
        return Command.C_ARITHMETIC;
    }

    public String arg1() {
        return "";
    }

    public int arg2() {
        return 0;
    }
}