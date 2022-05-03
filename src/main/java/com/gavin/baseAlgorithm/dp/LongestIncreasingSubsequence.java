/**
 * cordate.com gavin
 * Copyright (c) 2019-2022 All Rights Reserved
 */
package com.gavin.baseAlgorithm.dp;

/**
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 *
 * @author gavin
 * @version $Id: LongestIncreasingSubsequence.java, v 1.0 2022年04月20日 2:46 PM apple copyright $
 */
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = 0;
        for (int s : dp) {
            max = Math.max(max, s);
        }

        return max;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence main = new LongestIncreasingSubsequence();
        System.out.println(main.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
    }
}
