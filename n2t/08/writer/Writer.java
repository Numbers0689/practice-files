package writer;

import parser.Command;
import java.io.*;

public class Writer {
    PrintWriter outFile;
    String outFilename;
    int lableCount;

    public Writer(String filename) {
        lableCount = 0;

        try {
            outFile = new PrintWriter(new BufferedWriter(new FileWriter(filename)));
        } catch (IOException e) {}
    }

    public void setFileName(String filename) {
        outFilename = filename;
    }

    public void writeArithmetic(String command) {
        switch (command) {
            case "add":
                popStacktoD();
                decrementStack();
                loadStackPtrtoA();
                outFile.println("M=D+M");
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
                        outFile.println("@SP");
                        outFile.println("AM=M+1");
                        outFile.println("A=A-1");
                        outFile.println("M=D");
                        break;
                
                    case "local":
                        loadSegment("LCL", index);
                        outFile.println("D=M");
                        pushDtoStack();
                        break;
                    case "argument":
                        loadSegment("ARG", index);
                        outFile.println("D=M");
                        pushDtoStack();
                        break;
                    case "this":
                        loadSegment("THIS", index);
                        outFile.println("D=M");
                        pushDtoStack();
                        break;
                    case "that":
                        loadSegment("THAT", index);
                        outFile.println("D=M");
                        pushDtoStack();
                        break;

                    case "temp":
                        outFile.println("@R"+ (5 + index));
                        outFile.println("D=M");
                        pushDtoStack();
                        break;

                    case "pointer":
                        outFile.println("@R"+ (3 + index));
                        outFile.println("D=M");
                        pushDtoStack();
                        break;

                    case "static":
                        outFile.println("@" + outFilename + "." + index);
                        outFile.println("D=M");
                        pushDtoStack();
                        break;

                    default:
                        break;
                }
                break;
        
            case C_POP:
                    switch (segment) {
                        case "constant":
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
                    outFile.println("D=D+A");
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
        outFile.println("(" + lable + ")");
    }

    public void writeGoto(String lable) {
        outFile.println("@" + lable);
        outFile.println("0;JMP");
    }

    public void writeIf(String lable) {
        outFile.println("@SP");
        outFile.println("AM=M-1");
        outFile.println("D=M");
        outFile.println("@" + lable);
        outFile.println("D;JNE");
    }

    public void writeFunction(String functionName, int nVars) {
        outFile.println("(" + functionName + ")");

        for (int i = 0; i < nVars; i++) writePushPop(Command.C_PUSH, "constant", 0);
    }

    public void writeInit() {
        outFile.println("@256");
        outFile.println("D=A");
        outFile.println("@SP");
        outFile.println("M=D");
        writeCall("Sys.init", 0);
    }

    public void writeCall(String functionName, int nArgs) {
        String lable = functionName + "$ret." + lableCount;
        lableCount++;
        String[] segs = {"LCL", "ARG", "THIS", "THAT"};

        outFile.println("@" + lable);
        outFile.println("D=A");
        pushDtoStack();

        for (String seg : segs) {
            outFile.println("@" + seg);
            outFile.println("D=M");
            pushDtoStack();
        }

        outFile.println("@SP");
        outFile.println("D=M");
        outFile.println("@5");
        outFile.println("D=D-A");
        outFile.println("@" + nArgs);
        outFile.println("D=D-A");
        outFile.println("@ARG");
        outFile.println("M=D");

        outFile.println("@SP");
        outFile.println("D=M");
        outFile.println("@LCL");
        outFile.println("M=D");

        outFile.println("@" + functionName);
        outFile.println("0;JMP");

        outFile.println("(" + lable + ")");
    }

    public void writeReturn() {
        String[] segs = {"THAT", "THIS", "ARG", "LCL"};

        outFile.println("@LCL");
        outFile.println("D=M");
        outFile.println("@R13");
        outFile.println("M=D");

        outFile.println("@5");
        outFile.println("A=D-A");
        outFile.println("D=M");
        outFile.println("@R14");
        outFile.println("M=D");

        outFile.println("@SP");
        outFile.println("AM=M-1");
        outFile.println("D=M");
        outFile.println("@ARG");
        outFile.println("A=M");
        outFile.println("M=D");

        outFile.println("@ARG");
        outFile.println("D=M+1");
        outFile.println("@SP");
        outFile.println("M=D");

        for (String seg : segs) {
            outFile.println("@R13");
            outFile.println("AM=M-1");
            outFile.println("D=M");
            outFile.println("@" + seg);
            outFile.println("M=D");
        }

        outFile.println("@R14");
        outFile.println("A=M");
        outFile.println("0;JMP");
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
