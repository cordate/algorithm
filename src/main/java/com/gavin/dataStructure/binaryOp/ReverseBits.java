/**
 * cordate.com gavin
 * Copyright (c) 2019-2022 All Rights Reserved
 */
package com.gavin.dataStructure.binaryOp;

/**
 * https://leetcode-cn.com/problems/reverse-bits/
 * 这题有分治法的解法，见官方的解法
 *
 * @author gavin
 * @version $Id: ReverseBits.java, v 1.0 2022年04月13日 10:44 PM apple copyright $
 */
public class ReverseBits {
    public int reverseBits(int n) {
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1 << i) != 0) {
                ret |= 1 << (31 - i);
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        ReverseBits main = new ReverseBits();
        System.out.println(main.reverseBits(0b00000010100101000001111010011100));
        System.out.println(main.reverseBits(0b11111111111111111111111111111101));
    }
}
