package com.darya;

public class Main6 {
    public static void main(String[] args) {
        double[] nums = new double[10];
        for(int i = 0; i < nums.length; i++) nums[i] = Math.random() * 100;

        bubbleSort(nums);

        for(int i = 0; i < nums.length; i++) System.out.println(String.format("%.2f",nums[i]));
    }

    private static void bubbleSort(double[] nums) {
        double temp;

        for(int i = 0; i < nums.length; i++) {
            int min = i;
            for(int j = i; j < nums.length; j++) {
                if(nums[j] < nums[i]) min = j;
            }

            temp = nums[i];
            nums[i] = nums[min];
            nums[min] = temp;
        }
    }
}
