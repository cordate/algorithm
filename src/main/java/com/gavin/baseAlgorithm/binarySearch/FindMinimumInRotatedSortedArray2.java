/**
 * cordate.com gavin
 * Copyright (c) 2019-2022 All Rights Reserved
 */
package com.gavin.baseAlgorithm.binarySearch;

/**
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/
 *
 * @author gavin
 * @version $Id: FindMinimumInRotatedSortedArray2.java, v 1.0 2022年04月14日 6:50 PM apple copyright $
 */
public class FindMinimumInRotatedSortedArray2 {
    public int findMin(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = (end + start) / 2;
            if (nums[mid] < nums[end]) {
                end = mid;
            } else if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else {
                end -= 1;
            }
        }

        return nums[start];
    }

    public static void main(String[] args) {
        FindMinimumInRotatedSortedArray2 main = new FindMinimumInRotatedSortedArray2();
        System.out.println(main.findMin(new int[]{2,2,2,0,1}));
        System.out.println(main.findMin(new int[]{1,3,5}));
    }
}
