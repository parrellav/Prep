package com.parrella.binarySearch;

public class FindFirstTrue {

    public static int findFirstTrue(boolean[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int boundaryIndex = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid]) {
                boundaryIndex = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return boundaryIndex;
    }

    public static void main(String[] args) {
        boolean[] arr = new boolean[] {false, false, true, true, true};
        System.out.println(findFirstTrue(arr));
    }
}
