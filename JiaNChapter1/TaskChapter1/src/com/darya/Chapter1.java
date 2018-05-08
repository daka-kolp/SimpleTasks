package com.darya;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Chapter1 {
    public static void main(String[] args) throws IOException {
        t5();
    }

    private static void t5() throws IOException {
        double[] nums = new double[100];
        for(int i = 0; i < nums.length; i++) nums[i] = Math.random() * 100;

        bubbleSort(nums);

        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        String strNum = reader.readLine();
        double num = Double.parseDouble(strNum);

        double min = nums[0];
        double max = nums[nums.length-1];
        int index = 0;
        while (nums[index] < num) {
            if (nums[index] >= num) break;
            min = nums[index];
            index++;
        }
        index = nums.length-1;
        while (nums[index] > num) {
            if (nums[index] <= num) break;
            max = nums[index];
            index--;
        }
        System.out.println(String.format("%,3.1f < %,3.1f < %,3.1f",min, num, max));
    }


    private static void bubbleSort(double[] nums) {

        double temp;

        for(int i = 0; i < nums.length-1; ++i) {
            for(int j = 0; j < nums.length-1; ++j) {
                if(nums[j+1] < nums[j]) {
                    temp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }

    private static void t4() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        while(true) {
            String str = reader.readLine();
            if(str.contains("quit")) {
                System.out.println("quit");
                break;
            }
            builder.append(str);
            System.out.println(builder.reverse());
            builder.delete(0, builder.length());
        }
    }

    private static void t3(String[] args) {
        if(args.length != 3) System.out.println("Enter 3 args.");
         try{
             System.out.println(args[0].substring(Integer.parseInt(args[1]), Integer.parseInt(args[2])));
         } catch (Exception e) {
             e.getStackTrace();
         }
    }

    private static void t2() {
        int a0 = 1;
        int a1 = 1;
        int a2 = 1;
        int a3;

        System.out.println(1 + ". " + a0);
        System.out.println(2 + ". " + a1);
        System.out.println(3 + ". " + a2);

        for (int i = 4; i <= 20; i++) {
            a3 = a0 + a1 + a2;
            a0 = a1;
            a1 = a2;
            a2 = a3;
            System.out.println(i + ". " + a3);
        }
    }

    private static void t1() {
        for (int i = 1; i <= 15; i++) {
            System.out.println(i);
        }

        for (int i = 15; i > 0; i = i - 2) {
            System.out.println(i);
        }
    }
}
