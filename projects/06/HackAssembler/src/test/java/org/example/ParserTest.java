package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {


    @Test
    void testAdvance() {
        List<String> instructions = new ArrayList<>();
        instructions.add("@sum");
        instructions.add("@R0");

        Parser p = new Parser(instructions);
        assertEquals(p.getInstruction(), "@sum");
        p.advance();
        assertEquals(p.getInstruction(), "@R0");
        p.advance();
        assertFalse(p.hasMoreInstructions());
    }

    @Test
    void testHasMoreInstructions() {
        List<String> instructions = new ArrayList<>();
        instructions.add("@sum");
        instructions.add("D;JGT");

        Parser p = new Parser(instructions);
        assertTrue(p.hasMoreInstructions());
        p.advance();
        assertTrue(p.hasMoreInstructions());
        p.advance();
        assertFalse(p.hasMoreInstructions());
    }

    @Test
    void testInstructionType() {
        List<String> instructions = new ArrayList<>();
        instructions.add("@sum");
        instructions.add("D;JGT");
        instructions.add("(LOOP)");

        Parser p = new Parser(instructions);
        assertEquals(p.instructionType(), "A");
        p.advance();
        assertEquals(p.instructionType(), "C");
        p.advance();
        assertEquals(p.instructionType(), "L");
    }

    @Test
    void testSymbol() {
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
    void testDest() {
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
    void testComp() {
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
    void testJump() {
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