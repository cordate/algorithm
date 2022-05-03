/**
 * cordate.com gavin
 * Copyright (c) 2019-2022 All Rights Reserved
 */
package com.gavin.thought.backtrack;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/combination-sum/
 *
 * @author gavin
 * @version $Id: CombinationSum.java, v 1.0 2022年05月03日 2:16 PM apple copyright $
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        combinationSum(candidates, target, 0, list, result);
        return result;
    }

    private void combinationSum(int[] candidates, int remain, int first, List<Integer> list, List<List<Integer>> result) {
        if (remain == 0) {
            result.add(new ArrayList<>(list));
            return;
        }
        if (remain < 0) {
            return;
        }

        for (int i = first; i < candidates.length; i++) {
            remain -= candidates[i];
            list.add(candidates[i]);
            combinationSum(candidates, remain, i, list, result);
            list.remove(list.size() - 1);
            remain += candidates[i];
        }
    }

    public static void main(String[] args) {
        CombinationSum main = new CombinationSum();
        System.out.println(JSON.toJSONString(main.combinationSum(new int[] {2,3,6,7}, 7)));
        System.out.println(JSON.toJSONString(main.combinationSum(new int[] {2,3,5}, 8)));
        System.out.println(JSON.toJSONString(main.combinationSum(new int[] {2}, 1)));
    }
}
