package com.darya;

public class Chapter2 {
    public static void main(String[] args) {

    }

    private class Circle {
        private double radius;
        private double xCenter;
        private double yCenter;

        public Circle(double xCenter, double yCenter, double radius) {
            this.xCenter = xCenter;
            this.yCenter = yCenter;
            this.radius = radius;
        }

        public Circle() {
            this(0, 0, 1);
        }

        public Circle(double radius) {
            this(0, 0, radius);
        }

        public Circle(Circle c) {
            this(c.xCenter, c.yCenter, c.radius);
        }

        public double getRadius(){
            return this.radius;
        }

        public double getxCenter() {
            return this.xCenter;
        }

        public double getyCenter() {
            return this.yCenter;
        }

        public void move(double a, double b) {
            this.xCenter = this.xCenter + a;
            this.yCenter = this.yCenter + b;
        }

        public boolean isInside(int x, int y){//!!!
            return  false;
        }

        public Rect boundingBox(){//!!!
            return null;
        }

        public double getDiameter() {
            return radius * 2;
        }

        public double getArea() {
            return Math.PI * Math.pow(radius, 2);
        }

        public String toString() {
            return "[" + xCenter + ", " + yCenter + "] radius: " + radius ;
        }
    }
}
