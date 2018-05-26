package com.dakakolp;

import java.io.*;

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
            String parent = to_file.getParent();
            if(parent == null) parent = System.getProperty("user.dir");

            File dir = new File(parent);

            if(!dir.exists()) abort("The directory does not exist: " + parent);

            if(dir.isFile()) abort("The directory is not directory???: " + parent);

            if(!dir.canWrite()) abort("The directory does not accessible for writing: " + parent);

            FileInputStream from = null;
            FileOutputStream to = null;

            try {
                from = new FileInputStream(from_file);
                to = new FileOutputStream(to_file);

                byte[] buffer = new byte[4096];
                int bytes_read;

                while((bytes_read = from.read(buffer)) != -1)
                    to.write(buffer, 0, bytes_read);
            } finally {
                if (from != null) {
                    try {
                        from.close();
                    } catch (IOException e) {}
                }
                if (to != null) {
                    try {
                        to.close();
                    } catch (IOException e) {}
                }
            }
        }
    }

    public static void main(String[] args) {
        if(args.length != 2)
            System.err.println("Format: java FileCopy <from_file> <to_file>");
        else {
            try {
                copy(args[0], args[1]);
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
