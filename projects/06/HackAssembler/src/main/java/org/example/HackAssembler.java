package org.example;

import java.util.List;
import java.util.stream.Collectors;

public class HackAssembler {

    protected final SymbolTable st;
    protected final Parser parser;
    protected final Code code;
    protected int heap;


    HackAssembler(List<String> rawInstructions) {
        heap = 15;
        st = new SymbolTable();
        parser = new Parser(clean(rawInstructions));
        code = new Code();
    }

    public void run() {
        translateSymbols();
        translateToMachineCode();
    }

    public void translateToMachineCode() {
        while (parser.hasMoreInstructions()) {
            if (parser.instructionType().equals("A")) {

                System.out.println(translateAInstr());
            }
            else if (parser.instructionType().equals("C")) {
                System.out.println(translateCInstr());
            }
            this.parser.advance();
        }
    }

    public String translateCInstr() {
        String dest = code.dest(parser.dest());
        String comp = code.comp(parser.comp());
        String jump = code.jump(parser.jump());
        return "111" + comp + dest + jump;
    }

    public String translateAInstr() {
        int symbol = heap;
        if (isInteger(parser.symbol())) {
            symbol = Integer.parseInt(parser.symbol());
        } else if (st.contains(parser.symbol())) {
            symbol = st.get(parser.symbol());
        } else {
            st.put(parser.symbol(), heap++);
        }
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

    protected void translateSymbols() {
        int lineNum = 0;
        int heap = 15;

        // first pass to populate all symbols
        while (parser.hasMoreInstructions()) {
            if (parser.instructionType().equals("L")) {
                st.put(parser.symbol(), lineNum);
            } else {
                lineNum++;
            }
            parser.advance();
        }
        parser.reset();
    }

    private boolean isInteger( String input ) {
    try {
        Integer.parseInt( input );
        return true;
    }
    catch( NumberFormatException e ) {
        return false;
    }
}
}
