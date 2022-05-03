/**
 * cordate.com gavin
 * Copyright (c) 2019-2022 All Rights Reserved
 */
package com.gavin.baseAlgorithm.dp;

/**
 * https://leetcode-cn.com/problems/climbing-stairs/
 * 这题的其他解法有一定的数学功底才行
 * @author gavin
 * @version $Id: ClimbingStairs.java, v 1.0 2022年04月20日 12:43 PM apple copyright $
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        int[] dp = new int[n];
        dp[1] = 2;
        dp[0] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i-1] = dp[i-2] + dp[i-3];
        }

        return dp[n-1];
    }

    public static void main(String[] args) {
        ClimbingStairs main = new ClimbingStairs();
        System.out.println(main.climbStairs(7));
    }
}
