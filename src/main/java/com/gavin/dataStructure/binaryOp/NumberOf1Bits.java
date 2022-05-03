/**
 * cordate.com gavin
 * Copyright (c) 2019-2022 All Rights Reserved
 */
package com.gavin.dataStructure.binaryOp;

/**
 * https://leetcode-cn.com/problems/number-of-1-bits/
 * 这题有另一种解法：位运算
 *
 * @author gavin
 * @version $Id: NumberOf1Bits.java, v 1.0 2022年04月13日 6:39 PM apple copyright $
 */
public class NumberOf1Bits {
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
        NumberOf1Bits main = new NumberOf1Bits();
        System.out.println(main.hammingWeight(7));
    }
}
