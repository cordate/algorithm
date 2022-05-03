/**
 * cordate.com gavin
 * Copyright (c) 2019-2022 All Rights Reserved
 */
package com.gavin.baseAlgorithm.sort;

import java.util.Arrays;

/**
 * 插入排序
 *
 * @author gavin
 * @version $Id: InsertionSort.java, v 1.0 2022年04月19日 11:13 AM apple copyright $
 */
public class InsertionSort {
    public void sort(int[] nums) {
        if (nums == null || nums.length < 2) return;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[i]) {
                    int tmp = nums[i];
                    int n = i;
                    while (n > j) {
                        nums[n] = nums[n-1];
                        n--;
                    }
                    nums[n] = tmp;
                }
            }
        }
    }

    /**
     * 感觉像快速排序，又感觉像选择排序，但其实结果也对
     * @param nums
     */
    public void sort1(int[] nums) {
        if (nums == null || nums.length < 2) return;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    int n = j;
                    int tmp = nums[j];
                    while (n > i) {
                        nums[n] = nums[n-1];
                        n--;
                    }
                    nums[n] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        InsertionSort main = new InsertionSort();
        int[] array = new int[]{5,6,4,2,8,3,9,5,6,1};
        main.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
