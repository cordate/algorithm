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
 * https://leetcode-cn.com/problems/subsets-ii/
 *
 * @author gavin
 * @version $Id: Subsets.java, v 1.0 2022年05月03日 1:24 AM apple copyright $
 */
public class Subsets2 {
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> list = new ArrayList<>();
        subsetsWithDup2(nums, list, 0);
        return result;
    }

    public void subsetsWithDup(int[] nums, List<Integer> list, int time) {
        if (time == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        if (!list.contains(nums[time]))
            subsetsWithDup(nums, list, time + 1);
        list.add(nums[time]);
        subsetsWithDup(nums, list, time+1);
        list.remove(Integer.valueOf(nums[time]));
    }

    public void subsetsWithDup2(int[] nums, List<Integer> list, int time) {
        if (time == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        subsetsWithDup(nums, list, time + 1);
        if (!list.contains(nums[time]) && time > 0 && nums[time - 1] == nums[time]) {
            return;
        }
        list.add(nums[time]);
        subsetsWithDup(nums, list, time+1);
        list.remove(Integer.valueOf(nums[time]));
    }

    public List<List<Integer>> subsetsWithDup3(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<(1<<n); i++) {
            boolean flag = true;
            list.clear();
            for (int j = 0;j<n;j++) {
                if ((i & (1<<j)) != 0) {
                    if (j>0 && nums[j]==nums[j-1]&&((1<<(j-1))&i)==0) {
                        flag = false;
                        break;
                    }
                    list.add(nums[j]);
                }
            }
            if (flag)
                result.add(new ArrayList<>(list));
        }
        return result;
    }

    public static void main(String[] args) {
        Subsets2 main = new Subsets2();
        System.out.println(JSON.toJSONString(main.subsetsWithDup(new int[]{1,2,2})));
    }
}
