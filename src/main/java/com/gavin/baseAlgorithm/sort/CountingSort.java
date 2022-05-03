/**
 * cordate.com gavin
 * Copyright (c) 2019-2022 All Rights Reserved
 */
package com.gavin.baseAlgorithm.sort;

import java.util.Arrays;

/**
 * 计数排序
 * @author gavin
 * @version $Id: CountingSort.java, v 1.0 2022年04月19日 2:26 PM apple copyright $
 */
public class CountingSort {
    public void sort(int[] nums) {
        int max=nums[0], min=nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) max = nums[i];
            else if (nums[i] < min) min = nums[i];
        }
        int n = max - min + 1;
        int[] tmp = new int[n];
        for (int i = 0; i < nums.length; i++) {
            tmp[nums[i]-min]++;
        }
        int i = 0;
        for (int j = 0; j < tmp.length; j++) {
            while (tmp[j] > 0) {
                nums[i++] = j + min;
                tmp[j]--;
            }
        }
    }

    public static void main(String[] args) {
        CountingSort main = new CountingSort();
        int[] array = new int[]{5,6,4,2,8,3,9,5,6,1};
        // int[] array = new int[] {4,6,1,9,3,2};
        main.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
