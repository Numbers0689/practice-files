import java.util.ArrayList;
import java.io.File;
import parser.*;
import writer.Writer;

public class VMtranslator {
    public static void main(String[] args) {
        String inFileName = args[0];
        File fileName = new File(inFileName);
        String outFileName;

        ArrayList<File> files = new ArrayList<>();

        if (fileName.isFile() && !fileName.getName().endsWith(".vm")) {
            throw new IllegalArgumentException("Wrong file type");
        } else if (fileName.isFile() && fileName.getName().endsWith(".vm")) {
            files.add(fileName);
            outFileName = fileName.getName().replace(".vm", ".asm");
        } else if (fileName.isDirectory()) {
            for (File f : fileName.listFiles()) {
                if (f.getName().endsWith(".vm")) files.add(f);
            }
            outFileName = fileName.getName() + ".asm";
        } else throw new IllegalArgumentException("Wrong argument: [file.vm] [directory]");

        Writer w = new Writer(outFileName);
        w.writeInit();

        for (File f : files) {
            w.setFileName(f.getName().replace(".vm", ""));
            Parser p = new Parser(f);

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
                        break;
                
                    case C_CALL:
                        w.writeCall(p.arg1(), p.arg2());
                        break;

                    case C_FUNCTION:
                        w.writeFunction(p.arg1(), p.arg2());
                        break;

                    case C_RETURN:
                        w.writeReturn();;
                        break;

                    case C_LABEL:
                        w.writeLable(p.arg1());
                        break;

                    case C_GOTO:
                        w.writeGoto(p.arg1());
                        break;

                    case C_IF:
                        w.writeIf(p.arg1());
                        break;

                    case C_ERROR:
                        System.err.println("error detecting command type.");
                        p.printParsed();

                    default:
                        System.out.println("something wrong parsed command types");
                        break;
                }
            }
        }


        w.close();
    }
} 