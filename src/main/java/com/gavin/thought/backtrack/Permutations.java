/**
 * cordate.com gavin
 * Copyright (c) 2019-2022 All Rights Reserved
 */
package com.gavin.thought.backtrack;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/permutations/
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 * @author gavin
 * @version $Id: Permutations.java, v 1.0 2022年05月03日 2:17 AM apple copyright $
 */
public class Permutations {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> list = new ArrayList<>();
        permute(nums, list);
        return result;
    }

    private void permute(int[] nums, List<Integer> list) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
        }

        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) {
                continue;
            }
            list.add(nums[i]);
            permute(nums, list);
            list.remove(Integer.valueOf(nums[i]));
        }
    }

    public static void main(String[] args) {
        Permutations main = new Permutations();
        System.out.println(JSON.toJSONString(main.permute(new int[]{1,2,3})));
    }
}

/**
 * 通过交换来实现功能
 */
class Permutations2 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        for (int t : nums) {
            tmp.add(t);
        }
        permute(nums.length, ret, tmp, 0);
        return ret;
    }

    public void permute(int n, List<List<Integer>> ret, List<Integer> tmp, int first) {
        if (first==n) {
            ret.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = first; i<n;i++) {
            Collections.swap(tmp, first, i);
            permute(n, ret, tmp, first+1);
            Collections.swap(tmp, first, i);
        }
    }
}

class Permutations3 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        permute(nums, ret, tmp, visited);
        return ret;
    }

    public void permute(int[] nums, List<List<Integer>> ret, List<Integer> tmp, boolean[] visited) {
        if (nums.length == tmp.size()) {
            ret.add(new ArrayList<>(tmp));
            return;
        }

        for (int i=0; i< nums.length; i++) {
            if (!visited[i]) {
                tmp.add(nums[i]);
                visited[i] = true;
                permute(nums, ret, tmp, visited);
                tmp.remove(tmp.size() - 1);
                visited[i] = false;
            }
        }
    }
}
