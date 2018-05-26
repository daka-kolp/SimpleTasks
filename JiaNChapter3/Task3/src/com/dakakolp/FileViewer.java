package com.dakakolp;

import java.awt.*;
import java.awt.event.*;

public class FileViewer extends Frame implements ActionListener {
    String directory;
    TextArea textArea;

    public FileViewer(String directory, String fileName) {
        super();

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        textArea = new TextArea("", 24, 80);
        textArea.setFont(new Font("MonoSpaced", Font.PLAIN, 12));
        textArea.setEditable(false);
        this.add("Center", textArea);

        Panel p = new Panel();
        p.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 5));
        this.add("South", p);

        Font font = new Font
    }

    public FileViewer() {
        this(null, null);
    }
}
