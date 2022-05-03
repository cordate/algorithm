/**
 * cordate.com gavin
 * Copyright (c) 2019-2022 All Rights Reserved
 */
package com.gavin.thought.binarySearchTree;

import com.gavin.common.tree.TreeNode;
import com.gavin.common.tree.TreeUtil;

/**
 * https://leetcode-cn.com/problems/delete-node-in-a-bst/
 *
 * @author gavin
 * @version $Id: DeleteNodeInABst.java, v 1.0 2022年05月03日 1:04 AM apple copyright $
 */
public class DeleteNodeInABst {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            return delete(root);
        }

        return root;
    }

    private TreeNode delete(TreeNode root) {
        if (root.left == null) {
            return root.right;
        }
        if (root.right == null) {
            return root.left;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        root = left;
        while (left.right != null) {
            left = left.right;
        }
        left.right = right;
        return root;
    }

    public static void main(String[] args) {
        DeleteNodeInABst main = new DeleteNodeInABst();
        TreeUtil.println(main.deleteNode(TreeUtil.build("5,3,6,2,4,null,7"), 3));
        TreeUtil.println(main.deleteNode(TreeUtil.build("5,3,6,2,4,null,7"), 0));
        TreeUtil.println(main.deleteNode(TreeUtil.build("5,3,6,2,4,null,7"), 5));
    }
}
