package org.example;

import java.util.List;
import java.util.stream.Collectors;

public class HackAssembler {

    protected final SymbolTable st;
    protected final Parser parser;
    protected final Code code;


    HackAssembler(List<String> rawInstructions) {
        st = new SymbolTable();
        parser = new Parser(clean(rawInstructions));
        code = new Code();
    }

    public void run() {
        populateSymbolTable();
        translate();
    }

    public void translate() {
        while (parser.hasMoreInstructions()) {
            if (parser.instructionType().equals("A")) {
                System.out.println(parser.getInstruction() + "->" + translateAInstr());
            }
            else if (parser.instructionType().equals("C")) {
                System.out.println(parser.getInstruction() + "->" + translateCInstr());
            }
            this.parser.advance();
        }
    }

    public String translateCInstr() {
        String dest = code.dest(parser.dest());
        String comp = code.comp(parser.comp());
        String jump = code.jump(parser.jump());
        return "111" + dest + comp + jump;
    }

    public String translateAInstr() {
        int symbol = st.get(parser.symbol());
        return String.format("%16s", Integer.toBinaryString(symbol)).replace(' ', '0');
    }

    protected List<String> clean(List<String> rawInstructions) {
        return rawInstructions
                .stream()
                .map(str -> str.replaceAll("//.*$", ""))
                .filter(line -> !line.isEmpty())
                .map(String::trim)
                .collect(Collectors.toList());
    }

    protected void populateSymbolTable() {
        int lineNum = 0;
        int heap = 16;

        // first pass to get all symbols
        while (parser.hasMoreInstructions()) {
            if (parser.instructionType().equals("L")) {
                st.put(parser.symbol(), lineNum);
            } else {
                lineNum++;
            }
            parser.advance();
        }
        parser.reset();

        // second pass to populate all variables
        while (parser.hasMoreInstructions()) {
            if (parser.instructionType().equals("A") && !st.contains(parser.symbol())) {
                st.put(parser.symbol(), heap++);
            }
            parser.advance();
        }
        parser.reset();
    }
}
