package com.parrella.mergeIntervals;

import java.util.*;

public class MergeIntervals {

    public static int[][] merge(int[][] intervals) {
        List<List<Integer>> merged = new ArrayList<>();

        int arrLength = intervals[intervals.length - 1][1];
        int[] myArray = new int[arrLength + 2];
        Arrays.fill(myArray, 0);

        for (int row = 0; row < intervals.length; row++) {
            int start = intervals[row][0];
            int end = intervals[row][1];
            while (start <= end) {
                myArray[start] = 1;
                start++;
            }
        }

        boolean foundRange = false;
        int index = 0;
        List<Integer> aList = new ArrayList<>();
        while (index < myArray.length) {
            if (1 == myArray[index]) {
                if (foundRange == false) {
                    aList.add(index);
                    foundRange = true;
                }
            } else {
                if (foundRange == true) {
                    aList.add(index - 1);
                    merged.add(new ArrayList<>(aList));
                    aList.clear();
                    foundRange = false;
                }
            }
            index++;
        }

        return merged.stream()
                .map(l -> l.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);
    }

    public static void main(String[] args)

    {
        int[][] intervals = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
        int[][] expected = { { 1, 6 }, { 8, 10 }, { 15, 18 } };
        int[][] actual = merge(intervals);
        System.out.println(Arrays.deepToString(actual));

    }

}
