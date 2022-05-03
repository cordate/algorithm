/**
 * cordate.com gavin
 * Copyright (c) 2019-2022 All Rights Reserved
 */
package com.gavin.baseAlgorithm.dp;

import com.gavin.common.util.ArrayUtil;

import java.util.List;

/**
 * https://leetcode-cn.com/problems/triangle/
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 *
 * @author gavin
 * @version $Id: Triangle.java, v 1.0 2022年04月20日 1:41 AM apple copyright $
 */
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int[][] dp = new int[m][m];
        // 初始化
        for (int i=0; i < triangle.get(0).size(); i++) {
            dp[0][i] = triangle.get(0).get(i);
        }
        // 动态规划
        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (j == triangle.get(i).size() -1) {
                    dp[i][j] = dp[i-1][j-1] + triangle.get(i).get(j);
                    continue;
                }
                dp[i][j] = dp[i-1][j] + triangle.get(i).get(j);
                if (j > 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1] + triangle.get(i).get(j));
                }
            }
        }

        int ret = 90000000;
        for (int s : dp[m-1]) {
            ret = Math.min(ret, s);
        }
        return ret;
    }

    /**
     * 这个解法比较简单，处理起来很好理解，就是一颗树
     * @param triangle
     * @return
     */
    public int minimumTotal2(List<List<Integer>> triangle) {
        return dfs(triangle, 0, 0);
    }

    public int dfs(List<List<Integer>> triangle, int x, int y) {
        if (x>=triangle.size()) return 0;
        int ret = triangle.get(x).get(y);
        int left = dfs(triangle, x+1, y);
        int right = dfs(triangle, x+1, y+1);
        ret+=Math.min(left, right);
        return ret;
    }

    public static void main(String[] args) {
        Triangle main = new Triangle();
        System.out.println(main.minimumTotal2(ArrayUtil.build(new int[][]{{2},{3,4},{6,5,7},{4,1,8,3}})));
    }
}
