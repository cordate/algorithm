/**
 * cordate.com gavin
 * Copyright (c) 2019-2022 All Rights Reserved
 */
package com.gavin.dataStructure.stackQueue.queue;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/number-of-islands/
 * 岛屿查找，按照上面的解题思路
 *    1. 递归处理
 *    2. 基于Queue的广度优先
 *
 * @author gavin
 * @version $Id: NumberOfIslands.java, v 1.0 2022年04月12日 1:42 PM apple copyright $
 */
public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ret = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    ret += 1;
                    // dfs(grid, i, j);
                    bfs(grid, i, j);
                }
            }
        }
        return ret;
    }

    public void bfs(char[][] grid, int i, int j) {
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        q.offer(new Pair<>(i, j));
        while (!q.isEmpty()) {
            Pair<Integer, Integer> cur = q.poll();
            int x = cur.getKey(), y = cur.getValue();
            grid[x][y] = '0';
            // 向右移动
            if (x+1 < grid.length && grid[x+1][y]=='1') {
                q.offer(new Pair<>(x+1, y));
            }
            if (x-1 >= 0 && grid[x-1][y]=='1') {
                q.offer(new Pair<>(x-1, y));
            }
            // 向下移动
            if (y+1 < grid[0].length && grid[x][y+1]=='1') {
                q.offer(new Pair<>(x, y+1));
            }
            if (y-1 >= 0 && grid[x][y-1]=='1') {
                q.offer(new Pair<>(x, y-1));
            }
        }
    }

    /**
     * 这里是使用递归实现的dfs，但是如果使用stack实现递比较麻烦，因为有4个方向
     * 如果是两个方向，使用递归实现就比较简单了
     * 4个方向需要有额外的空间记录已经走过的方向。
     * 如果是两个方向，进栈一个方向，出栈赋值另一个方向即可
     *
     * @param grid
     * @param x
     * @param y
     */
    public void dfs(char[][] grid, int x, int y) {
        grid[x][y] = '0';
        // 向右移动
        if (x+1 < grid.length && grid[x+1][y]=='1') {
            dfs(grid, x+1, y);
        }
        if (x-1 >= 0 && grid[x-1][y]=='1') {
            dfs(grid, x-1, y);
        }
        // 向下移动
        if (y+1 < grid[0].length && grid[x][y+1]=='1') {
            dfs(grid, x, y+1);
        }
        if (y-1 >= 0 && grid[x][y-1]=='1') {
            dfs(grid, x, y-1);
        }
    }

    public static void main(String[] args) {
        NumberOfIslands main = new NumberOfIslands();
        System.out.println(main.numIslands(new char[][]{
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        }));

        System.out.println(main.numIslands(new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        }));
    }
}
