/**
 * cordate.com gavin
 * Copyright (c) 2019-2022 All Rights Reserved
 */
package com.gavin.dataStructure.binaryOp;

/**
 * https://leetcode-cn.com/problems/single-number/
 *
 * @author gavin
 * @version $Id: SingleNumber.java, v 1.0 2022年04月13日 3:30 AM apple copyright $
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int a = 0;
        for (int i = 0; i < nums.length; i++) {
            a = a ^ nums[i];
        }
        return a;
    }

    /**
     * 这是一种通用的解法，可以解决一类这样的问题
     * @param nums
     * @return
     */
    public int singleNumber2(int[] nums) {
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            int total = 0;
            for (int num : nums) {
                total += (num >> i) & 1;
            }
            if (total % 2 != 0) {
                ret |= (1 << i);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        SingleNumber main = new SingleNumber();
        System.out.println(main.singleNumber(new int[]{4,1,2,1,2}));
        System.out.println(main.singleNumber2(new int[]{4,1,2,1,2}));
    }
}
