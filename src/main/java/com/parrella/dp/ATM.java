package com.parrella.dp;

import java.util.*;

public class ATM {


    public static int dfs(List<Integer> denoms, int amount, int sum, int index, ArrayList<Integer> res) {
        if (sum == amount) {
            return 0;
        }
        if (sum > amount || index == denoms.size()) {
            return Integer.MAX_VALUE;
        }
        Integer bill = denoms.get(index);
        res.set(index, res.get(index) + 1);
        int sumWth = dfs(denoms, amount, sum + bill, index, res);
        int sumWithout = Integer.MAX_VALUE;
        if (sumWth == Integer.MAX_VALUE) {
            res.set(index, res.get(index) - 1);
            sumWithout = dfs(denoms, amount, sum, index + 1, res);

        }
        return Math.min(sumWth, sumWithout);
    }

    public static ArrayList<Integer> withdraw(int amount) {
        List<Integer> denoms = List.of(100, 50, 20);
        Integer[] arr = new Integer[denoms.size()];
        Arrays.fill(arr, 0);
        ArrayList<Integer> ans = new ArrayList<>(Arrays.asList(arr));
        dfs(denoms, amount, 0, 0, ans);
        return ans;

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(withdraw(60).toArray()));
    }
}
