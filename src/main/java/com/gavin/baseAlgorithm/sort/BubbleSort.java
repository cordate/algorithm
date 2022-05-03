/**
 * cordate.com gavin
 * Copyright (c) 2019-2022 All Rights Reserved
 */
package com.gavin.baseAlgorithm.sort;

import java.util.Arrays;

/**
 * 冒泡排序，这个题目比较简单的处理一下即可
 *
 * @author gavin
 * @version $Id: BubbleSort.java, v 1.0 2022年04月19日 10:57 AM apple copyright $
 */
public class BubbleSort {
    public void sort(int[] nums) {
        if (nums == null || nums.length < 2) return;
        for (int i = nums.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (nums[j] <= nums[j+1]) {
                    continue;
                } else {
                    int tmp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        BubbleSort main = new BubbleSort();
        int[] array = new int[]{5,6,4,2,8,3,9,5,6,1};
        main.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
