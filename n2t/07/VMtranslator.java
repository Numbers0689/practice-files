import java.util.*;
import java.io.*;
import parser.*;

public class VMtranslator {
    public static void main(String[] args) {
        String inFileName = args[1];
        String outFileName = inFileName.replace(".vm", "..asm");
    }
} 