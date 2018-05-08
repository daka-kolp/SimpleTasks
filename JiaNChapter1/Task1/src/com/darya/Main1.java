package com.darya;

public class Main1 {

    public static void main(String[] args) {

        Main1 mo = new Main1();
        mo.fizzBuzz();
    }

    private void fizzBuzz() {
        for(int i = 1; i <= 100; i++) {
            if (i % 5 == 0 && i % 7 == 0) System.out.println("fizzbuzz");

            else if (i % 5 == 0) System.out.println("fizz");

            else if (i % 7 == 0) System.out.println("buzz");

            else System.out.println(" ");
        }
    }
}
