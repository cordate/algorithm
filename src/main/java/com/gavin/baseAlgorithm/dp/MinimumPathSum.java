/**
 * cordate.com gavin
 * Copyright (c) 2019-2022 All Rights Reserved
 */
package com.gavin.baseAlgorithm.dp;

/**
 * https://leetcode-cn.com/problems/minimum-path-sum/
 * 这题另外的解题方法是递归回溯，有点像dfs
 *
 * @author gavin
 * @version $Id: MinimumPathSum.java, v 1.0 2022年04月20日 9:14 AM apple copyright $
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < grid.length; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        for (int i = 1; i < grid[0].length; i++) {
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
            }
        }

        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        MinimumPathSum main = new MinimumPathSum();
        System.out.println(main.minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}}));
    }
}
