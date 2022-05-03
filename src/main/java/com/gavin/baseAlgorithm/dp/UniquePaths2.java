/**
 * cordate.com gavin
 * Copyright (c) 2019-2022 All Rights Reserved
 */
package com.gavin.baseAlgorithm.dp;

/**
 * https://leetcode-cn.com/problems/unique-paths-ii/
 * 这题也可以通过递归回溯的方法进行解决
 *
 * @author gavin
 * @version $Id: UniquePaths.java, v 1.0 2022年04月20日 12:29 PM apple copyright $
 */
public class UniquePaths2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 0)
                dp[i][0] = dp[i-1][0];
            else
                dp[i][0] = 0;
        }

        for (int i = 1; i < n; i++) {
            if (obstacleGrid[0][i] == 0)
                dp[0][i] = dp[0][i-1];
            else
                dp[0][i] = 0;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j]==1)
                    dp[i][j] = 0;
                else
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        UniquePaths2 main = new UniquePaths2();
        System.out.println(main.uniquePathsWithObstacles(new int[][]{{0,0,0},{0,1,0},{0,0,0}}));
    }
}
