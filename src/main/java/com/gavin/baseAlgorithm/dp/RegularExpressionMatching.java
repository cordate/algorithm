/**
 * cordate.com gavin
 * Copyright (c) 2019-2024 All Rights Reserved
 */

package com.gavin.baseAlgorithm.dp;

/**
 * https://leetcode.cn/problems/regular-expression-matching/
 * 正则表达式匹配
 * 可以进行递归回溯法
 * @author gavin
 * @version $Id: RegularExpressionMatching.java, v 1.0 2022/11/8 01:07 gavin copyright $
 */
public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        int[][] dp = new int[p.length()][s.length()];
        for (int i=0;i<p.length();i++) {
            for (int j=0;j<s.length();j++){
                if (p.charAt(i)=='*') {
                    if ((j>0&&dp[i][j-1]==1) || (i>0 && dp[i-1][j]==1)) {
                        dp[i][j]=1;
                    } else if(i>=2) {
                        dp[i][j] = dp[i-2][j];
                    } else {
                        dp[i][j] = 1;
                    }
                } else if (i>0 && j>0 && dp[i-1][j-1]==1 && p.charAt(i)==s.charAt(j)) {
                    dp[i][j]=1;
                } else if(i==0){
                    if (p.charAt(i)=='.' || p.charAt(i)==s.charAt(j)) {
                        dp[i][j]=1;
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return dp[p.length()-1][s.length()-1]==1;
    }

    /**
     * 官网没有的递归回溯法，是我以前写的算法
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch2(String s, String p) {
        return isMatch(s, p, 0, 0);
    }

    private boolean isMatch(String s, String p, int i, int j) {
        if (j == p.length()) return i == s.length();
        if (j == p.length() - 1 || p.charAt(j + 1) != '*') {
            return i != s.length() && (p.charAt(j) == '.' || p.charAt(j) == s.charAt(i))
                    ? isMatch(s, p, i + 1, j + 1) : false;
        } else {
            do {
                if (isMatch(s, p, i, j + 2)) {
                    return true;
                }
                i++;
            } while (i <= s.length() && (p.charAt(j) == '.' || s.charAt(i - 1) == p.charAt(j)));
            return false;
        }
    }

    public static void main(String[] args) {
        RegularExpressionMatching main = new RegularExpressionMatching();
        System.out.println(main.isMatch("aa", "a*")); // true
        System.out.println(main.isMatch("mississippi", "mis*is*p*.")); // false
        System.out.println(main.isMatch("aab", "c*a*b")); // true
        System.out.println(main.isMatch("aa", "a")); // false
    }
}
