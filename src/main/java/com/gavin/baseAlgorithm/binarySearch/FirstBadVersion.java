/**
 * cordate.com gavin
 * Copyright (c) 2019-2022 All Rights Reserved
 */
package com.gavin.baseAlgorithm.binarySearch;

/**
 * https://leetcode-cn.com/problems/first-bad-version/
 * 这题思路比较简单不实现
 * @author gavin
 * @version $Id: FirstBadVersion.java, v 1.0 2022年04月14日 2:47 AM apple copyright $
 */
public class FirstBadVersion {
    public int firstBadVersion(int n) {
        int start = 1, end = n, ret = n;
        while (start <= end) {
            int mid = (end + start) / 2;
            if (isBadVersion(mid)) {
                ret = mid;
                end = mid - 1;
            } else {
                ret = start + 1;
                start = start + 1;
            }
        }

        return ret;
    }

    private boolean isBadVersion(int n) {
        return n >= 4;
    }

    public static void main(String[] args) {
        FirstBadVersion main = new FirstBadVersion();
        System.out.println(main.firstBadVersion(6));
    }
}
