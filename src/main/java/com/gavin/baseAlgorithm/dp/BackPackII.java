/**
 * cordate.com gavin
 * Copyright (c) 2019-2022 All Rights Reserved
 */
package com.gavin.baseAlgorithm.dp;

import java.util.Arrays;

/**
 * https://www.lintcode.com/problem/125/
 *
 * @author gavin
 * @version $Id: BackPackII.java, v 1.0 2022年05月01日 12:42 PM apple copyright $
 */
public class BackPackII {
    public int max = 0;

    public int backPackII(int m, int[] arrays, int[] values) {
        int[][] dp = new int[m+1][arrays.length+1];
        Arrays.fill(dp[0], 0);
        for (int i = 0; i < arrays.length + 1; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i < m+1; i++) {
            for (int j = 1; j < arrays.length + 1; j++) {
                dp[i][j] = dp[i][j-1];
                if (i > dp[i][j-1] && i-arrays[i-1] >= 0) {
                    dp[i][j] = Math.max(dp[i-arrays[i-1]][j] + values[i-1], dp[i][j]);
                }
            }
        }

        return dp[m][arrays.length];
    }

    /**
     * 递归回溯
     * @param m
     * @param arrays
     * @param values
     * @return
     */
    public int backPackII3(int m, int[] arrays, int[] values) {
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i] == -1) {
                continue;
            }

            if (m - arrays[i] < 0) {
                max = Math.max(max, count(arrays, values));
                continue;
            }

            if (m - arrays[i] == 0) {
                max = Math.max(max, count(arrays, values) + values[i]);
                continue;
            }

            int tmp = arrays[i];
            arrays[i] = -1;
            backPackII3(m - tmp, arrays, values);
            arrays[i] = tmp;
        }

        return max;
    }

    private int count(int[] arrays, int[] values) {
        int ret = 0;
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i] == -1) {
                ret += values[i];
            }
        }
        return ret;
    }

    /**
     * 全排列的做法
     * @param m
     * @param arrays
     * @param values
     * @return
     */
    public int backPackII2(int m, int[] arrays, int[] values) {
        int ret = 0;
        int all = (int) Math.pow(2, arrays.length);
        for (int i = 0; i < all; i++) {
            int s = 0;
            int val = 0;
            for (int j = 0; j < arrays.length && s < m; j++) {
                if (((1 << j) & i) != 0) {
                    s += arrays[j];
                    val += values[j];
                }
            }
            if (s <= m) {
                ret = Math.max(ret, val);
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        BackPackII main = new BackPackII();
        // 动态规划的处理方法，其实也是找到所有可能的解进行处理
        System.out.println(main.backPackII2(10, new int[]{2, 3, 5, 7}, new int[]{1, 5, 2, 4}));
        System.out.println(main.backPackII2(10, new int[]{2, 3, 8}, new int[]{2, 5, 8}));
        // 递归回溯
        System.out.println(main.backPackII3(10, new int[]{2, 3, 5, 7}, new int[]{1, 5, 2, 4}));
        main.max = 0;
        System.out.println(main.backPackII3(10, new int[]{2, 3, 8}, new int[]{2, 5, 8}));
        // 全排列做法
        System.out.println(main.backPackII2(10, new int[]{2, 3, 5, 7}, new int[]{1, 5, 2, 4}));
        System.out.println(main.backPackII2(10, new int[]{2, 3, 8}, new int[]{2, 5, 8}));
    }
}
