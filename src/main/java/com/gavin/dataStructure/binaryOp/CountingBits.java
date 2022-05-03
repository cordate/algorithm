/**
 * cordate.com gavin
 * Copyright (c) 2019-2022 All Rights Reserved
 */
package com.gavin.dataStructure.binaryOp;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/counting-bits/
 * 可以想到的方法就是迭代处理
 * 这题可以使用动态规划的思路进行处理，容易遗忘
 * 递归条件就是汉明重量里的另一种位运算的解法，注意这里的细节。
 * 这种不记忆也没关系，毕竟不是通用解法，这题也有常规解法，一般不考这种简单题
 *
 * @author gavin
 * @version $Id: CountingBits.java, v 1.0 2022年04月13日 8:36 PM apple copyright $
 */
public class CountingBits {
    public int[] countBits(int n) {
        int[] ret = new int[n+1];
        ret[0] = 0;
        for (int i = 0; i <= n; i++) {
            ret[i] = hammingWeight(i);
        }

        return ret;
    }

    public int hammingWeight(int n) {
        int sum = 0;
        for (int i = 0; i < 32; i++) {
            if (((1 << i) & n) != 0) {
                sum += 1;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        CountingBits main = new CountingBits();
        System.out.println(Arrays.toString(main.countBits(5)));
    }
}
