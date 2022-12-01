package com.parrella.binarySearch;

import java.util.ArrayList;
import java.util.List;

public class SquareRoot {

    public static int squareRoot(int num) {
        List<Integer> arr = new ArrayList<>();
        if (0 == num) return num;
        int i = 0;
        while(i < num) {
            arr.add(i++);
        }
        int left = 0;
        int right = arr.size() - 1;
        int root = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (num == mid * mid) {
                root = mid;
                left = right;
            }
            else if (num > mid * mid) {
                root = mid;
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        int num = 4;
        System.out.println(squareRoot(num));
    }
}
