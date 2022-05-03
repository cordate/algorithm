/**
 * cordate.com gavin
 * Copyright (c) 2019-2022 All Rights Reserved
 */
package com.gavin.baseAlgorithm.binarySearch;

/**
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii/
 * 这块需要好好学习了，主要是可能存在的一种特殊情况的处理
 *
 * @author gavin
 * @version $Id: SearchInRotatedSortedArray2.java, v 1.0 2022年04月15日 2:15 AM apple copyright $
 */
public class SearchInRotatedSortedArray2 {
    public boolean search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = (end + start) / 2;
            if (nums[mid] == target)
                return true;
            // 这里防止相同数据被分隔两端
            if (nums[mid] == nums[start] && nums[mid] == nums[end]) {
                start++;
                end--;
            } else if (nums[mid] > nums[end]) {
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

        return false;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray2 main = new SearchInRotatedSortedArray2();
        System.out.println(main.search(new int[]{2,5,6,0,0,1,2}, 0));
        System.out.println(main.search(new int[]{2,5,6,0,0,1,2}, 3));
    }
}
