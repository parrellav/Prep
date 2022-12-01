package com.parrella.aggregationAndMemoization;

import java.util.Arrays;
import java.util.Map;

public class NumWaysToDecodeAMessage {

    public static Map<String, String> lookup = Map.of("1", "A", "12", "L", "23", "W");


    public static int dfs(String digits, int startIndex, int[] memo) {
        if (startIndex == digits.length()) return 1;
        if (memo[startIndex] != -1) return memo[startIndex];

        int ways = 0;
        // can't decode string with leading 0
        if (digits.charAt(startIndex) == '0') {
            return ways;
        }
        ways += dfs(digits, startIndex + 1, memo);

        if(startIndex + 2 <= digits.length() && Integer.parseInt(digits.substring(startIndex, startIndex + 2)) <= 26) {
            ways += dfs(digits, startIndex + 2, memo);
        }
        memo[startIndex] = ways;

        return ways;
    }


    public static int decodeWays(String digits) {
        int[] memo = new int[digits.length()];
        Arrays.fill(memo, -1);
        return dfs(digits, 0, memo);
    }

    public static void main(String[] args) {
        System.out.println(decodeWays("18"));
    }
}
