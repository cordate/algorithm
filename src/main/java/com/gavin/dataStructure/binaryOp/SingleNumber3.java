/**
 * cordate.com gavin
 * Copyright (c) 2019-2022 All Rights Reserved
 */
package com.gavin.dataStructure.binaryOp;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/single-number-iii/
 * 方法：
 *  1. hash表法
 *  2. 二进制位操作（两个数的并集，然后使用特殊位区分，然后数据分类进行相应的数查找）
 * 官方的解法是通过特别的方式找到了分隔指标，我这里是直接使用某一位进行分隔
 *
 * @author gavin
 * @version $Id: SingleNumber3.java, v 1.0 2022年04月13日 1:40 PM apple copyright $
 */
public class SingleNumber3 {
    public int[] singleNumber(int[] nums) {
        int temp = 0;
        for (int num : nums) {
            temp ^= num;
        }
        int flag = 0;
        for (int i = 0; i < 32; i++) {
            flag = 1 << i;
            if ((temp & flag) != 0) {
                break;
            }
        }
        int a =0 , b = 0;
        for (int num : nums) {
            if ((num & flag) != 0)
                a ^= num;
            else
                b ^= num;
        }

        return new int[]{a,b};
    }

    public static void main(String[] args) {
        SingleNumber3 main = new SingleNumber3();
        System.out.println(Arrays.toString(main.singleNumber(new int[] {1,2,1,3,2,5})));
    }
}
