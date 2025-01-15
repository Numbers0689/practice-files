package writer;

import parser.Command;
import java.io.*;

public class Writer {
    PrintWriter outFile;
    String outFilename;
    int lableCount;

    public Writer(String filename) {
        outFilename = filename.replace(".asm", "");
        lableCount = 0;

        try {
            outFile = new PrintWriter(new BufferedWriter(new FileWriter(filename)));
        } catch (IOException e) {}
    }

    public void writeArithmetic(String command) {
        switch (command) {
            case "add":
                popStacktoD();
                decrementStack();
                loadStackPtrtoA();
                outFile.println("M=M+D");
                incrementStack();
                break;

            case "sub":
                popStacktoD();
                decrementStack();
                loadStackPtrtoA();
                outFile.println("M=M-D");
                incrementStack();
                break;
        
            case "neg":
                decrementStack();
                loadStackPtrtoA();
                outFile.println("M=-M");
                incrementStack();
                break;

            case "and":
                popStacktoD();
                decrementStack();
                loadStackPtrtoA();
                outFile.println("M=D&M");
                incrementStack();
                break;

            case "or":
                popStacktoD();
                decrementStack();
                loadStackPtrtoA();
                outFile.println("M=D|M");
                incrementStack();
                break;

            case "not":
                decrementStack();
                loadStackPtrtoA();
                outFile.println("M=!M");
                incrementStack();
                break;

            case "ep":
                compare("JEQ");
                break;
            
            case "gt":
            compare("JGT");
                break;
            
            case "lt":
            compare("JLT");
                break;
        }
    }

    public void writePushPop(Command c, String segment, int index) {
        switch (c) {
            case C_PUSH:
                switch (segment) {
                    case "constant":
                        outFile.println("@" + index);
                        outFile.println("D=A");
                        break;
                
                    case "local":
                        loadSegment("LCL", index);
                        outFile.println("D=M");
                        break;
                    case "argument":
                        loadSegment("ARG", index);
                        outFile.println("D=M");
                        break;
                    case "this":
                        loadSegment("THIS", index);
                        outFile.println("D=M");
                        break;
                    case "that":
                        loadSegment("THAT", index);
                        outFile.println("D=M");
                        break;

                    case "temp":
                        outFile.println("@R"+ (5 + index));
                        outFile.println("D=M");
                        break;

                    case "pointer":
                        outFile.println("@R"+ (3 + index));
                        outFile.println("D=M");
                        break;

                    case "static":
                        outFile.println("@" + outFilename + "." + index);
                        outFile.println("D=M");
                        break;

                    default:
                        break;
                }
                pushDtoStack();
                break;
        
            case C_POP:
                    switch (segment) {
                        case "constant":
                            outFile.println("@" + index);
                            break;
                        
                        case "local":
                            loadSegment("LCL", index);
                            break;

                        case "argument":
                            loadSegment("ARG", index);
                            break;

                        case "this":
                            loadSegment("THIS", index);
                            break;

                        case "that":
                            loadSegment("THAT", index);
                            break;
                        
                        case "temp":
                            outFile.println("@R"+ (5 + index));
                            break;

                        case "pointer":
                            outFile.println("@R"+ (3 + index));
                            break;

                        case "static":
                            outFile.println("@" + outFilename + "." + index);
                            break;

                        default:
                            break;
                    }
                    outFile.println("D=A");
                    outFile.println("@R13");
                    outFile.println("M=D");
                    pushDtoStack();
                    outFile.println("@R13");
                    outFile.println("A=M");
                    outFile.println("M=D");
                break;

        }
    }

    public void writeLable(String lable) {

    }

    public void writeGoto(String lable) {

    }

    public void writeIf(String lable) {

    }

    public void writeFunction(String functionName, int nVars) {

    }

    public void writeCall(String functionName, int nArgs) {

    }

    public void writeReturn() {

    }

    public void close() {
        outFile.close();
    }

    private void popStacktoD() {
        decrementStack();
        outFile.println("A=M");
        outFile.println("D=M");
    }

    private void pushDtoStack() {
        loadStackPtrtoA();
        outFile.println("M=D");
        incrementStack();
    }

    private void loadStackPtrtoA() {
        outFile.println("@SP");
        outFile.println("A=M");
    }

    private void decrementStack() {
        outFile.println("@SP");
        outFile.println("M=M-1");
    }

    private void incrementStack() {
        outFile.println("@SP");
        outFile.println("M=M+1");
    }

    private void loadSegment(String segment, int index) {
        outFile.println("@" + segment);
        outFile.println("D=M");
        outFile.println("@" + index);
        outFile.println("A=D+A");
    }

    private void compare(String cmd) {
        popStacktoD();
        decrementStack();
        loadStackPtrtoA();
        outFile.println("D=M-D");
        outFile.println("@LBL" + lableCount);
        outFile.println("0;" + cmd);
        loadStackPtrtoA();
        outFile.println("M=0");
        outFile.println("@ENDLBL" + lableCount);
        outFile.println("0;JMP");
        outFile.println("(LBL" + lableCount + ")");
        loadStackPtrtoA();
        outFile.println("M=-1");
        outFile.println("(ENDLBL" + lableCount + ")");
        incrementStack();
        lableCount++;
    }
}
