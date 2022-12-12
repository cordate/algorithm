/**
 * cordate.com gavin
 * Copyright (c) 2019-2024 All Rights Reserved
 */

package com.gavin.baseAlgorithm.dp;

/**
 * https://leetcode.cn/problems/longest-palindromic-substring/
 * 最长回文子串问题
 * @author gavin
 * @version $Id: LongestPalindromicSubstring.java, v 1.0 2022/11/8 00:58 gavin copyright $
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i=0;i<n;i++) {
            dp[i][i] = 1;
        }
        int len = 0;
        int[] pos = new int[2];
        for (int i=n-1;i>=0;i--) {
            for (int j=i+1;j<n;j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (i+1==j) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                } else {
                    dp[i][j] = 0;
                }
                if (dp[i][j]==1 && j-i+1 > len) {
                    len = j-i+1;
                    pos[0] = i;
                    pos[1] = j;
                }
            }
        }

        return s.substring(pos[0], pos[1]+1);
    }

    /**
     * 这个是官方的解法，是通过增加步长的方式实现的
     * @param s
     * @return
     */
    public String longestPalindrome2(String s) {
        int n = s.length();
        String ans = "";
        int[][] dp = new int[n][n];

        // 这里l是步长，i是中心节点，j是左右移动游标
        for (int l = 0; l< n; l++) {
            for (int i = 0; i+l< n; i++) {
                int j = i+l;
                if (l==0) {
                    dp[i][j] = 1;
                } else if (l == 1) {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = 1;
                    }
                } else {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }

                if (dp[i][j] > 0 && (l + 1) > ans.length()) {
                    ans = s.substring(i, i+l+1);
                }
            }
        }

        return ans;
    }


    public static void main(String[] args) {
        LongestPalindromicSubstring main = new LongestPalindromicSubstring();
        System.out.println(main.longestPalindrome("babad"));
        System.out.println(main.longestPalindrome("bb"));
    }
}
