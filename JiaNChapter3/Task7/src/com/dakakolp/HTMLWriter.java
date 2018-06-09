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
        if ((window == null) || (document == null)) return;

        if (((Boolean)window.getMember("closed")).booleanValue()) return;

        String s = new String(cbuf, off, len);

        document.call("write", new String[] {s});
    }

    @Override
    public void flush() throws IOException {

    }

    @Override
    public void close() throws IOException {
        document.call("close", null);
        document = null;
    }

    public void closeWindow() throws IOException {
        if (document != null) close();

        if(!((Boolean)window.getMember("closed")).booleanValue())
            window.call("close", null);
        window = null;
    }

    @Override
    protected void finalize() throws Throwable {
        closeWindow();
    }

    public static class Test extends Applet {
        HTMLWriter out;

        public void init (){
            try {
                URL url = new URL(this.getDocumentBase(), this.getParameter("url"));
                Reader in = new InputStreamReader(url.openStream());
                out = new HTMLWriter(this, 400, 200);
                char[] buffer = new char[4096];
                int numchars;
                while ((numchars = in.read(buffer)) != -1)
                    out.write(buffer, 0, numchars);
                in.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void destroy() {
            try {
                out.closeWindow();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
