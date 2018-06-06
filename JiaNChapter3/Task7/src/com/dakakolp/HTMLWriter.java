package com.dakakolp;
import java.io.*;
import java.net.*;
import netscape.javascript.*;
import java.applet.Applet;

public class HTMLWriter extends Writer {

    JSObject main_window;
    JSObject window;
    JSObject document;
    static int window_num = 0;

    public HTMLWriter(Applet applet, int width, int height){
        try {
            Class c = Class.forName("netscape.javascript.JSObject");
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError("HTMLWriter would work in Netscape Navigator 4.0 or "
                    + "latest versions or in browsers with technology LiveConnect");
        }

        main_window = JSObject.getWindow(applet);
        window = (JSObject) main_window.eval("self.open(''," +
                "'HTMLWriter" + window_num++ + "', "+
                "'menubar,status,resizable,scrollbars," +
                "width=" + width + ",height=" + height + "')");
        document = (JSObject) window.getMember("document");
        document.call("open", null);
    }

    @Override
    public void write(char[] cbuf, int off, int len) throws IOException {

    }

    @Override
    public void flush() throws IOException {

    }

    @Override
    public void close() throws IOException {

    }
}
