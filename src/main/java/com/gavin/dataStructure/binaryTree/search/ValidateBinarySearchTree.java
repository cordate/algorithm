package com.gavin.dataStructure.binaryTree.search;

import com.gavin.common.tree.TreeNode;
import com.gavin.common.tree.TreeUtil;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 * 是不是二叉搜索树的判断
 *
 * @author gavin
 */
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return isValidBst(root, null, null);
    }

    public boolean isValidBst(TreeNode root, Integer max, Integer min) {
        if (root==null) return true;
        if (max != null && root.val >= max) return false;
        if (min != null && root.val <= min) return false;

        return isValidBst(root.left, root.val, min)
                && isValidBst(root.right, max, root.val);
    }

    public static void main(String[] args) {
        ValidateBinarySearchTree2 main = new ValidateBinarySearchTree2();
        System.out.println(main.isValidBST(TreeUtil.build("5,1,4,null,null,3,6")));
    }
}

/**
 * 中序遍历，按照这个流程进行处理
 * 注意这种解法，容易忘记
 */
class ValidateBinarySearchTree2 {
    public boolean isValidBST(TreeNode root) {
        Deque<TreeNode> s = new LinkedList<>();
        int order = Integer.MIN_VALUE;
        while (root != null || !s.isEmpty()) {
            while (root != null) {
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            if (root.val < order) return false;
            order = root.val;
            root = root.right;
        }

        return true;
    }
}
