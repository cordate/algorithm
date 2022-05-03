package com.gavin.dataStructure.binaryTree;

import com.gavin.common.tree.TreeNode;
import com.gavin.common.tree.TreeUtil;

/**
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 *
 * @author gavin
 */
public class LowestCommonAncestorOfABinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        } else if (left!=null) {
            return left;
        } else {
            return right;
        }
    }

    public static void main(String[] args) {
        TreeNode node = TreeUtil.build("3,5,1,6,2,0,8,null,null,7,4");
        TreeNode p = TreeUtil.find(node, 5);
        TreeNode q = TreeUtil.find(node, 1);

        LowestCommonAncestorOfABinaryTree main = new LowestCommonAncestorOfABinaryTree();
        System.out.println(main.lowestCommonAncestor(node, p, q).val);
    }
}
