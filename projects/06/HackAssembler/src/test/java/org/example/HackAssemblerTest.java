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

    @Test
    void populateSymbolTable() {
        List<String> instructions = new ArrayList<>();
        instructions.add("@sum"); // 0
        instructions.add("(LOOP)"); //
        instructions.add("D=M"); // 1
        instructions.add("@END"); // 2
        instructions.add("@i"); // 3
        instructions.add("(END)"); //
        instructions.add("M=D"); // 4

        HackAssembler ha = new HackAssembler(instructions);
        ha.populateSymbolTable();
        assertEquals(ha.st.get("LOOP"), 1);
        assertEquals(ha.st.get("sum"), 16);
        assertEquals(ha.st.get("i"), 17);
        assertEquals(ha.st.get("END"), 4);
    }
}