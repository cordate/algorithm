/**
 * cordate.com gavin
 * Copyright (c) 2019-2022 All Rights Reserved
 */
package com.gavin.thought.backtrack;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/subsets/
 * 这题也可以是排列组合
 * @author gavin
 * @version $Id: Subsets.java, v 1.0 2022年05月03日 1:24 AM apple copyright $
 */
public class Subsets {
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> list = new ArrayList<>();
        subsets(nums, list, 0);
        return result;
    }

    public void subsets(int[] nums, List<Integer> list, int time) {
        if (time == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        // 不选
        subsets(nums, list, time + 1);
        // 选的话，按照索引选，这个我倒是没想到
        list.add(nums[time]);
        subsets(nums, list, time+1);
        list.remove(Integer.valueOf(nums[time]));
    }

    public List<List<Integer>> subsets2(int[] nums) {
        result.clear();
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<(1<<n); i++) {
            list.clear();
            for (int j = 0;j<n;j++) {
                if ((i & (1<<j)) != 0) {
                    list.add(nums[j]);
                }
            }
            result.add(new ArrayList<>(list));
        }
        return result;
    }

    public static void main(String[] args) {
        Subsets main = new Subsets();
        System.out.println(JSON.toJSONString(main.subsets(new int[]{1,2,3})));
    }
}
