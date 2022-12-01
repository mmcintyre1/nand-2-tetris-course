package org.example;

import java.util.List;

public class Parser {
    private final List<String> instructions;
    Integer currentInstructionIndex;

    Parser(List<String> instructions) {
        currentInstructionIndex = 0;
        this.instructions = instructions;
    }

    public void advance() {
        if (hasMoreInstructions()) this.currentInstructionIndex++;
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
        String currentInst = this.instructions.get(this.currentInstructionIndex);
        if (!currentInst.contains("=")) return null;
        return currentInst.split("=")[0];
    }

    String comp() {
        if (!this.instructionType().equals("C")) return null;
        String currentInst = this.instructions.get(this.currentInstructionIndex);
        // factor in whether there is an equals sign or not
        int start = 0;
        if (currentInst.contains("=")) start = currentInst.indexOf("=") + 1;
        int end = currentInst.length();
        if (currentInst.contains(";")) end = currentInst.indexOf(";");
        return currentInst.substring(start, end);
    }

    String jump() {
        if (!this.instructionType().equals("C")) return null;
        String currentInst = this.instructions.get(this.currentInstructionIndex);
        if (!currentInst.contains(";")) return null;
        return currentInst.substring(currentInst.indexOf(";") + 1);
    }
}
