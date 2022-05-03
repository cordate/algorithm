/**
 * cordate.com gavin
 * Copyright (c) 2019-2022 All Rights Reserved
 */
package com.gavin.baseAlgorithm.dp;

/**
 * https://leetcode-cn.com/problems/jump-game/
 * 动态规划+贪心算法，这里是贪心思想的体现
 * @author gavin
 * @version $Id: JumpGame.java, v 1.0 2022年04月20日 12:52 PM apple copyright $
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            if (dp[i] == 1) {
                int n = nums[i];
                while (n > 0) {
                    if (i+n >= nums.length - 1) {
                        return true;
                    }
                    dp[i+n] = 1;
                    n--;
                }
            }
        }

        return dp[nums.length-1]==1;
    }

    public static void main(String[] args) {
        JumpGame main = new JumpGame();
        System.out.println(main.canJump(new int[]{2,3,1,1,4}));
        System.out.println(main.canJump(new int[]{3,2,1,0,4}));
    }
}
