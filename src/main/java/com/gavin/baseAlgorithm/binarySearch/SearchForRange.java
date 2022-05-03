/**
 * cordate.com gavin
 * Copyright (c) 2019-2022 All Rights Reserved
 */
package com.gavin.baseAlgorithm.binarySearch;

import java.util.Arrays;

/**
 * https://www.lintcode.com/problem/61/
 *
 * @author gavin
 * @version $Id: SearchForRange.java, v 1.0 2022年04月14日 1:50 AM apple copyright $
 */
public class SearchForRange {
    /**
     * @param nums: an integer sorted array
     * @param target: an integer to be inserted
     * @return: a list of length 2, [index1, index2]
     */
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length==0) return new int[]{-1, -1};
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] < target) {
                if (nums[mid + 1] > target) {
                    return new int[]{mid, mid + 1};
                }
                start = mid + 1;
            } else {
                if (nums[mid - 1] < target) {
                    return new int[]{mid-1, mid};
                }
                end = mid - 1;
            }
        }

        if (nums[start] > target) {
            return new int[]{start-1, start};
        } else {
            return new int[]{start, start+1};
        }
    }

    public int[] searchRange2(int[] arr, int target) {
        int[] ret = new int[]{-1, -1};
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int middle = (end - start) / 2 + start;
            if (arr[middle] < target) {
                // 加1与减去1很重要
                start = middle + 1;
                continue;
            } else if (arr[middle] > target) {
                // 加1与减去1很重要
                end = middle - 1;
                continue;
            }
            ret[0] = middle;
            ret[1] = middle;
            while (ret[0] > 0 && arr[ret[0] - 1]==target) {
                ret[0]--;
            }

            while (ret[1] <= end && arr[ret[1] + 1]==target) {
                ret[1]++;
            }
            break;
        }

        return ret;
    }

    public static void main(String[] args) {
        SearchForRange main = new SearchForRange();
        System.out.println(Arrays.toString(
                main.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
    }
}
