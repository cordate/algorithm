/**
 * cordate.com gavin
 * Copyright (c) 2019-2022 All Rights Reserved
 */
package com.gavin.baseAlgorithm.sort;

import java.util.Arrays;

/**
 * shell排序
 *
 * @author gavin
 * @version $Id: ShellSort.java, v 1.0 2022年04月19日 11:43 AM apple copyright $
 */
public class ShellSort {
    public void sort(int[] nums) {
        int len = nums.length;
        for (int gap = len / 2; gap > 0; gap = gap / 2) {
            for (int i = gap; i < len; i++) {
                int j = i;
                int current = nums[i];
                while (j - gap >= 0 && current < nums[j - gap]) {
                    nums[j] = nums[j - gap];
                    j = j - gap;
                }
                nums[j] = current;
            }
        }
    }

    public static void main(String[] args) {
        ShellSort main = new ShellSort();
        int[] array = new int[]{5,6,4,2,8,3,9,5,6,1};
        // int[] array = new int[] {4,6,1,9,3,2};
        main.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
