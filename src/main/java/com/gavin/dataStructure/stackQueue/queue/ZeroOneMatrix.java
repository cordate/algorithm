/**
 * cordate.com gavin
 * Copyright (c) 2019-2022 All Rights Reserved
 */
package com.gavin.dataStructure.stackQueue.queue;

import com.gavin.common.util.ArrayUtil;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/01-matrix/
 * 给定一个由 0 和 1 组成的矩阵 mat ，请输出一个大小相同的矩阵，其中每一个格子是 mat 中对应位置元素到最近的 0 的距离。
 *
 * 简单题，以0为起点向四周扩展，基于queue所做的动态规划，动态停止条件是queue为空
 * 其他解法也类似，可以看看
 *
 * @author gavin
 * @version $Id: ZeroOneMatrix.java, v 1.0 2022年04月13日 1:37 AM apple copyright $
 */
public class ZeroOneMatrix {
    public int[][] updateMatrix(int[][] mat) {
        if (mat==null || mat.length==0) return mat;
        int m = mat.length, n = mat[0].length;
        int[][] ret = new int[m][n];
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j]==0) {
                    ret[i][j] = 0;
                    q.offer(new int[]{i, j});
                } else {
                    ret[i][j] = -1;
                }
            }
        }

        while (!q.isEmpty()) {
            int[] s = q.poll();
            int x = s[0];
            int y = s[1];
            if (x > 0 && ret[x-1][y]==-1) {
                q.offer(new int[]{x-1, y});
                ret[x-1][y] = ret[x][y] + 1;
            }
            if (y > 0 && ret[x][y-1]==-1) {
                q.offer(new int[]{x, y-1});
                ret[x][y-1] = ret[x][y] + 1;
            }
            if (x < mat.length-1 && ret[x+1][y]==-1) {
                q.offer(new int[]{x+1, y});
                ret[x+1][y] = ret[x][y] + 1;
            }
            if (y < mat[0].length -1 && ret[x][y+1]==-1) {
                q.offer(new int[]{x, y+1});
                ret[x][y+1] = ret[x][y] + 1;
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        ZeroOneMatrix main = new ZeroOneMatrix();
        ArrayUtil.print(main.updateMatrix(new int[][]{
                {0,0,0},{0,1,0},{0,0,0}
        }));
        ArrayUtil.print(main.updateMatrix(new int[][]{
                {0,0,0},{0,1,0},{1,1,1}
        }));
    }
}
