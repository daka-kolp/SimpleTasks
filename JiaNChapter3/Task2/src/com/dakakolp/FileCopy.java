package com.dakakolp;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileCopy {

    private static void abort(String msg) throws IOException {
        throw new IOException("FileCopy: " + msg);
    }

    public static void copy(String from_name, String to_name) throws IOException {
        File from_file = new File(from_name);
        File to_file = new File(to_name);

        if(!from_file.exists()) abort("The file does not exist: " + from_name);

        if(!from_file.isFile()) abort("The impossible to copy the directory: " + from_name);

        if(!from_file.canRead()) abort("The file for reading is not accessible: " + from_name);

        if(to_file.isDirectory()) to_file = new File(to_file, from_file.getName());

        if(to_file.exists()) {
            if(!to_file.canWrite()) abort("The file for writing is not accessible: " + to_name);

            System.out.println("Rewrite the file " + to_file.getName() + "? (Y/N): ");
            System.out.flush();

            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

            String response = in.readLine();
            if(!response.equals("Y") && !response.equals("y")) abort("The file has not been rewritten");
        } else {
            
        }



    }

    public static void main(String[] args) {

    }
}
