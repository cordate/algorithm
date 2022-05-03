/**
 * cordate.com gavin
 * Copyright (c) 2019-2022 All Rights Reserved
 */
package com.gavin.baseAlgorithm.binarySearch;

/**
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 *
 * @author gavin
 * @version $Id: SearchInRotatedSortedArray.java, v 1.0 2022年04月15日 2:10 AM apple copyright $
 */
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = (end + start) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[mid] > nums[end]) {
                if (target > nums[start] && nums[mid] > target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (nums[mid] < target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray main = new SearchInRotatedSortedArray();
        System.out.println(main.search(new int[]{4,5,6,7,0,1,2}, 0));
        System.out.println(main.search(new int[]{4,5,6,7,0,1,2}, 3));
    }
}
