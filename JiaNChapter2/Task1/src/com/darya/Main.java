package com.darya;
import com.darya.Rect;

import java.awt.*;

public class Main {
    public static void main(String[] args) {

        Rect r1 = new Rect(1, 1, 4,4);
        Rect r2 = new Rect(2,3,5,6);

        Rect u = r1.union(r2);
        Rect i = r1.intersaction(r2);

        if(u.isInside(r2.getX1(), r2.getY1())) {
            System.out.println("(" + r2.getX1() + ", " + r2.getY1() + ") is inside in union");
        }
        System.out.println(r1 + " union " + r2 + " = " + u);
        System.out.println(r1 + " intersact " + r2 + " = " + i);

        Color b = new Color(12,200,120);
        Color f = new Color(150, 20, 70);
        ColoredRect cr = new ColoredRect(r1, b, f);
               
    }
}
