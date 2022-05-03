/**
 * cordate.com gavin
 * Copyright (c) 2019-2022 All Rights Reserved
 */
package com.gavin.dataStructure.stackQueue.stack;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 * 这题思路比较简单，基于栈找出局部最大，最后得出最大的值
 * 这也算是贪心算法
 *
 * 这题的官方解法跟我的写法不同，这里实现的过程中不熟练，还要再练习
 *
 * 官方的解法比较容易理解，就是当前节点的高度向左扩展能扩展多远left[i]，
 * 向右扩展能扩展多远right[i]，最后以这个节点能产生的最大矩形面积(right[i]-left[i] - 1) * heights[i]
 * 这里不是加1是因为多扩展边界1次才达到停止条件
 *
 * @author gavin
 * @version $Id: LargestRectangleInHistogram.java, v 1.0 2022年04月12日 2:37 PM apple copyright $
 */
public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        // 单调递增栈
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= heights.length; i++) {
            // -1 是加的哨兵
            int height = i == heights.length ? -1 : heights[i];
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                if (height > heights[stack.peek()]) {
                    stack.push(i);
                } else {
                    // 单调栈回归
                    while (!stack.isEmpty() && heights[stack.peek()] >= height) {
                        int index = stack.pop();
                        // 这里每次都要进行比较，可能最大值就在这里面出现
                        if (stack.isEmpty()) {
                            // 这里比较容易遗漏，就是最后一个是最矮值，可以向前扩展
                            max = Math.max(max, i * heights[index]);
                        } else {
                            max = Math.max(max, (i - index) * heights[index]);
                        }
                    }
                    stack.push(i);
                }
            }
            stack.push(i);
        }

        return max;
    }

    public static void main(String[] args) {
        LargestRectangleInHistogram main = new LargestRectangleInHistogram();
        System.out.println(main.largestRectangleArea(new int[] {2,1,5,6,2,3}));

        System.out.println(main.largestRectangleArea(new int[] {2,4}));
    }
}
