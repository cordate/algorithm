/**
 * cordate.com gavin
 * Copyright (c) 2019-2022 All Rights Reserved
 */
package com.gavin.thought.slideWindow;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/
 *
 * @author gavin
 * @version $Id: FindAllAnagramsInAString.java, v 1.0 2022年05月03日 12:22 AM apple copyright $
 */
public class FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        int[] dest = new int[26];
        int[] ori = new int[26];
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < p.length(); i++) {
            ori[p.charAt(i)-'a']++;
            dest[p.charAt(i)-'a']++;
        }
        for (int i = 0; i < s.length() - p.length(); i++) {
            if (Arrays.equals(ori, dest)) {
                result.add(i);
            }
            dest[s.charAt(i)-'a']--;
            dest[s.charAt(i+p.length())-'a']++;
        }

        if (Arrays.equals(ori, dest)) {
            result.add(s.length() - p.length());
        }

        return result;
    }

    public static void main(String[] args) {
        FindAllAnagramsInAString main = new FindAllAnagramsInAString();
        System.out.println(JSON.toJSONString(main.findAnagrams("cbaebabacd", "abc")));
        System.out.println(JSON.toJSONString(main.findAnagrams("abab", "ab")));
    }
}
