package com.darya;

public class Test {
    public static void main(String[] args) {
        t1();
        System.out.println(new Address("Darya", "Kolpakova",
                "Svobody", 161, 103, "Kiev", "Kievskaya", 123456));
    }

    public static void t1 () {
        Circle circle = new Circle(13);
        System.out.println(circle.isInside(45, 20));
        Rect rect = circle.boundingBox();
        System.out.println(rect);

        Circle c1 = new Circle(4, 7, 15);
        System.out.println(c1.boundingBox());
        System.out.println(c1.getArea());
        System.out.println(c1.getDiameter());

        Circle c2 = new Circle(c1);
        System.out.println(c2);
        System.out.println(c2.isInside(1, 1));
    }
}


