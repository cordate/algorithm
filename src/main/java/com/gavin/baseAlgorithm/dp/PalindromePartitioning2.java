/**
 * cordate.com gavin
 * Copyright (c) 2019-2022 All Rights Reserved
 */
package com.gavin.baseAlgorithm.dp;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/palindrome-partitioning-ii/
 * 唯一一个忘记解法的题目，其实题目也是比较简单的写法，要好好学习一下
 * 好好学习一下，这类题目就不怕了
 * @author gavin
 * @version $Id: PalindromePartitioning2.java, v 1.0 2022年04月20日 2:13 PM apple copyright $
 */
public class PalindromePartitioning2 {
    public int minCut(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            Arrays.fill(dp[i], 1);
        }
        // 这种写法类似于中心化的扩展
        for (int i = len-1; i >= 0; i--) {
            // 这块是从当前节点向后找
            for (int j = i+1; j < len; j++) {
                dp[i][j] = (dp[i+1][j-1]==1 && s.charAt(i) == s.charAt(j)) ? 1 : 0;
            }
        }

        int ret[] = new int[len];
        ret[0] = 0;
        for (int i=1;i<s.length();i++) {
            ret[i] = ret[i-1] + 1;
            for (int j = 0; j < i; j++) {
                if (dp[j][i]==1) {
                    ret[i] = Math.min(j==0 ? 0 : ret[j-1] + 1, ret[i]);
                }
            }
        }

        return ret[len-1];
    }

    public static void main(String[] args) {
        PalindromePartitioning2 main = new PalindromePartitioning2();
        System.out.println(main.minCut("aabhfs"));
    }
}
