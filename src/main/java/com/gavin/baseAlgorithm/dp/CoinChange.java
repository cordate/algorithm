/**
 * cordate.com gavin
 * Copyright (c) 2019-2022 All Rights Reserved
 */
package com.gavin.baseAlgorithm.dp;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/coin-change/
 * 还有一个递归回溯的解法
 * @author gavin
 * @version $Id: CoinChange.java, v 1.0 2022年05月01日 9:19 AM apple copyright $
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        for (int i = 0; i <= amount; i++) {
            for (int coin : coins) {
                int index = i - coin;
                if (index >= 0) {
                    dp[i] = Math.min(dp[i], dp[index] + 1);
                }
            }
        }

        if (dp[amount] == amount + 1) {
            return -1;
        }

        return dp[amount];
    }

    public static void main(String[] args) {
        CoinChange2 main = new CoinChange2();
        System.out.println(main.coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(main.coinChange(new int[]{2}, 3));
        System.out.println(main.coinChange(new int[]{1}, 0));
    }
}

class CoinChange2 {
    public int coinChange(int[] coins, int amount) {
        // 具体的写法
        if (amount < 0) {
            return -1;
        }

        return coinChange(coins, amount, 0);
    }

    public int coinChange(int[] coins, int rem, int result) {
        if (rem == 0) {
            return result;
        }

        if (rem < 0) {
            return -1;
        }

        int ret = Integer.MAX_VALUE;
        for (int coin : coins) {
            int tmp = coinChange(coins, rem - coin, result+1);
            if (tmp == -1) {
                continue;
            }
            ret = Math.min(ret, tmp);
        }

        if (ret == Integer.MAX_VALUE) {
            return -1;
        }

        return ret;
    }
}
