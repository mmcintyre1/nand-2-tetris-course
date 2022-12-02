package org.example;

import java.util.HashMap;

public class SymbolTable {
    HashMap<String, Integer> st;

    SymbolTable() {
        st = new HashMap<>();
        seedTable();
    }

    private void seedTable() {
        for (int i=0; i<16; i++) {
            st.put("R" + i, i);
        }
        st.put("SCREEN", 16384);
        st.put("KBD", 24576);
        st.put("SP", 0);
        st.put("LCL", 1);
        st.put("ARG", 2);
        st.put("THIS", 3);
        st.put("THAT", 4);
    }

    boolean contains(String symbol) {
        return st.containsKey(symbol);
    }

    Integer get(String symbol) {
        if (!this.contains(symbol)) {
            return null;
        } else {
            return st.get(symbol);
        }
    }

    void put(String symbol, int memoryLocation) {
        if (!this.contains(symbol)) {
            st.put(symbol, memoryLocation);
        }
    }

    void remove(String symbol) {
        System.err.println("Not Implemented");
        System.exit(0);
    }
}
