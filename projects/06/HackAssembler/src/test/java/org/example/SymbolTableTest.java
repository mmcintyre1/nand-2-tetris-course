package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SymbolTableTest {

    @Test
    void testContains() {
        SymbolTable st = new SymbolTable();
        st.put("TEST1", 15);
        st.put("TEST2", 16);
        st.put("TEST2", 16);

        assertTrue(st.contains("TEST1"));
        assertFalse(st.contains("TEST3"));
    }

    @Test
    void testGet() {
    }

    @Test
    void testInsert() {
    }
}