package com.parrella.aggregationAndMemoization;

import java.util.Arrays;
import java.util.List;

public class MinWaysToMakeChange {

    public static int dfs(List<Integer> coins, int amount, int sum) {
        if (sum == amount) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        if (sum > amount) return ans;
        for (int coin : coins) {
            int result = dfs(coins, amount, sum + coin);
            if (Integer.MAX_VALUE == result) {
                continue;
            }
            ans = Math.min(ans, result + 1);
        }

        return ans;

    }

    public static int coinChange(List<Integer> coins, int amount) {
        // WRITE YOUR BRILLIANT CODE HERE
        return dfs(coins, amount, 0);
    }



    public static void main(String[] args) {
        System.out.println(coinChange(List.of(1,2,5), 11));
    }
}
