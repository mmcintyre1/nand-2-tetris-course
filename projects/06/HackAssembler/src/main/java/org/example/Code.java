package org.example;

import java.util.Arrays;
import java.util.HashMap;

public class Code {
    HashMap<String, String> destLookup = new HashMap<>();
    HashMap<String, String> compLookup = new HashMap<>();
    HashMap<String, String> jumpLookup = new HashMap<>();

    Code () {
        // dest lookups
        destLookup.put(null, "000");
        destLookup.put("M", "001");
        destLookup.put("D", "010");
        destLookup.put("DM", "011");
        destLookup.put("MD", "011");
        destLookup.put("A", "100");
        destLookup.put("AM", "101");
        destLookup.put("MA", "101");
        destLookup.put("AD", "110");
        destLookup.put("DA", "110");
        destLookup.put("AMD", "111");
        destLookup.put("ADM", "111");
        destLookup.put("MDA", "111");
        destLookup.put("MAD", "111");
        destLookup.put("DAM", "111");
        destLookup.put("DMA", "111");

        // comp lookups
        compLookup.put("0", "0101010");
        compLookup.put("1", "0111111");
        compLookup.put("-1", "0111010");
        compLookup.put("D", "0001100");
        compLookup.put("A", "0110000");
        compLookup.put("M", "1110000");
        compLookup.put("!D", "0001101");
        compLookup.put("!A", "0110001");
        compLookup.put("!M", "1110001");
        compLookup.put("-D", "0001111");
        compLookup.put("-A", "0110011");
        compLookup.put("-M", "1110011");
        compLookup.put("D+1", "0011111");
        compLookup.put("A+1", "0110111");
        compLookup.put("M+1", "1110111");
        compLookup.put("D-1", "0001110");
        compLookup.put("A-1", "0110010");
        compLookup.put("M-1", "1110010");
        compLookup.put("D+A", "0000010");
        compLookup.put("A+D", "0000010");
        compLookup.put("D+M", "1000010");
        compLookup.put("M+D", "1000010");
        compLookup.put("D-A", "0010011");
        compLookup.put("D-M", "1010011");
        compLookup.put("A-D", "0000111");
        compLookup.put("M-D", "1000111");
        compLookup.put("D&A", "0000000");
        compLookup.put("A&D", "0000000");
        compLookup.put("D&M", "1000000");
        compLookup.put("M&D", "1000000");
        compLookup.put("D|A", "0010101");
        compLookup.put("A|D", "0010101");
        compLookup.put("D|M", "1010101");
        compLookup.put("M|D", "1010101");

        // jump lookups
        jumpLookup.put(null, "000");
        jumpLookup.put("JGT", "001");
        jumpLookup.put("JEQ", "010");
        jumpLookup.put("JGE", "011");
        jumpLookup.put("JLT", "100");
        jumpLookup.put("JNE", "101");
        jumpLookup.put("JLE", "110");
        jumpLookup.put("JMP", "111");

    }

    public String comp(String value) {
        return compLookup.get(value);
    }

    public String dest(String value) {
        return destLookup.get(value);
    }

    public String jump(String value) {
        return jumpLookup.get(value);
    }
}
