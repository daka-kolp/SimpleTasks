package com.darya;

public class Randomizer {
    static final int m = 233280;
    static final int a = 9201;
    static final int c = 49297;

    int seed = 1;

    public Randomizer(int seed){
        this.seed = seed;
    }

    public float randomFloat() {
        seed = (seed * a + c);
        float tmp = Math.abs((float)seed/(float)m);
        return tmp;
    }
    public int randomInt(int max) {
        int tmp = Math.round(max * randomFloat());
        return tmp;
    }

    public static class Test{
        public static void main(String[] args) {
            Randomizer r = new Randomizer((int) new java.util.Date().getTime());
            for(int i = 0; i < 10; i++){
                System.out.println(r.randomFloat());
            }

            for(int i = 0; i < 10; i++){
                System.out.println(r.randomInt(100));
            }
        }
    }
}
