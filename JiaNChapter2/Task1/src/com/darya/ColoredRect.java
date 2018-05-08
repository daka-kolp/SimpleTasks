package com.darya;

import java.awt.*;

public class ColoredRect extends DrawableRect {

    protected Color border, fill;

    public ColoredRect(int x1, int y1, int x2, int y2, Color border, Color fill) {
        super(x1, y1, x2, y2);
        this.border = border;
        this.fill = fill;
    }

    public ColoredRect(Rect r, Color border, Color fill) {
        super(r);
        this.border = border;
        this.fill = fill;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(fill);
        g.fillRect(getX1(), getY1(), (getX2() - getX1()), (getY2() - getY1()));
        g.setColor(border);
        g.drawRect(getX1(), getY1(), (getX2() - getX1()), (getY2() - getY1()));
    }
}
