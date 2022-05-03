package com.gavin.thought.binarySearchTree;

import com.gavin.common.tree.TreeNode;
import com.gavin.common.tree.TreeUtil;

/**
 * https://leetcode-cn.com/problems/insert-into-a-binary-search-tree/
 * 插入一颗平衡二叉树
 *
 * @author gavin
 */
public class InsertIntoABinarySearchTree {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (root.val < val) {
            root.right = insertIntoBST(root.right, val);
        } else {
            root.left = insertIntoBST(root.left, val);
        }

        return root;
    }

    public static void main(String[] args) {
        InsertIntoABinarySearchTree main = new InsertIntoABinarySearchTree();
        TreeNode root = main.insertIntoBST(TreeUtil.build("40,20,60,10,30,50,70"), 25);
        TreeUtil.println(root);
    }
}
