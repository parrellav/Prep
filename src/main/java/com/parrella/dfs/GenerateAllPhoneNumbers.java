package com.parrella.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class GenerateAllPhoneNumbers {

    private static final Map<Character, char[]> KEYBOARD = Map.of(
            '2', "abc".toCharArray(),
            '3', "def".toCharArray(),
            '4', "ghi".toCharArray(),
            '5', "jkl".toCharArray(),
            '6', "mno".toCharArray(),
            '7', "pqrs".toCharArray(),
            '8', "tuv".toCharArray(),
            '9', "wxyz".toCharArray()
    );

    public static void dfs(String digits, StringBuilder path, int startIndex, List<String> res) {
        if (startIndex == digits.length()) {
            res.add(path.toString());
            return;
        }
        char currentChar = digits.charAt(startIndex);
        char[] letters = KEYBOARD.get(currentChar);
        for (char aChar : letters) {
            path.append(aChar);
            dfs(digits, path, startIndex + 1, res);
            path.deleteCharAt(path.length() - 1);
        }
    }

    public static List<String> letterCombinationsOfPhoneNumber(String digits) {
        List<String> res = new ArrayList<>();
        dfs(digits, new StringBuilder(""), 0, res);
        return res;
    }

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String digits = scanner.nextLine();
//        scanner.close();
        List<String> res = letterCombinationsOfPhoneNumber("56");
        System.out.println(String.join(" ", res));
    }
}
