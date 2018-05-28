package com.dakakolp;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

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

        Font font = new Font("SansSerif", Font.BOLD, 14);
        Button openfile = new Button("Open file");
        Button close = new Button("Close");
        openfile.addActionListener(this);
        openfile.setActionCommand("open");
        openfile.setFont(font);
        close.addActionListener(this);
        close.setActionCommand("close");
        close.setFont(font);
        p.add(openfile);
        p.add(close);

        this.pack();

        if(directory == null){
            File f;
            if((fileName != null) && (f = new File(fileName)).isAbsolute()) {
                directory = f.getParent();
                fileName = f.getName();
            } else {
                directory = System.getProperty("user.dir");
            }
        }
        this.directory = directory;
        setFile(directory, fileName);
    }

    private void setFile(String directory, String fileName) {
        if((fileName == null) || (fileName.length() == 0)) return;

        File f;

        FileReader in = null;

        try {
            f = new File(directory, fileName);
            in = new FileReader(f);
            char[] buffer = new char[4096];
            int len;
            textArea.setText("");
            while((len = in.read(buffer)) != -1) {
                String s = new String(buffer, 0, len);
                textArea.append(s);
            }
            this.setTitle("FileViewer: " + fileName);
            textArea.setCaretPosition(0);
        } catch (IOException e) {
            textArea.setText(e.getClass().getName() + ": " + e.getMessage());
            this.setTitle("FileViewer: " + fileName + ": IOException");
        } finally {
            try {
                if (in != null)
                    in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public FileViewer() {
        this(null, null);
    }

    public FileViewer(String fileName) {
        this(null, fileName);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if(cmd.equals("open")) {
            FileDialog f = new FileDialog(this, "Open File", FileDialog.LOAD);
            f.setDirectory(directory);

            f.show();
            directory = f.getDirectory();
            setFile(directory, f.getFile());
            f.dispose();
        } else if (cmd.equals("close"))
            this.dispose();
    }

    public static void main(String[] args) {
        Frame f = new FileViewer((args.length == 1) ? args[0] : null);
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                System.exit(0);
            }
        });
        f.show();
    }

}
