package org.example;

import java.util.List;
import java.util.Objects;

public class Parser {
    private final List<String> instructions;
    Integer currentInstructionIndex;

    Parser(List<String> instructions) {
        currentInstructionIndex = 0;
        this.instructions = instructions;
    }

    public void advance() {
        if (!hasMoreInstructions()) this.currentInstructionIndex++;
    }

    public Boolean hasMoreInstructions() {
        return this.currentInstructionIndex < this.instructions.size();

    }

    public String instructionType() {
        String rawInst = this.instructions.get(this.currentInstructionIndex);
        return switch (rawInst.substring(0, 1)) {
            case "@" -> "A";
            case "(" -> "L";
            default -> "C";
        };

    }

    String symbol() {
        if (!this.instructionType().equals("A")) return null;
        return this.instructions.get(this.currentInstructionIndex).substring(1);
    }

    String dest() {
        if (!this.instructionType().equals("C")) return null;
        return "";
    }

    String comp() {
        if (!this.instructionType().equals("C")) return null;
        return "";
    }

    String jump() {
        if (!this.instructionType().equals("C")) return null;
        return "";
    }
}
