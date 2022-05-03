/**
 * cordate.com gavin
 * Copyright (c) 2019-2022 All Rights Reserved
 */
package com.gavin.thought.backtrack;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/palindrome-partitioning/
 * 非动态规划的写法就不写了
 * @author gavin
 * @version $Id: PalindromePartitioning.java, v 1.0 2022年05月03日 3:00 PM apple copyright $
 */
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            Arrays.fill(dp[i], true);
        }

        for (int i = 1; i < s.length(); i++) {
            for (int j = i-1; j >= 0 ; j--) {
                if (s.charAt(i) == s.charAt(j) && dp[i-1][j+1]) {
                    dp[i][j] = true;
                    dp[j][i] = true;
                } else {
                    dp[i][j] = false;
                    dp[j][i] = false;
                }
            }
        }

//        for (int i = s.length()-1; i >= 0; i--) {
//            for (int j = i + 1; j < s.length(); j++) {
//                if (s.charAt(i) == s.charAt(j) && dp[i+1][j-1]) {
//                    dp[i][j] = true;
//                } else {
//                    dp[i][j] = false;
//                }
//            }
//        }

        List<List<String>> result = new ArrayList<>();
        List<String> list = new ArrayList<>();
        partition(s, dp, 0, result, list);

        return result;
    }

    public void partition(String s, boolean[][] dp, int index,
                          List<List<String>> result, List<String> list) {
        if (index == s.length()) {
            result.add(new ArrayList<>(list));
            return;
        }

        // 只会访问矩阵的上半角
        for (int i = index; i < s.length(); i++) {
            if (dp[index][i]) {
                list.add(s.substring(index, i+1));
                partition(s, dp, i + 1, result, list);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        PalindromePartitioning main = new PalindromePartitioning();
        System.out.println(JSON.toJSONString(main.partition("aab")));
        System.out.println(JSON.toJSONString(main.partition("a")));
        System.out.println(JSON.toJSONString(main.partition("aabb")));
    }
}
