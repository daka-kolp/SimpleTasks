package com.darya;

public class Rect {
    private int x1, y1, x2, y2;

    public Rect(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }

    public int getX2() {
        return x2;
    }

    public int getY2() {
        return y2;
    }

    public Rect(int width, int height) {
        this(0,0, width, height);
    }

    public Rect() {
        this(0,0,0,0);
    }

    public Rect(Rect r) {
        this(r.x1,r.y1,r.x2,r.y2);
    }

    public void move(int deltax, int deltay){
        x1 += deltax; x2 += deltax;
        y1 += deltay; y2 += deltay;
    }

    public boolean isInside(int x, int y){
        boolean ii = ((x >= x1) && (x <= x2) && (y >= y1) && (y <= y2));
        return  ii;
    }

    public Rect union(Rect r){
        Rect result = new Rect((this.x1 < r.x1) ? this.x1 : r.x1,
                                (this.y1 < r.y1) ? this.y1 : r.y1,
                                (this.x2 > r.x2) ? this.x2 : r.x2,
                                (this.y2 > r.y2) ? this.y2 : r.y2);
        return result;
    }

    public Rect intersaction(Rect r){
        Rect result = new Rect((this.x1 > r.x1) ? this.x1 : r.x1,
                                (this.y1 > r.y1) ? this.y1 : r.y1,
                                (this.x2 < r.x2) ? this.x2 : r.x2,
                                (this.y2 < r.y2) ? this.y2 : r.y2);
        if (result.x1 > result.x2) { result.x1 = result.x2 = 0; }
        if (result.y1 > result.y2) { result.y1 = result.y2 = 0; }
        return result;
    }

    @Override
    public String toString() {
        return "[" + x1 + ", " + y1 + "; " + x2 + ", " + y2 + "]";
    }
}
