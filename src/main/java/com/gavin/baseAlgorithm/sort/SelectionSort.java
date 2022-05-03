/**
 * cordate.com gavin
 * Copyright (c) 2019-2022 All Rights Reserved
 */
package com.gavin.baseAlgorithm.sort;

import java.util.Arrays;

/**
 * 选择排序
 *
 * @author gavin
 * @version $Id: SelectionSort.java, v 1.0 2022年04月19日 11:09 AM apple copyright $
 */
public class SelectionSort {
    public void sort(int[] nums) {
        if (nums == null || nums.length < 2) return;
        for (int i = 0; i < nums.length; i++) {
            int cur = i;
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j] < nums[cur]) {
                    cur = j;
                }
            }
            int tmp = nums[i];
            nums[i] = nums[cur];
            nums[cur] = tmp;
        }
    }

    public static void main(String[] args) {
        SelectionSort main = new SelectionSort();
        int[] array = new int[]{5,6,4,2,8,3,9,5,6,1};
        main.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
