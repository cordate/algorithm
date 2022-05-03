/**
 * cordate.com gavin
 * Copyright (c) 2019-2022 All Rights Reserved
 */
package com.gavin.technique.set;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/longest-consecutive-sequence/
 *
 * @author gavin
 * @version $Id: MaxSequence.java, v 1.0 2022年05月02日 8:34 PM apple copyright $
 */
public class MaxSequence {
    public static void main(String[] args) {
        MaxSequence main = new MaxSequence();
        System.out.println(main.longestConsecutive(new int[]{100,4,200,1,3,2}));
    }

    public int longestConsecutive(int[] nums) {
        // 不要忘记特殊情况
        if (nums==null || nums.length==0) return 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int result = 1;
        for (int n : nums) {
            // 注意这里可以避免大量计算
            if (set.contains(n - 1)) {
                continue;
            }
            int i = 1;
            while (set.contains(n + i)) {
                i++;
            }
            result = Math.max(result, i);
        }
        return result;
    }
}
