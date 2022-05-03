/**
 * cordate.com gavin
 * Copyright (c) 2019-2022 All Rights Reserved
 */
package com.gavin.thought.binarySearchTree;

import com.gavin.common.tree.TreeNode;
import com.gavin.common.tree.TreeUtil;

/**
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 * 二叉树的中序遍历就是有序的结果
 *
 * @author gavin
 * @version $Id: ValidateBinarySearchTree.java, v 1.0 2022年05月03日 12:55 AM apple copyright $
 */
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, int min, int max) {
        if (root == null) return true;
        if (root.val <= min || root.val >= max) {
            return false;
        }
        return isValidBST(root.left, min, root.val)
                && isValidBST(root.right, root.val, max);
    }

    public static void main(String[] args) {
        ValidateBinarySearchTree main = new ValidateBinarySearchTree();
        System.out.println(main.isValidBST(TreeUtil.build("2,1,3")));
        System.out.println(main.isValidBST(TreeUtil.build("5,1,4,null,null,3,6")));
    }
}
