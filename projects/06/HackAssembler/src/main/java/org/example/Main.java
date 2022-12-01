package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.err.println("incorrect command line parameters. usage: HackAssembler <filename>");
            System.exit(0);
        }
        String filename = args[0];
        List<String> rawInstructions = Files.readAllLines(Paths.get(filename));
        HackAssembler ha = new HackAssembler(rawInstructions);
        ha.run();
    }
}
