package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HackAssemblerTest {

    @Test
    void run() {
    }

    @Test
    void clean() {
    }

//    @Test
//    void testPopulateSymbolTable() {
//        List<String> instructions = new ArrayList<>();
//        instructions.add("@sum"); // 0
//        instructions.add("(LOOP)"); //
//        instructions.add("D=M"); // 1
//        instructions.add("@END"); // 2
//        instructions.add("@i"); // 3
//        instructions.add("@output.0"); // 4
//        instructions.add("(END)"); //
//        instructions.add("M=D"); // 5
//
//        HackAssembler ha = new HackAssembler(instructions);
//        ha.populateSymbolTable();
//        assertEquals(ha.st.get("LOOP"), 1);
//        assertEquals(ha.st.get("sum"), 15);
//        assertEquals(ha.st.get("i"), 16);
//        assertEquals(ha.st.get("END"), 5);
//        assertEquals(ha.st.get("output.0"), 17);
//    }
}