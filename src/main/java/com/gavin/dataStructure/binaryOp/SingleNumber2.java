/**
 * cordate.com gavin
 * Copyright (c) 2019-2022 All Rights Reserved
 */
package com.gavin.dataStructure.binaryOp;

/**
 * https://leetcode-cn.com/problems/single-number-ii/
 * 可以使用hash表法（这种比较简单）、二进制位运算
 * 还有其他解法认真梳理学习一下
 *   1. 数字电路法，要学习画真值表
 *
 * @author gavin
 * @version $Id: SingleNumber2.java, v 1.0 2022年04月13日 3:34 AM apple copyright $
 */
public class SingleNumber2 {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; ++i) {
            int total = 0;
            // 三次进行处理，这个思路也可以解决两个的问题吧
            for (int num: nums) {
                total += ((num >> i) & 1);
            }
            if (total % 3 != 0) {
                ans |= (1 << i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        SingleNumber2 main = new SingleNumber2();
        System.out.println(main.singleNumber(new int[]{0,1,0,1,0,1,99}));
    }
}
