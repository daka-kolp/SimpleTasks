package com.darya;

public class Search extends Sorter{

    public static int search(Object[] arr, Object obj, Comparer c) {
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (c.compare(arr[i], obj) > 0) return i;
        }
        return index;
    }

    public static class Test {

        public static int sign(double x) {
            if(x != 0) return -1;

            else return 1;
        }

        public static void main(String[] args) {
            Integer[] a = new Integer[20];
            for(int i = 0; i < a.length; i++)
                a[i] = (int) (Math.random()*10);

           Integer object = 5;

            System.out.print("Is it found? ");
            System.out.println(Search.search(a, object, new Comparer() {
                @Override
                public int compare(Object a, Object b) {
                    Integer i = (Integer)a;
                    Integer j = (Integer)b;
                    return sign(i - j);
                }
            }));
            System.out.println("\nThe array: ");
            for(int i = 0; i < a.length; i++)
                System.out.println(i + ". " + a[i]);


        }
    }
}
