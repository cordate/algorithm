package com.gavin.dataStructure.binaryTree;

import com.gavin.common.tree.TreeNode;
import com.gavin.common.tree.TreeUtil;

/**
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 * 这是一个简单题
 *
 * 这题的解题思想就是分治法（递归实现）
 *
 * @author gavin
 */
public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public static void main(String[] args) {
        MaximumDepthOfBinaryTree main = new MaximumDepthOfBinaryTree();
        System.out.println(main.maxDepth(TreeUtil.build("3,9,20,null,null,15,7")));
    }
}
