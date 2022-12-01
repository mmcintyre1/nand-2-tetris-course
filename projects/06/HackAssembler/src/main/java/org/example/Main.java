package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.err.println("incorrect command line parameters. usage: HackAssembler <filename>");
            System.exit(0);
        }
        String filename = args[0];
        HackAssembler ha = new HackAssembler();
        ha.run(filename);
    }
}
