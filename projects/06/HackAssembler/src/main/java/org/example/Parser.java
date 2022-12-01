package org.example;

import java.util.List;

public class Parser {
    private final List<String> instructions;
    private Integer currentInstructionIndex;

    Parser(List<String> instructions) {
        currentInstructionIndex = 0;
        this.instructions = instructions;
    }

    public void reset() {
        this.currentInstructionIndex = 0;
    }

    public String getInstruction () {
        return this.instructions.get(this.currentInstructionIndex);
    }

    public void advance() {
        if (hasMoreInstructions()) this.currentInstructionIndex++;
    }

    public Boolean hasMoreInstructions() {
        return this.currentInstructionIndex < this.instructions.size();
    }

    public String instructionType() {
        return switch (getInstruction().substring(0, 1)) {
            case "@" -> "A";
            case "(" -> "L";
            default -> "C";
        };
    }

    public String symbol() {
        return switch(instructionType()) {
            case "A" -> getInstruction().substring(1);
            case "L" -> getInstruction().substring(getInstruction().indexOf("(") + 1, getInstruction().indexOf(")"));
            default -> null;
        };
    }

    public String dest() {
        if (!this.instructionType().equals("C")) return null;
        if (!getInstruction().contains("=")) return null;
        return getInstruction().split("=")[0];
    }

    public String comp() {
        if (!this.instructionType().equals("C")) return null;
        // factor in whether there is an equals sign or not
        int start = 0;
        if (getInstruction().contains("=")) start = getInstruction().indexOf("=") + 1;
        int end = getInstruction().length();
        if (getInstruction().contains(";")) end = getInstruction().indexOf(";");
        return getInstruction().substring(start, end);
    }

    public String jump() {
        if (!this.instructionType().equals("C")) return null;
        if (!getInstruction().contains(";")) return null;
        return getInstruction().substring(getInstruction().indexOf(";") + 1);
    }
}
