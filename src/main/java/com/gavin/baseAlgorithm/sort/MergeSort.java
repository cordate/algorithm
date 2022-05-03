/**
 * cordate.com gavin
 * Copyright (c) 2019-2022 All Rights Reserved
 */
package com.gavin.baseAlgorithm.sort;

import java.util.Arrays;

/**
 * 归并排序的实现，典型的分治法
 *
 * @author gavin
 * @version $Id: MergeSort.java, v 1.0 2022年04月18日 7:37 PM apple copyright $
 */
public class MergeSort {
    public void sort(int[] nums) {
        if (nums == null || nums.length < 2) return;
        sort(nums, 0, nums.length - 1);
    }

    public void sort(int[] nums, int start, int end) {
        if (start >= end) return;
        int mid = (start + end) / 2;
        sort(nums, start, mid);
        sort(nums, mid+1, end);
        int cur1 = start, cur2 = mid + 1;
        while (cur1 <= mid && cur2 <= end) {
            if (nums[cur1] < nums[cur2]) {
                cur1++;
                continue;
            }
            int v = nums[cur2];
            int f = cur2;
            while(f > cur1) {
                nums[f] = nums[f-1];
                f--;
            }
            nums[f] = v;
            mid++;
            cur1++;
            cur2++;
        }
    }

    public static void main(String[] args) {
        MergeSort main = new MergeSort();
        int[] array = new int[]{5,6,4,2,8,3,9,5,6,1};
        main.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
