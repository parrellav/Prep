package com.parrella.arrays;

public class SlidingWindow {


    public static int largestSum(int[] arr, int k) {
        int sum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int tempSum = 0;
            int start = i;
            int end = i + k - 1;
            if (end < arr.length) {
                while (start <= end) {
                    tempSum += arr[start++];
                }
                if (tempSum > sum) sum = tempSum;
            }

        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {100, 200, 300, 400};
        int k = 2;
        int ans = largestSum(arr, k);
        System.out.println(ans);
        assert 700 == ans;

        ans = largestSum(new int[] {1, 4, 2, 10, 23, 3, 1, 0, 20}, 4);
        System.out.println(ans);
        assert 39 == ans;
    }
}
