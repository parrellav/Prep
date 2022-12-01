package com.parrella.binarySearch;

import java.util.List;

public class FindFirstOccurrence {

    public static int findFirstOccurrence(List<Integer> arr, int target) {
        int targetIndex = -1;
        int left = 0;
        int right = arr.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr.get(mid) == target) {
                targetIndex = mid;
                right = mid - 1;
            } else if (arr.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return targetIndex;
    }

    public static void main(String[] args) {
        List<Integer> arr = List.of(1, 3, 3, 3, 3, 6, 10, 10, 10, 100);
        System.out.println(findFirstOccurrence(arr, 3));
    }
}
