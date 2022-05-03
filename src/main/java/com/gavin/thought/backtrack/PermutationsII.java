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
 * https://leetcode-cn.com/problems/permutations-ii/
 *
 * @author gavin
 * @version $Id: Permutations.java, v 1.0 2022年05月03日 2:17 AM apple copyright $
 */
public class PermutationsII {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] selected = new boolean[nums.length];
        List<Integer> list = new ArrayList<>();
        permuteUnique(nums, selected, list);
        return result;
    }

    private void permuteUnique(int[] nums, boolean[] selected, List<Integer> list) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (selected[i] || (i > 0 && nums[i] == nums[i-1] && selected[i-1])) {
                continue;
            }
            selected[i] = true;
            list.add(nums[i]);
            permuteUnique(nums, selected, list);
            list.remove(list.size() - 1);
            selected[i] = false;
        }
    }

    public List<List<Integer>> permuteUnique2(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int t : nums) {
            list.add(t);
        }
        permute(nums, list, 0);
        return result;
    }

    private void permute(int[] nums, List<Integer> list, int first) {
        if (first == list.size()) {
            result.add(new ArrayList<>(list));
            return;
        }

        // 这里靠顺序进行排序
        for (int i = first; i < list.size(); i++) {
            if (first != i &&
                    (list.get(first) == list.get(i) || nums[first] == nums[i])) {
                continue;
            }

            Collections.swap(list, first, i);
            permute(nums, list, first + 1);
            Collections.swap(list, first, i);
        }
    }

    private void clear() {
        this.result.clear();
    }

    public static void main(String[] args) {
        PermutationsII main = new PermutationsII();
        System.out.println(JSON.toJSONString(main.permuteUnique2(new int[]{1,2,2})));
        main.clear();
        System.out.println(JSON.toJSONString(main.permuteUnique2(new int[]{1,1,2})));
    }
}
