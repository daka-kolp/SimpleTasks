package com.darya;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task5 {

    public static void main(String[] args) throws IOException {
        functionStringBuffer();
    }

    //StringBuffer use to keep String
    private static void functionStringBuffer() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            String line = reader.readLine();
            if ((line == null) || line.equals("quit")) break;

            StringBuffer buffer = new StringBuffer(line);
            for(int i = 0; i < buffer.length(); i++) buffer.setCharAt(i, rot13(buffer.charAt(i)));
            System.out.println(buffer);
        }
    }

    private static char rot13(char c) {
        if((c >= 'A') && (c <= 'Z')) {
            c += 13;
            if(c > 'Z') c -= 26;
        }
        if((c >= 'a') && (c <= 'z')) {
            c += 13;
            if(c > 'z') c -= 26;
        }
        return c;
    }
}
