/**
 * cordate.com gavin
 * Copyright (c) 2019-2022 All Rights Reserved
 */
package com.gavin.baseAlgorithm.binarySearch;

/**
 * https://leetcode-cn.com/problems/binary-search/
 * 这是简单题，便于实现
 *
 * @author gavin
 * @version $Id: BinarySearch.java, v 1.0 2022年04月14日 1:33 AM apple copyright $
 */
public class BinarySearch {
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = (end + start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        BinarySearch main = new BinarySearch();
        System.out.println(main.search(new int[]{-1,0,3,5,9,12}, 9));
        System.out.println(main.search(new int[]{-1,0,3,5,9,12}, 2));
    }
}
