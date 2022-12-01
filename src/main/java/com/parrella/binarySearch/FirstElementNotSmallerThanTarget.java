package com.parrella.binarySearch;

import java.util.List;

public class FirstElementNotSmallerThanTarget {

    public static int firstNotSmaller(List<Integer> arr, int target) {
        if (null == arr || arr.isEmpty()) {
            return 0;
        }
        if (arr.size() == 1 && arr.get(0) > target) {
            return 0;
        }
        int foundValue = -1;
        int left = 0;
        int right = arr.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr.get(mid) < target) { // need to continue more right
                left = mid + 1;
            }
            else if (arr.get(mid) > target) { // this could be the first element, or maybe not
                foundValue = mid;
                right = mid - 1;
            }
        }
        return foundValue;
    }

    public static void main(String[] args) {
        List<Integer> arr = List.of(1, 3, 3, 5, 8, 8, 10);
        System.out.println(firstNotSmaller(arr, 6));
    }
}
