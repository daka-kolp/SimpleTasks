package com.dakakolp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class CharacterCounter {
    public void countCharacter(String fileName) {
        if((fileName == null) || (fileName.length() == 0)) return;

        BufferedReader in = null;

        int charCount = 0;
        int wordCount = 0;
        int lineCount = 0;

        try {
            in = new BufferedReader(new FileReader(new File(fileName)));

            String s = in.readLine();

            while(s != null) {

                lineCount++;

                String[] words = s.split(" ");
                wordCount += words.length;

                for (String word : words) {
                    charCount += word.length();
                }

                s = in.readLine();
            }
            System.out.println("Chars: " + charCount);
            System.out.println("Words: " + wordCount);
            System.out.println("Lines: " + lineCount);

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
        new CharacterCounter().countCharacter("/home/darya/MyProjects/IdeaProjects/JiaNChapter3/production/TaskChapter3/com/dakakolp/qwerty");
    }
}
