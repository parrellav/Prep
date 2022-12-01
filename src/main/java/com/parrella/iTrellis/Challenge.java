package com.parrella.iTrellis;

import java.util.*;

public class Challenge {


    public static String rangeCompact(final ArrayList<Integer> arr) {
        if (null == arr || arr.isEmpty()) return "";
        StringBuilder builder = new StringBuilder(""); // stringBuilder holds ranges
        List<String> results = new ArrayList<>();
        // using two pointers for a single traversal
        int slow = 0;
        int fast = 1;
        while (fast < arr.size()) {
            int slowVal = arr.get(slow);
            int fastVal = arr.get(fast);
            if ((fastVal - slowVal) > 1) {
                writeRange(builder, results, slowVal);
            }
            else {
                if (builder.length() == 0) {
                    builder.append(slowVal); // record start of range
                }
            }
            slow++;
            fast++;
        }

        // get final value
        int lastVal = arr.get(arr.size() - 1);

        writeRange(builder, results, lastVal);

        return String.join(",", results);
    }

    private static void writeRange(StringBuilder builder, List<String> results, int slowVal) {
        if (builder.length() > 0) { // if inside range
            if (slowVal - Integer.parseInt(builder.toString()) == 1) { // is the next value 1 more?
                results.add(builder.toString());
                results.add(Integer.toString(slowVal));
            }
            else { // add range with dash
                results.add(builder.append("-").append(slowVal).toString());
            }
            builder.setLength(0);
        }
        else {
            results.add(Integer.toString(slowVal));
        }
    }

    public static void main(String[] args) {
        String answer = rangeCompact(new ArrayList<>(Arrays.asList(-6, -3, -2, -1, 0, 1, 3, 4, 5, 7, 8, 9, 10, 11, 14, 15, 17, 18, 19, 20)));
        System.out.println(answer);
    }
}

