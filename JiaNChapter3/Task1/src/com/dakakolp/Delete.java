package com.dakakolp;

import java.io.File;

public class Delete {

    protected static void fail(String msg) throws IllegalArgumentException {
        throw new IllegalArgumentException(msg);
    }

    public static void delete(String filename) {
        File f = new File(filename);
        if (!f.exists()) fail("Delete: the file or the directory doesn't exist");

        if (!f.canWrite()) fail("Delete: this is write-protected");

        if (f.isDirectory()) {
            String[] files = f.list();

            if (files.length > 0) fail ("Delete: the directory isn't empty");
        }

        boolean success = f.delete();

        if (!success) fail("Delete: deleting has not done");
    }


    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("The command's format: java Delete <file or directory>");
            System.exit(0);
        }

        try {
            delete(args[0]);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}
