package com.darya;

import java.awt.*;

public class DrawableRect extends Rect{

    public DrawableRect(int x1, int y1, int x2, int y2) {
        super(x1, y1, x2, y2);
    }

    public DrawableRect(Rect r) {
        super(r);
    }

    public void draw(Graphics g) {
        g.drawRect(getX1(), getY1(), (getX2() - getX1()), (getY2() - getY1()));
    }
}
