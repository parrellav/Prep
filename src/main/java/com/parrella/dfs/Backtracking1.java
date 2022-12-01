package com.parrella.dfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Backtracking1 {

    private static void dfs(Integer n, List<String> res, int startIndex, List<Character> path) {
        if (startIndex == n) {
            res.add(path.stream()
                    .map(e -> e.toString())
                    .collect(Collectors.joining()));
            return;
        }
        for (char letter : new char[] {'a', 'b'}) {
            path.add(letter);
            dfs(n, res, startIndex+1, path);
            path.remove(startIndex);
        }
    }

    public static List<String> letterCombination(Integer n) {
        List<String> res = new ArrayList<>();
        dfs(n, res, 0, new ArrayList<>());
        return res;
    }

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = Integer.parseInt(scanner.nextLine());
//        scanner.close();
        List<String> res = letterCombination(1);
        Collections.sort(res);
        for (String line : res) {
            System.out.println(line);
        }
    }
}
