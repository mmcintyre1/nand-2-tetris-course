// This file is part of www.nand2tetris.org
// and the book "The Elements of Computing Systems"
// by Nisan and Schocken, MIT Press.
// File name: projects/04/Fill.asm

// Runs an infinite loop that listens to the keyboard input.
// When a key is pressed (any key), the program blackens the screen,
// i.e. writes "black" in every pixel;
// the screen should remain fully black as long as the key is pressed.
// When no key is pressed, the program clears the screen, i.e. writes
// "white" in every pixel;
// the screen should remain fully clear as long as no key is pressed.


(RESET)
	@SCREEN
	D=A
	@addr
	M=D

(KBLOOP)
	@KBD
	D=M
	@FILL
	D;JGT
	@CLEAR
	D;JEQ
	@KBLOOP
	0;JMP

(FILL)
	@color
	M=-1
	@FLIP
	0;JMP

(CLEAR)
	@color
	M=0
	@FLIP
	0;JMP

(FLIP)
	@color
	D=M // get black or white

	@addr
	A=M // get current screen address and set A
	M=D // set value to black or white

	@addr
	D=M+1 // increment value in addr and save in D for later computation

	@KBD
	D=A-D // subtract KBD from current addr stored in D
	@addr
	M=M+1 // increment addr
	A=M // set addr
	@FLIP
	D;JGT // if KBD-addr > 0 goto start of FLIP loop

	@RESET
	0;JMP // if KBD-addr <= 0, goto RESET