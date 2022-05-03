package com.gavin.dataStructure.binaryTree;

import com.gavin.common.tree.TreeNode;
import com.gavin.common.tree.TreeUtil;

/**
 * https://leetcode-cn.com/problems/balanced-binary-tree/
 * 判断是不是平衡二叉树，这也是一个简单题
 *
 * @author gavin
 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if (root==null) return true;
        if (Math.abs(height(root.left) - height(root.right)) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int height(TreeNode root) {
        if (root == null) return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    public static void main(String[] args) {
        BalancedBinaryTree2 main = new BalancedBinaryTree2();
        System.out.println(main.isBalanced(TreeUtil.build("3,9,20,null,null,15,7")));
        System.out.println(main.isBalanced(TreeUtil.build("1,2,2,3,3,null,null,4,4")));
    }
}

/**
 * 这个是自底向上的写法，好好学习一番
 *
 * 这里主要是用于传中间值进行处理，自底向上都是这样处理的，包括找公共的父节点这样的题目
 */
class BalancedBinaryTree2 {
    public boolean isBalanced(TreeNode root) {
        if (root==null) return true;
        if (Math.abs(height(root.left) - height(root.right)) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int height(TreeNode root) {
        if (root==null) return 0;
        int leftH = height(root.left);
        int rightH = height(root.right);
        if (leftH == -1 || rightH == -1 || Math.abs(leftH - rightH) > 1) {
            return -1;
        } else {
            return Math.max(rightH, leftH) + 1;
        }
    }
}
