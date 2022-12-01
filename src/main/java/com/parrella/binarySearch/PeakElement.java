package com.parrella.binarySearch;

import java.util.List;

public class PeakElement {

    public static int peakOfMountainArray(List<Integer> arr) {
        int alen = arr.size();
        int left = 0;
        int right = alen - 1;
        int boundaryIndex = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid == alen-1 || arr.get(mid) > arr.get(mid + 1)) {
                boundaryIndex = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return boundaryIndex;
    }

    public static void main(String[] args) {
        List<Integer> arr = List.of(0, 1, 2, 12, 22, 32, 42, 52, 62, 72, 82, 92, 102, 112, 122, 132, 133, 132, 111, 0);
        System.out.println(peakOfMountainArray(arr));
    }
}
