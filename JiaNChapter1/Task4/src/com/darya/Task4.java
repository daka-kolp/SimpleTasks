package com.darya;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;

public class Task4 {

//----------------------------------------------------------------------------------------------------------------------

    //the array keeps factorials from 0! to 20!
    static long[] table = new long[20];

    //static initializer for first array's element
    static {
        table[0] = 1;
    }

    //to remember last factorial's number
    static int last = 0;

    private static long factorialCashed(int factorialNumber) throws IllegalArgumentException {
        if (factorialNumber >= table.length) throw new IllegalArgumentException
                ("stack over flow: the value should be <= 20");

        if (factorialNumber < 0) throw new IllegalArgumentException("the value should be >= 0");

        while(last < factorialNumber) {
            table[last+1] = table[last] * (last + 1);
            last++;
        }
        return table[factorialNumber];
    }

//----------------------------------------------------------------------------------------------------------------------

    private static long factorialRecursive(long factorialNumber) throws IllegalArgumentException {
        if (factorialNumber >= table.length) throw new IllegalArgumentException
                ("stack over flow: the value should be <= 20");

        if (factorialNumber < 0) throw new IllegalArgumentException("the value should be >= 0");

        if (factorialNumber == 1)
            return 1;

        else return factorialRecursive(factorialNumber - 1) * factorialNumber;
    }

//----------------------------------------------------------------------------------------------------------------------

    // create cash
    private static ArrayList<BigInteger> array = new ArrayList<BigInteger>();

    //0! == 1
    static {
        array.add(BigInteger.valueOf(1));
    }

    //synchronized because it could use in multithreading
    private static synchronized BigInteger factorialBigInteger(int factorialNumber) {
        if (factorialNumber < 0) throw new IllegalArgumentException("the value should be >= 0");

        for(int i = array.size(); i <= factorialNumber; i++) {
            BigInteger lastFact = (BigInteger)array.get(i-1);
            BigInteger nextFact = lastFact.multiply(BigInteger.valueOf(i));
            array.add(nextFact);
        }
        return (BigInteger) array.get(factorialNumber);
    }

//----------------------------------------------------------------------------------------------------------------------

    private static void factorialException() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String valueStr = reader.readLine();
            if (valueStr.equals("quit") || valueStr == null) break;
            try {
                int value = Integer.parseInt(valueStr);
                System.out.println(value + "! = " + factorialBigInteger(value));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void main(String[] args) throws IOException {
//        System.out.println(factorialCashed(15));
//        System.out.println(factorialRecursive(15));
//        for(int i = 1; i < 50; i++) System.out.println(i + "! = " + factorialBigInteger(i));
        factorialException();
    }
}
