package com.parrella.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class GenerateAllValidParens {

    private static char[] parens = new char[] { '(', ')'};

    public static boolean valid(String parensToCheck) {
        Stack<Character> characterStack = new Stack<>();
        for (char aChar : parensToCheck.toCharArray()) {
            if ('(' == aChar) characterStack.push(aChar);
            else {
                if (characterStack.isEmpty() || characterStack.peek() != '(') {
                    return false;
                }
                characterStack.pop();
            }
        }
        return characterStack.isEmpty();
    }

    public static void dfs(int n, StringBuilder path, int startIndex, List<String> ans) {
        if(n == startIndex) {
            boolean isValid = valid(path.toString());
            if (isValid) ans.add(path.toString());
            return;
        }
        for (char aChar : parens) {
            path.append(aChar);
            dfs(n, path, startIndex + 1, ans);
            path.deleteCharAt(path.length() - 1);
        }

    }

    public static List<String> generateParentheses(int n) {
        List<String> ans = new ArrayList<>();
        dfs(n * 2, new StringBuilder(""), 0, ans);
        return ans;
    }

    public static void main(String[] args) {

        System.out.println(valid("()()")); //true
        System.out.println(valid("(())")); //true
        System.out.println(valid("((()")); //false

        List<String> actual = generateParentheses(3);
        System.out.println(Arrays.toString(actual.toArray()));
    }
}
