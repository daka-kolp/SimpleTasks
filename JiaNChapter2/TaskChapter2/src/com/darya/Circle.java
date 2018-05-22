package com.darya;

public class Circle {
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

        public boolean isInside(int x, int y){
            double r = Math.sqrt(Math.pow(x - this.xCenter, 2) + Math.pow(y - this.yCenter, 2));
            return  r <= this.radius;
        }

        public Rect boundingBox(){
            double x1 = this.xCenter - this.radius;
            double y1 = this.yCenter - this.radius;
            double x2 = this.xCenter + this.radius;
            double y2 = this.yCenter + this.radius;
            return new Rect((int)x1, (int)y1, (int)x2, (int)y2);
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

