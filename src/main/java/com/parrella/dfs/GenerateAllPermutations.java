package com.parrella.dfs;

import java.util.Collections;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class GenerateAllPermutations {

    public static void dfs(int n, StringBuilder path, int startIndex, String letters, Set<String> ans) {
        if(n == startIndex) {
            String perm = path.toString();
            ans.add(perm);
            ans.add(new StringBuilder(perm).reverse().toString());
            return;
        }
        for (char aChar : letters.toCharArray()) {
            dfs(n, path.append(aChar), startIndex+1, letters.replace(Character.toString(aChar), ""), ans);
            path.deleteCharAt(path.length() - 1);
        }
    }

    public static List<String> permutations(String letters) {
        Set<String> ans = new HashSet<>();
        dfs(letters.length(), new StringBuilder(""), 0, letters, ans);
        return ans.stream().collect(Collectors.toList());
    }

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String letters = scanner.nextLine();
//        scanner.close();
        List<String> res = permutations("abcd");
        Collections.sort(res);
        for (String line : res) {
            System.out.println(line);
        }
    }
}
