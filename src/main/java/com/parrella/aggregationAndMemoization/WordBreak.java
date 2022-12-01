package com.parrella.aggregationAndMemoization;

import java.util.List;

public class WordBreak {

    private static boolean dfs(int startIndex, Boolean[] memo, String s, List<String> words) {
        if (startIndex == s.length()) return true;

        if (memo[startIndex] != null) return memo[startIndex];

        boolean ans = false;
        for (String word : words) {
            if (s.substring(startIndex).startsWith(word)) {
                ans = ans || dfs(startIndex + word.length(), memo, s, words);
            }
        }
        memo[startIndex] = ans;
        return ans;
    }

    public static boolean wordBreak(String s, List<String> words) {
        return dfs(0, new Boolean[s.length()], s, words);
    }

    public static void main(String[] args) {
        String target
                = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        List<String> words = List.of("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa");
        boolean res = wordBreak(target, words);
        System.out.println(res);
    }
}
