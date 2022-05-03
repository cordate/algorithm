/**
 * cordate.com gavin
 * Copyright (c) 2019-2022 All Rights Reserved
 */
package com.gavin.common.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gavin
 * @version $Id: ArrayUtil.java, v 1.0 2022年04月13日 0:38 AM apple copyright $
 */
public class ArrayUtil {
    /**
     * 将二维数组转化为列表
     * @param arr
     * @return
     */
    public static List<List<Integer>> build(int[][] arr) {
        List<List<Integer>> ret = new ArrayList<>();
        for (int[] nums : arr) {
            List<Integer> tmp = new ArrayList<>();
            for (int item : nums) {
                tmp.add(item);
            }
            ret.add(tmp);
        }

        return ret;
    }

    public static void print(int[][] arr) {
        System.out.println("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print("   [");
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j]);
                if (j < arr[0].length - 1) {
                    System.out.print(", ");
                }
            }
            if (i < arr.length -1) {
                System.out.println("],");
            } else {
                System.out.println("]");
            }
        }
        System.out.println("]");
    }

    public static void print(Object[] arr) {
        System.out.println("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length -1) {
                System.out.println(", ");
            }
        }
        System.out.println("]");
    }
}
