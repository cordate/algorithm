/**
 * cordate.com gavin
 * Copyright (c) 2019-2022 All Rights Reserved
 */
package com.gavin.baseAlgorithm.binarySearch;

/**
 * https://leetcode-cn.com/problems/search-a-2d-matrix/
 * 这题可以做两次二分法也可以使用一次二分法查找完成
 * @author gavin
 * @version $Id: SearchA2dMatrix.java, v 1.0 2022年04月14日 2:38 AM apple copyright $
 */
public class SearchA2dMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int len = matrix[0].length * matrix.length;
        int start = 0, end = len - 1;
        while (start <= end) {
            int mid = (end + start) / 2;
            if (get(matrix, mid) == target) {
                return true;
            } else if (get(matrix, mid) < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return false;
    }

    public int get(int[][] matrix, int index) {
        int x = index / matrix[0].length;
        int y = index % matrix[0].length;
        return matrix[x][y];
    }

    public static void main(String[] args) {
        SearchA2dMatrix main = new SearchA2dMatrix();
        System.out.println(main.searchMatrix(new int[][]{
                {1,3,5,7},
                {10,11,16,20},
                {23,30,34,60}
        }, 3));
    }
}
