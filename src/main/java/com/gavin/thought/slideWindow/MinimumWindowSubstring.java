/**
 * cordate.com gavin
 * Copyright (c) 2019-2022 All Rights Reserved
 */
package com.gavin.thought.slideWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/minimum-window-substring/
 * 这个循环方式改变一下就比较好写，否则写起来比较麻烦
 * 这里是变动的窗口滑动
 * @author gavin
 * @version $Id: MinimumWindowSubstring.java, v 1.0 2022年05月02日 9:49 PM apple copyright $
 */
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        String ret = null;
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int end = 0, head = 0;
        Map<Character, Integer> count = new HashMap<>();
        while (head <= s.length() - t.length()) {
            if (mapEquals(map, count)) {
                if (ret==null || ret.length() > (end-head))
                    ret = s.substring(head, end);
            }

            while (!mapEquals(map, count) && end < s.length()) {
                count.put(s.charAt(end), count.getOrDefault(s.charAt(end), 0) + 1);
                end++;
            }

            if (mapEquals(map, count)) {
                if (ret==null || ret.length() > (end-head))
                    ret = s.substring(head, end);
            }

            count.put(s.charAt(head), count.get(s.charAt(head)) - 1);
            head++;
        }

        return ret;
    }

    public String minWindow2(String s, String t) {
        Map<Character, Integer> origin = new HashMap<>();
        Map<Character, Integer> dest = new HashMap<>();
        for (char c : t.toCharArray()) {
            origin.put(c, origin.getOrDefault(c, 0) + 1);
        }

        int end = 0, head = 0;
        String result = null;
        while (end < s.length()) {
            dest.put(s.charAt(end), dest.getOrDefault(s.charAt(end), 0) + 1);
            while (head <= end && mapEquals(origin, dest)) {
                if (result == null || result.length() > end - head + 1) {
                    result = s.substring(head, end + 1);
                }
                dest.put(s.charAt(head), dest.get(s.charAt(head))-1);
                head++;
            }
            end++;
        }

        return result;
    }

    public boolean mapEquals(Map<Character, Integer> map, Map<Character, Integer> map2) {
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > map2.getOrDefault(entry.getKey(), 0)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        MinimumWindowSubstring main = new MinimumWindowSubstring();
        System.out.println(main.minWindow2("ADOBECODEBANC", "ABC"));
        System.out.println(main.minWindow2("a", "a"));
        System.out.println(main.minWindow2("a", "aa"));
    }
}
