/**
 * cordate.com gavin
 * Copyright (c) 2019-2022 All Rights Reserved
 */
package com.gavin.baseAlgorithm.dp;

/**
 * https://leetcode-cn.com/problems/edit-distance/
 * 两个字符串改变成一样的需要多少操作
 * @author gavin
 * @version $Id: EditDistance.java, v 1.0 2022年04月30日 10:07 AM apple copyright $
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        if (m*n==0) return n+m;
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= n; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= m; i++) {
            char c1 = word1.charAt(i-1);
            for (int j = 1; j <= n; j++) {
                char c2 = word2.charAt(j-1);
                dp[i][j] = Math.min(dp[i][j-1]+1, dp[i-1][j]+1);
                if (c1 == c2) {
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1]);
                } else {
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1] + 1);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        EditDistance main = new EditDistance();
        System.out.println(main.minDistance("horse", "ros"));
    }
}
