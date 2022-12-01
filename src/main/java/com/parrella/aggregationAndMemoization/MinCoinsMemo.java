package com.parrella.aggregationAndMemoization;

import java.util.Arrays;
import java.util.List;

public class MinCoinsMemo {

    public static int minCoins(List<Integer> coins, int amount, int sum, int[] memo) {
        if (sum == amount) {
            return 0;
        }
        if (sum > amount) {
            return Integer.MAX_VALUE;
        }
        if (memo[sum] != -1) {
            return memo[sum];
        }
        int ans = Integer.MAX_VALUE;
        for (int coin : coins) {
            int result = minCoins(coins, amount, sum + coin, memo);
            if (result == Integer.MAX_VALUE) {
                continue;
            }
            ans = Math.min(ans, result + 1);
        }
        return memo[sum] = ans;
    }

    public static int coinChange(List<Integer> coins, int amount) {
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, -1);
        int result = minCoins(coins, amount, 0, memo);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public static void main(String[] args) {
        System.out.println(coinChange(List.of(100, 50, 20), 40));
    }
}
