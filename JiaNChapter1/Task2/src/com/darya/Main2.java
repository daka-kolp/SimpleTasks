package com.darya;

public class Main2 {

    public static void main(String[] args){
        new Main2().fibonacci();
    }

    private void fibonacci() {
        int a0 = 1;
        int a1 = 1;
        int a2;

        System.out.println(1 + ". " + a0);
        System.out.println(2 + ". " + a1);

        for(int i = 3; i <= 20; i++) {
            a2 = a0 + a1;
            a0 = a1;
            a1 = a2;
            System.out.println(i + ". " + a2);
        }
    }
}
