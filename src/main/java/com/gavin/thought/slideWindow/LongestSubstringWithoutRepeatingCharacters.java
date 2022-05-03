/**
 * cordate.com gavin
 * Copyright (c) 2019-2022 All Rights Reserved
 */
package com.gavin.thought.slideWindow;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 *
 * @author gavin
 * @version $Id: LongestSubstringWithoutRepeatingCharacters.java, v 1.0 2022年05月03日 12:37 AM apple copyright $
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int ret = 0;
        int[] cnt = new int[26];
        int head = 0, end = -1;
        while (end < s.length() - 1) {
            end++;
            while (cnt[s.charAt(end)-'a'] == 0) {
                cnt[s.charAt(end)-'a']++;
                end++;
            }
            cnt[s.charAt(end)-'a']++;
            ret = Math.max(ret, end-head);

            while (s.charAt(head) != s.charAt(end)) {
                cnt[s.charAt(head)-'a']--;
                head++;
            }
            cnt[s.charAt(head)-'a']--;
            head++;
        }

        return ret;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters main = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(main.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(main.lengthOfLongestSubstring("bbbbb"));
        System.out.println(main.lengthOfLongestSubstring("pwwkew"));
    }
}
