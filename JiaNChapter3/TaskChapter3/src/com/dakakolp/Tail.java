package com.dakakolp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Tail {
    private void setFile(String fileName) {
        if((fileName == null) || (fileName.length() == 0)) return;

        BufferedReader in = null;

        try {
            in = new BufferedReader(new FileReader(new File(fileName)));

            String s;
            int count = 0;
            while((s = in.readLine()) != null) {
                count++;
            }
            in.close();
            int ind = 0;
            int lim = count - 10;
            in = new BufferedReader(new FileReader(new File(fileName)));
            while((s = in.readLine()) != null) {
                ind++;
                if (ind > lim) System.out.println(s);
            }
        } catch (IOException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.err.println("FileViewer: " + fileName + ": IOException");
        } finally {
            try {
                if (in != null)
                    in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Tail().setFile("/home/darya/MyProjects/IdeaProjects/JiaNChapter3/production/TaskChapter3/com/dakakolp/qwerty");
    }
}
