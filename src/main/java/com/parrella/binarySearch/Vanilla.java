package com.parrella.binarySearch;

import java.util.List;

public class Vanilla {

    public static int binarySearch(List<Integer> arr, int target) {
        if (arr.size() == 0) {
            return -1;
        }
        int left = 0;
        int right = arr.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (target == arr.get(mid)) {
                return mid;
            }
            if (target < arr.get(mid)) {
                right = mid -1;
            }
            else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        List<Integer> input = List.of(2, 8, 89, 120, 1000);
        int target = 120;
        System.out.println(binarySearch(input, target));

    }
}
