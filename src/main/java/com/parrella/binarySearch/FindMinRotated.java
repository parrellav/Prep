package com.parrella.binarySearch;

import java.util.List;

public class FindMinRotated {

    public static int findMinRotated(List<Integer> arr) {
        int left = 0;
        int right = arr.size() - 1;
        int boundaryIndex = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // if <= last element, then belongs to lower half
            if (arr.get(mid) <= arr.get(arr.size() - 1)) {
                boundaryIndex = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return boundaryIndex;
    }

    public static void main(String[] args) {
        List<Integer> arr = List.of(30, 40, 50, 10, 20);
        System.out.println(findMinRotated(arr));
    }
}
