/**
 * cordate.com gavin
 * Copyright (c) 2019-2022 All Rights Reserved
 */
package com.gavin.thought.recursion;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/reverse-string/
 * 字符串倒置处理
 *
 * @author gavin
 * @version $Id: ReverseString.java, v 1.0 2022年05月02日 5:13 PM apple copyright $
 */
public class ReverseString {
    private int h = 0;

    public void reverseString(char[] s) {
        if (s == null || s.length == 1) return;
        reverseString(s, s.length / 2 + 1);
    }

    public void reverseString(char[] s, int index) {
        if (index == s.length) {
            return;
        }
        reverseString(s, index + 1);
        char t = s[index];
        s[index] = s[h];
        s[h] = t;
        h++;
    }

    public static void main(String[] args) {
        ReverseString main = new ReverseString();
        char[] params = new char[] {'h','e','l','l','o'};
        main.reverseString(params);
        System.out.println(Arrays.toString(params));
    }
}
