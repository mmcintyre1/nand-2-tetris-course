package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HackAssembler {

    private SymbolTable st;
    private List<String> instructions;
    private Parser parser;


    HackAssembler() {
        st = new SymbolTable();
        instructions = new ArrayList<>();
    }

    public void run(String filename) throws IOException {
        SymbolTable st = new SymbolTable();

        this.cleanse(filename);
        System.out.println(instructions);



    }

    private void cleanse(String filename) throws IOException {
        try (Stream<String> lines = Files.lines(Path.of(filename))) {
            this.instructions = lines
                    .map(str -> str.replaceAll("//.*$", ""))
                    .filter(line -> !line.isEmpty())
                    .map(String::trim)
                    .collect(Collectors.toList());
        }
    }
}
