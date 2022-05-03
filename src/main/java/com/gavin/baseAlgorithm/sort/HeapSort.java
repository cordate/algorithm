/**
 * cordate.com gavin
 * Copyright (c) 2019-2022 All Rights Reserved
 */
package com.gavin.baseAlgorithm.sort;

import java.util.Arrays;

/**
 * 堆排序
 *
 * @author gavin
 * @version $Id: HeapSort.java, v 1.0 2022年04月19日 2:02 AM apple copyright $
 */
public class HeapSort {
    public void sort(int[] nums) {
        if (nums == null || nums.length < 2) return;
        // 注意这里的调整，是到1/2
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            heapify(nums, i, nums.length);
        }
        int n = nums.length - 1;
        while (n >= 1) {
            int s = nums[n];
            nums[n] = nums[0];
            nums[0] = s;
            heapify(nums, 0, n);
            n--;
        }
    }

    public void heapify(int[] nums, int start, int end) {
        int largest = start;
        if (2 * start + 1 < end && nums[2 * start + 1] > nums[largest])
            largest = 2 * start + 1;
        if (2 * start + 2 < end && nums[2 * start + 2] > nums[largest])
            largest = 2 * start + 2;
        if (largest == start) {
            return;
        }

        int s = nums[largest];
        nums[largest] = nums[start];
        nums[start] = s;
        heapify(nums, largest, end);
    }

    public static void main(String[] args) {
        HeapSort main = new HeapSort();
        // 具有重复元素的数据也可以进行排序的
        int[] array = new int[]{5,6,4,2,8,3,9,5,6,1};
        //int[] array = new int[]{5,4,2,8,3,9,6,1};
        main.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
