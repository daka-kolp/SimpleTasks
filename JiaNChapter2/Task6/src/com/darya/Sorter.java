package com.darya;
import java.text.CollationKey;
import java.text.Collator;
import java.util.Locale;

public class Sorter {
    public static interface Comparer {
        public int compare(Object a, Object b);
    }

    public static interface Comparable {
        public int compareTo(Object other);
    }

    private static Comparer ascii_compare = new Comparer() {
        @Override
        public int compare(Object a, Object b) {
            return ((String)a).compareTo((String)b);
        }
    };

    private static Comparer comparable_comparer = new Comparer() {
        @Override
        public int compare(Object a, Object b) {
            return ((Comparable)a).compareTo(b);
        }
    };

    public static void sort(Object[] a, Object[] b, int from, int to, boolean up, Comparer c){
        if ((a == null) || (a.length < 2)) return;

        int i = from;
        int j = to;

        Object center = a[(from + to)/2];

        do {
            if (up) { // to up
                while ((i < to) && (c.compare(center, a[i]) > 0)) i++;
                while ((j > from) && (c.compare(center, a[j]) < 0)) j--;
            } else { // to down
                while ((i < to) && (c.compare(center, a[i]) < 0)) i++;
                while ((j > from) && (c.compare(center, a[j]) > 0)) j--;
            }
            if (i < j) {
                Object tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
                if (b != null) {
                    tmp = b[i];
                    b[i] = b[j];
                    b[j] = tmp;
                }
            }

            if (i <= j) {
                i++;
                j--;
            }
        } while (i <= j);

        if(from < j) sort(a, b, from, j, up, c);

        if(to > i) sort(a, b, i, to, up, c);

    }

    public static void sortAscii(String[] a, int from, int to, boolean up) {
        sort(a, null, from, to, up, ascii_compare);
    }

    public static void sortAscii(String[] a) {
        sort(a, null, 0, a.length-1,true, ascii_compare);
    }

    public static void sortAsciiIgnoreCase(String[] a, int from, int to, boolean up) {
        if((a == null) || (a.length < 2)) return;

        String[] b = new String[a.length];
        for(int i = 0; i < a.length; i++) {
            b[i] = a[i].toLowerCase();
            sort(b, a, from, to, up, ascii_compare);
        }
    }

    public static void sortAsciiIgnoreCase(String[] a) {
        sortAsciiIgnoreCase(a, 0, a.length-1, true);
    }

    public static void sort(String[] a){
        sort(a,0,a.length-1, true, false, null);
    }

    public static void sort(String[] a, int from, int to, boolean up, boolean ignorecase, Locale locale) {
        if((a == null) || (a.length < 2)) return;

        Collator c;
        if(locale == null) c = Collator.getInstance();
        else c = Collator.getInstance(locale);

        if (ignorecase) c.setStrength(Collator.SECONDARY);

        CollationKey[] b = new CollationKey[a.length];
        for(int i = 0; i < a.length; i++) b[i] = c.getCollationKey(a[i]);

        Comparer comp = new Comparer() {
            @Override
            public int compare(Object a, Object b) {
                return ((CollationKey)a).compareTo((CollationKey)b);
            }
        };

        sort(b, a, from, to, up, comp);
    }

    public static void sort(Comparable[] a, int from, int to, boolean up){
        sort(a, null, from, to, up, comparable_comparer);
    }

    public static void sort(Comparable[] a, Object[] b, int from, int to, boolean up) {
        sort(a, b, from, to, up, comparable_comparer);
    }

    public static void sort(Comparable[] a){
        sort(a, null, 0, a.length-1, true);
    }


    public static void sort(Object[] a, Comparer c) {
        sort(a, null, 0, a.length-1, true, c);
    }

    public static void sort(Object[] a, int from, int to, boolean up, Comparer c){
        sort(a, null, from, to, up, c);
    }

    public static class Test {

        static class SortableComplexNumber extends ComplexNumber implements Sorter.Comparable{

            public SortableComplexNumber(double real, double imaginary) {
                super(real, imaginary);
            }

            @Override
            public int compareTo(Object other) {
                return sign(this.magnitude() - ((ComplexNumber)other).magnitude());
            }
        }

        public static int sign(double x) {
            if(x > 0) return 1;
            else if(x < 0) return -1;
            else return 0;
        }

        public static void main(String[] args) {
            SortableComplexNumber[] a = new SortableComplexNumber[5];
            for(int i = 0; i < a.length; i++)
                a[i] = new SortableComplexNumber(Math.random()*10, Math.random()*10);


            System.out.println("Sorted by abs:");
            Sorter.sort(a);
            for(int i = 0; i < a.length; i++)
                System.out.println(a[i]);


            System.out.println("Sorted by sum:");
            Sorter.sort(a, new Comparer() {
                @Override
                public int compare(Object a, Object b) {
                    ComplexNumber i = (ComplexNumber)a;
                    ComplexNumber j = (ComplexNumber)b;
                    return sign((i.real() + i.imaginary()) - (j.real() + j.imaginary()));
                }
            });
            for(int i = 0; i < a.length; i++)
                System.out.println(a[i]);

            System.out.println("Sorted by sum (down):");
            Sorter.sort(a, 0,a.length-1, false, new Comparer() {
                @Override
                public int compare(Object a, Object b) {
                    ComplexNumber i = (ComplexNumber)a;
                    ComplexNumber j = (ComplexNumber)b;
                    double result = i.real() - j.real();
                    if(result == 0) result = i.imaginary() - j.imaginary();
                    return sign(result);
                }
            });
            for(int i = 0; i < a.length; i++)
                System.out.println(a[i]);
        }
    }
}
