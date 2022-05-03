/**
 * cordate.com gavin
 * Copyright (c) 2019-2022 All Rights Reserved
 */
package com.gavin.dataStructure.stackQueue.stack;

import com.alibaba.fastjson.JSON;
import com.gavin.common.tree.TreeNode;
import com.gavin.common.tree.TreeUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 * 递归是常规做法，这里使用非递归实现，注意这题还有第三种解法，值得学习
 * @author gavin
 * @version $Id: BinaryTreeInorderTraversal.java, v 1.0 2022年04月12日 0:24 AM apple copyright $
 */
public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            ret.add(root.val);
            if (root.right != null) {
                root = root.right;
            } else {
                root = null;
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        BinaryTreeInorderTraversal main = new BinaryTreeInorderTraversal();
        // TreeNode root = TreeUtil.build("3,9,20,null,null,15,7");
        TreeNode root = TreeUtil.build("3,9,20,null,null,15,7");
        System.out.println(JSON.toJSONString(main.inorderTraversal(root)));
    }
}
