/**
 * cordate.com gavin
 * Copyright (c) 2019-2022 All Rights Reserved
 */
package com.gavin.baseAlgorithm.sort;

import java.util.Arrays;

/**
 * 自己创造的排序算法
 *
 * @author gavin
 * @version $Id: SwapSort.java, v 1.0 2022年04月19日 6:58 PM apple copyright $
 */
public class SwapSort {
    public static void main(String[] args) {
        SwapSort main = new SwapSort();
        int[] arr = new int[] {4,6,1,9,3,2};
        main.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void sort(int[] arr) {
        boolean finish = false;

        while (!finish) {
            finish = true;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    finish = false;
                    int tmp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1]=tmp;
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
}
