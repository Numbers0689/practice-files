import parser.*;
import writer.Writer;

public class VMtranslator {
    public static void main(String[] args) {
        String inFileName = args[0];
        String outFileName = inFileName.replace(".vm", ".asm");

        Parser p = new Parser(inFileName);
        Writer w = new Writer(outFileName);

        while (p.hasMoreLines()) {
            p.advance();
            Command commandType = p.commandType();
            switch (commandType) {
                case C_ARITHMETIC:
                    w.writeArithmetic(p.arg1());
                    break;
                
                case C_POP:
                case C_PUSH:
                    w.writePushPop(commandType, p.arg1(), p.arg2());
            
                default:
                    break;
            }
        }
        w.close();
        p.printParsed();
    }
} 