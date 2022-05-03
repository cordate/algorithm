/**
 * cordate.com gavin
 * Copyright (c) 2019-2022 All Rights Reserved
 */
package com.gavin.baseAlgorithm.dp;

import java.text.ParseException;

/**
 * https://leetcode-cn.com/problems/longest-common-subsequence/
 * 这题我也想不出好的答案，需要重新设计考虑
 * 这题也可以考虑加哨兵机制，防止过多的if语句
 *
 * @author gavin
 * @version $Id: LongestCommonSubsequence.java, v 1.0 2022年04月21日 1:56 AM apple copyright $
 */
public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        int ret = 0;
        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    if (i > 0 && j > 0) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = 1;
                    }
                } else {
                    if (i > 0 && j > 0) {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    } else if (i > 0) {
                        dp[i][j] = dp[i-1][j];
                    } else if (j > 0) {
                        dp[i][j] = dp[i][j-1];
                    } else {
                        dp[i][j] = 0;
                    }
                }
            }
        }

        return dp[text1.length()-1][text2.length()-1];
    }

    public static void main(String[] args) throws ParseException {
        LongestCommonSubsequence main = new LongestCommonSubsequence();
        System.out.println(main.longestCommonSubsequence("abcde", "ace"));
    }
}
