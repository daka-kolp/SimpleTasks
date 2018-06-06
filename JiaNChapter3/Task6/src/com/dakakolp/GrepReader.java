package com.dakakolp;

import java.io.*;

public class GrepReader extends BufferedReader {

    String pattern;

    public GrepReader(Reader in, String pattern) {
        super(in);
        this.pattern = pattern;
    }

    @Override
    public String readLine() throws IOException {
        String line;
        do {
            line = super.readLine();
        } while ((line != null) && line.indexOf(pattern) == -1);
        return line;
    }

    public static class Test {
        public static void main(String[] args) {
            try {
                if (args.length != 2)
                    throw new IllegalArgumentException ("Incorrect arguments' number ");
                GrepReader in = new GrepReader(new FileReader(args[1]), args[0]);
                String line;
                while((line = in.readLine()) != null) System.out.println(line);
                in.close();
            } catch (Exception e) {
                System.err.println(e);
                System.out.println("Format: java GrepReader$Test <simple> <file>");
            }
        }
    }
}
