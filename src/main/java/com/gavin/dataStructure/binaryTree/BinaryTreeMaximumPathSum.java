package com.gavin.dataStructure.binaryTree;

import com.gavin.common.tree.TreeNode;
import com.gavin.common.tree.TreeUtil;

/**
 * https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
 * 二叉树中的最大路径和, 这是一道困难的题目，难度在于不一定经过根节点
 * 也就是求局部最大
 *
 * @author gavin
 */
public class BinaryTreeMaximumPathSum {
    public int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        int left = maxPathSum(root.left);
        int right = maxPathSum(root.right);
        max = Math.max(left+right + root.val, max);

        return Math.max(left + root.val, Math.max(right+ root.val, root.val));
    }

    public static void main(String[] args) {
        BinaryTreeMaximumPathSum main = new BinaryTreeMaximumPathSum();
        main.maxPathSum(TreeUtil.build("-10,9,20,null,null,15,7"));
        System.out.println(main.max);
    }
}
