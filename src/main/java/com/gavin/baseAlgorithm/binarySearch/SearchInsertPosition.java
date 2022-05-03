/**
 * cordate.com gavin
 * Copyright (c) 2019-2022 All Rights Reserved
 */
package com.gavin.baseAlgorithm.binarySearch;

/**
 * https://leetcode-cn.com/problems/search-insert-position/
 *
 * @author gavin
 * @version $Id: SearchInsertPosition.java, v 1.0 2022年04月14日 2:17 AM apple copyright $
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length==0) return 0;
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] < target) {
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                // 可能存在有连续的相同值得情况
                if (mid > 0 && nums[mid-1] == target) {
                    end = mid - 1;
                } else {
                    return mid;
                }
            }
        }

        return start + 1;
    }

    public int searchInsert2(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1, ans = n;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (target <= nums[mid]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        SearchInsertPosition main = new SearchInsertPosition();
        System.out.println(main.searchInsert(new int[]{1,3,5,6}, 5));
        System.out.println(main.searchInsert(new int[]{1,3,5,6}, 2));
        System.out.println(main.searchInsert(new int[]{1,3,5,6}, 7));
    }
}
