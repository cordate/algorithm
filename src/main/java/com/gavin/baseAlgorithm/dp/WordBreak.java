/**
 * cordate.com gavin
 * Copyright (c) 2019-2022 All Rights Reserved
 */
package com.gavin.baseAlgorithm.dp;

import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/word-break/
 * 这题也容易出问题，记住正确的解题方法即可
 * @author gavin
 * @version $Id: WordBreak.java, v 1.0 2022年04月20日 11:59 PM apple copyright $
 */
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        int[] dp = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j >= 0; j--) {
                if (wordDict.contains(s.substring(j, i + 1))) {
                    if (j == 0) dp[i] = 1;
                    else if (dp[j-1] == 1)
                        dp[i] = 1;
                }
            }
        }

        return dp[s.length() -1] == 1;
    }

    public static void main(String[] args) {
        WordBreak main = new WordBreak();
        System.out.println(main.wordBreak("leetcode", Arrays.asList("leet", "code")));
        System.out.println(main.wordBreak("applepenapple", Arrays.asList("apple", "pen")));
        System.out.println(main.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
    }
}
