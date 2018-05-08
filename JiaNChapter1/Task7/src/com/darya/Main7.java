package com.darya;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main7 {
    public static void main(String[] args) {

        sieveOfEratosthenes();
    }


    private static void sieveOfEratosthenes() {
       int max = 100;
       try {
           BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
           String strMax = reader.readLine();
           max = Integer.parseInt(strMax);
       } catch (Exception e) {
           e.getStackTrace();
       }

       boolean[] isPrime = new boolean[max+1];

       for(int i = 0; i <= max; i++) isPrime[i] = true;

       isPrime[0] = isPrime[1] = false;

       for(int i = 2; i < max+1; ++i) {
            if(isPrime[i]) {
                for (int j = 2; i*j < max+1; ++j) {
                    isPrime[i*j] = false;
                }
            }
        }

        int largest;
        for(largest = max; !isPrime[largest]; largest--);

        System.out.println(largest);

    }
}
