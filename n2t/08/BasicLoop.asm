@0
D=A
@SP
AM=M+1
A=A-1
M=D
@LCL
D=M
@0
A=D+A
D=D+A
@R13
M=D
@SP
A=M
M=D
@SP
M=M+1
@R13
A=M
M=D
(LOOP)
@ARG
D=M
@0
A=D+A
D=M
@SP
A=M
M=D
@SP
M=M+1
@LCL
D=M
@0
A=D+A
D=M
@SP
A=M
M=D
@SP
M=M+1
@SP
M=M-1
A=M
D=M
@SP
M=M-1
@SP
A=M
M=D+M
@SP
M=M+1
@LCL
D=M
@0
A=D+A
D=D+A
@R13
M=D
@SP
A=M
M=D
@SP
M=M+1
@R13
A=M
M=D
@ARG
D=M
@0
A=D+A
D=M
@SP
A=M
M=D
@SP
M=M+1
@1
D=A
@SP
AM=M+1
A=A-1
M=D
@SP
M=M-1
A=M
D=M
@SP
M=M-1
@SP
A=M
M=M-D
@SP
M=M+1
@ARG
D=M
@0
A=D+A
D=D+A
@R13
M=D
@SP
A=M
M=D
@SP
M=M+1
@R13
A=M
M=D
@ARG
D=M
@0
A=D+A
D=M
@SP
A=M
M=D
@SP
M=M+1
@SP
AM=M-1
D=M
@LOOP
D;JNE
@LCL
D=M
@0
A=D+A
D=M
@SP
A=M
M=D
@SP
M=M+1
