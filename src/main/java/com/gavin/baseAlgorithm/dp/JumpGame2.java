/**
 * cordate.com gavin
 * Copyright (c) 2019-2022 All Rights Reserved
 */
package com.gavin.baseAlgorithm.dp;

/**
 * https://leetcode-cn.com/problems/jump-game-ii/
 * 这题可以使用贪心算法来进行处理
 * @author gavin
 * @version $Id: JumpGame2.java, v 1.0 2022年04月20日 1:52 PM apple copyright $
 */
public class JumpGame2 {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            while (n > 0) {
                if (i+n < nums.length) {
                    if (dp[i+n] == 0) {
                        dp[i+n] = dp[i] + 1;
                    } else {
                        dp[i+n] = Math.min(dp[i] + 1, dp[i+n]);
                    }
                }
                n--;
            }
        }

        return dp[nums.length-1];
    }

    public static void main(String[] args) {
        JumpGame2 main = new JumpGame2();
        System.out.println(main.jump(new int[]{2,3,1,1,4}));
        System.out.println(main.jump(new int[]{2,3,1,0,4}));
    }
}
