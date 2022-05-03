/**
 * cordate.com gavin
 * Copyright (c) 2019-2022 All Rights Reserved
 */
package com.gavin.baseAlgorithm.dp;

import java.util.Arrays;

/**
 * https://www.lintcode.com/problem/92/
 *
 * @author gavin
 * @version $Id: BackPack.java, v 1.0 2022年05月01日 9:56 AM apple copyright $
 */
public class BackPack {
    /**
     * 这个容易遗忘
     * @param m
     * @param arrays
     * @return
     */
    public int backPack(int m, int[] arrays) {
        int[][] dp = new int[m+1][arrays.length +1];
        // 初始化数据
        Arrays.fill(dp[0], 0);
        for (int i = 0; i <= m; i++) {
            dp[i][0]=0;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= arrays.length; j++) {
                dp[i][j] = dp[i][j-1];
                if (i >= arrays[j-1]) {
                    dp[i][j] = Math.max(dp[i-arrays[j-1]][j-1] + arrays[j-1], dp[i][j]);
                }
            }
        }

        return dp[m][arrays.length];
    }

    public static void main(String[] args) {
        // 动态规划
        BackPack main = new BackPack();
        System.out.println(main.backPack(10, new int[]{3,4,8,5}));
        System.out.println(main.backPack(12, new int[]{2,3,5,7}));
        // 穷举法
        BackPack2 main2 = new BackPack2();
        System.out.println(main2.backPack(10, new int[]{3,4,8,5}));
        System.out.println(main2.backPack(12, new int[]{2,3,5,7}));
        // 递归回溯的做法
        BackPack3 main3 = new BackPack3();
        System.out.println(main3.backPack(10, new int[]{3,4,8,5}));
        System.out.println(main3.backPack(12, new int[]{2,3,5,7}));
    }
}

/**
 * 这种做法比较巧妙地解决了问题
 */
class BackPack2 {
    public int backPack(int m, int[] arrays) {
        int ret = 0;
        int all = (int) Math.pow(2, arrays.length);
        for (int i = 0; i < all; i++) {
            int s = 0;
            for (int j = 0; j < arrays.length && s < m; j++) {
                if (((1 << j) & i) != 0) {
                    s += arrays[j];
                }
            }
            if (s <= m) {
                ret = Math.max(ret, s);
            }
        }

        return ret;
    }
}

/**
 * 递归回溯处理流程
 */
class BackPack3 {
    private int max = 0;

    public int backPack(int m, int[] arrays) {
        backPack(m, 0, arrays);
        return max;
    }

    public void backPack(int remain, int tmp, int[] arrays) {
        if (remain <= 0) {
            return;
        }

        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i] == -1) {
                continue;
            }

            if (remain - arrays[i] < 0) {
                max = Math.max(max, tmp);
                continue;
            }

            if (remain - arrays[i] == 0) {
                max = Math.max(max, tmp + arrays[i]);
                continue;
            }

            int s = arrays[i];
            arrays[i] = -1;
            tmp += s;
            backPack(remain - s, tmp, arrays);
            arrays[i] = s;
            tmp -= s;
        }
    }
}
