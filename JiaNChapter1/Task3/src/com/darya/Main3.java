package com.darya;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main3 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String str = reader.readLine();

        for(int j = str.length() - 1; j >= 0; j--) {
            System.out.print(str.charAt(j));
        }
    }

    private static void t3(String[] args) {
        for (int i = args.length - 1; i >= 0; i--) {
            for (int j = args[i].length() - 1; j >= 0; j--) {
                System.out.println(args[i].charAt(j));
            }
            System.out.println(" ");
        }
        System.out.println();
    }
}
