/**
 * cordate.com gavin
 * Copyright (c) 2019-2022 All Rights Reserved
 */
package com.gavin.baseAlgorithm.binarySearch;

/**
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 *
 * @author gavin
 * @version $Id: FindMinimumInRotatedSortedArray.java, v 1.0 2022年04月14日 10:17 AM apple copyright $
 */
public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = (end + start) / 2;
            if (nums[mid] < nums[start] && nums[mid] < nums[end]) {
                end = mid - 1;
            } else if (nums[mid] > nums[start] && nums[mid] > nums[end]) {
                start = mid + 1;
            } else {
                return nums[start];
            }
        }

        return nums[start];
    }

    public int findMin2(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = (end + start) / 2;
            if (nums[mid] < nums[end]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return nums[start];
    }

    public static void main(String[] args) {
        FindMinimumInRotatedSortedArray main = new FindMinimumInRotatedSortedArray();
        System.out.println(main.findMin2(new int[] {3,4,5,1,2}));
        System.out.println(main.findMin2(new int[] {4,5,6,7,0,1,2}));
        System.out.println(main.findMin2(new int[] {3,4,5,1,2}));
    }
}
