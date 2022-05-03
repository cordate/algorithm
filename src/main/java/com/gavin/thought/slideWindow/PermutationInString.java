/**
 * cordate.com gavin
 * Copyright (c) 2019-2022 All Rights Reserved
 */
package com.gavin.thought.slideWindow;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/permutation-in-string/
 * 这里是固定的窗口滑动
 * 这题需要好好学习一番
 * @author gavin
 * @version $Id: PermutationInString.java, v 1.0 2022年05月02日 11:00 PM apple copyright $
 */
public class PermutationInString {
    /**
     * 固定窗口的实现
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion(String s1, String s2) {
        int[] dest = new int[26];
        int[] ori = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            ori[s1.charAt(i)-'a']++;
            dest[s2.charAt(i)-'a']++;
        }
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if (Arrays.equals(ori, dest)) {
                return true;
            } else {
                dest[s2.charAt(i)-'a']--;
                dest[s2.charAt(i+s1.length())-'a']++;
            }
        }

        return false;
    }

    public boolean checkInclusion2(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m) {
            return false;
        }
        int[] cnt = new int[26];
        for (int i = 0; i < n; ++i) {
            --cnt[s1.charAt(i) - 'a'];
        }
        int left = 0;
        for (int right = 0; right < m; ++right) {
            int x = s2.charAt(right) - 'a';
            ++cnt[x];
            while (cnt[x] > 0) {
                --cnt[s2.charAt(left) - 'a'];
                ++left;
            }
            if (right - left + 1 == n) {
                return true;
            }
        }
        return false;
    }

    /**
     * 变动窗口的实现
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion3(String s1, String s2) {
        int[] dest = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            dest[s1.charAt(i)-'a']++;
        }

        int end = 0, head = 0;
        while (head <= s2.length() - s1.length()) {
            if (check(dest) == 0) {
                return true;
            } else if (check(dest)==-1) {
                dest[s2.charAt(head)-'a']++;
                head++;
            } else {
                dest[s2.charAt(end)-'a']--;
                end++;
            }
        }

        return false;
    }

    public int check(int[] dest) {
        int ret = 0;
        for (int i : dest) {
            if (i < 0) return -1;
            if (i > 0) ret=1;
        }
        return ret;
    }

    public static void main(String[] args) {
        PermutationInString main = new PermutationInString();
        System.out.println(main.checkInclusion("ab", "eidbaooo"));
        System.out.println(main.checkInclusion("ab", "eidboaoo"));
    }
}
