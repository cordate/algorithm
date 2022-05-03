/**
 * cordate.com gavin
 * Copyright (c) 2019-2022 All Rights Reserved
 */
package com.gavin.baseAlgorithm.sort;

import java.util.Arrays;

/**
 * 快速排序算法的实现
 *
 * @author gavin
 * @version $Id: QuickSort.java, v 1.0 2022年04月18日 7:14 PM apple copyright $
 */
public class QuickSort {
    public void sort(int[] nums) {
        if (nums == null || nums.length < 2) return;
        sort(nums, 0, nums.length - 1);
    }

    public void sort(int[] nums, int start, int end) {
        if (start >= end) return;
        int cur = start; // 当前的游标
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] < nums[cur]) { // 只移动小于的情况
                int v = nums[i];
                int f = i;
                // 依次移位操作
                while (f > cur) {
                    nums[f] = nums[f-1];
                    f--;
                }
                nums[f] = v;
                cur++; // 基准数位置移动
            }
        }
        // 继续左侧快排
        sort(nums, start, cur - 1);
        // 继续右侧快排
        sort(nums, cur+1, end);
    }

    public static void main(String[] args) {
        QuickSort main = new QuickSort();
        int[] array = new int[]{5,6,4,2,8,3,9,5,6,1};
        main.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
