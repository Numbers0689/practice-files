// This file is part of www.nand2tetris.org
// and the book "The Elements of Computing Systems"
// by Nisan and Schocken, MIT Press.
// File name: projects/4/Fill.asm

// Runs an infinite loop that listens to the keyboard input. 
// When a key is pressed (any key), the program blackens the screen,
// i.e. writes "black" in every pixel. When no key is pressed, 
// the screen should be cleared.

(LOOP)
    @SCREEN // set addr to SCREEN address
    D=A
    @addr
    M=D

    @KBD // set n to KBD - 1
    D=A
    @n
    M=D-1

    @KBD    // check key press
    D=M
    @PAINTB
    D;JNE

    @PAINTW
    0;JMP

(PAINTB)
    @addr
    D=M
    @n
    D=M-D
    @LOOP
    D;JLT

    @addr
    A=M
    M=-1
    @addr
    M=M+1
    
    @PAINTB
    0;JMP

(PAINTW)
    @addr
    D=M
    @n
    D=M-D
    @LOOP
    D;JLT

    @addr
    A=M
    M=0
    @addr
    M=M+1

    @PAINTW
    0;JMP