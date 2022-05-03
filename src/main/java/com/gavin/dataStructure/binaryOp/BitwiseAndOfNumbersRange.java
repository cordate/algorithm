/**
 * cordate.com gavin
 * Copyright (c) 2019-2022 All Rights Reserved
 */
package com.gavin.dataStructure.binaryOp;

/**
 * https://leetcode-cn.com/problems/bitwise-and-of-numbers-range/
 * 这题需要好好总结，学习一下。
 *
 * 思路与算法
 * 还有一个位移相关的算法叫做「Brian Kernighan 算法」，它用于清除二进制串中最右边的1。
 * Brian Kernighan 算法的关键在于我们每次对 \textit{number}number 和 \textit{number}-1number−1 之间进行按位与运算后，\textit{number}number 中最右边的 11 会被抹去变成 00。
 *
 * @author gavin
 * @version $Id: BitwiseAndOfNumbersRange.java, v 1.0 2022年04月13日 11:02 PM apple copyright $
 */
public class BitwiseAndOfNumbersRange {
    public int rangeBitwiseAnd(int left, int right) {
        int n = 0;

        while (left < right) {
            left = left >> 1;
            right = right >> 1;
            n++;
        }

        return left << n;
    }

    public static void main(String[] args) {
        BitwiseAndOfNumbersRange main = new BitwiseAndOfNumbersRange();
        System.out.println(main.rangeBitwiseAnd(5, 7));
        System.out.println(main.rangeBitwiseAnd(0, 0));
        System.out.println(main.rangeBitwiseAnd(1, 2147483647));
    }
}
