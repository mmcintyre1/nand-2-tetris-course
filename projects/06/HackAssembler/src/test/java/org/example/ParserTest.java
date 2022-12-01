package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {


    @Test
    void advance() {
    }

    @Test
    void hasMoreInstructions() {
    }

    @Test
    void instructionType() {
    }

    @Test
    void symbol() {
        List<String> instructions = new ArrayList<>();
        instructions.add("@sum");
        instructions.add("@R0");
        instructions.add("@R1");

        Parser p = new Parser(instructions);
        assertEquals(p.symbol(), "sum");
        p.advance();
        assertEquals(p.symbol(), "R0");
        p.advance();
        assertEquals(p.symbol(), "R1");

    }

    @Test
    void dest() {
        List<String> instructions = new ArrayList<>();
        instructions.add("D;JGT");
        instructions.add("D=D-M");
        instructions.add("M=D");

        Parser p = new Parser(instructions);
        assertNull(p.dest());
        p.advance();
        assertEquals(p.dest(), "D");
        p.advance();
        assertEquals(p.dest(), "M");
    }

    @Test
    void comp() {
        List<String> instructions = new ArrayList<>();
        instructions.add("D;JGT");
        instructions.add("D=D-M");
        instructions.add("M=D");

        Parser p = new Parser(instructions);
        assertEquals(p.comp(), "D");
        p.advance();
        assertEquals(p.comp(), "D-M");
        p.advance();
        assertEquals(p.comp(), "D");
    }

    @Test
    void jump() {
        List<String> instructions = new ArrayList<>();
        instructions.add("D;JGT");
        instructions.add("D=D-M");
        instructions.add("M=D");

        Parser p = new Parser(instructions);
        assertEquals(p.jump(), "JGT");
        p.advance();
        assertNull(p.jump());
        p.advance();
        assertNull(p.jump());
    }
}