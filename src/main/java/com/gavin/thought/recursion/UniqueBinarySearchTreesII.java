/**
 * cordate.com gavin
 * Copyright (c) 2019-2022 All Rights Reserved
 */
package com.gavin.thought.recursion;

import com.gavin.common.tree.TreeNode;
import com.gavin.common.tree.TreeUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/unique-binary-search-trees-ii/
 * 给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。
 *
 * @author gavin
 * @version $Id: UniqueBinarySearchTreesII.java, v 1.0 2022年05月02日 8:59 PM apple copyright $
 */
public class UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        return generateTrees(n, 1);
    }

    public List<TreeNode> generateTrees(int max, int min) {
        if (max < min) return null;

        List<TreeNode> treeNodes = new ArrayList<>();
        if (min == max) {
            treeNodes.add(new TreeNode(max));
            return treeNodes;
        }

        for (int i = min; i <= max; i++) {
            List<TreeNode> leftList = generateTrees(i-1, min);
            List<TreeNode> rightList = generateTrees(max, i+1);
            treeNodes.addAll(merge(i, leftList, rightList));
        }

        return treeNodes;
    }

    private List<TreeNode> merge(int i, List<TreeNode> leftList, List<TreeNode> rightList) {
        List<TreeNode> treeNodes = new ArrayList<>();

        if (leftList == null && rightList == null) {
            return null;
        } else if (rightList != null && leftList != null) {
            for (TreeNode left : leftList) {
                for (TreeNode right : rightList) {
                    TreeNode cur = new TreeNode(i);
                    cur.left = left;
                    cur.right = right;
                    treeNodes.add(cur);
                }
            }
        } else if (leftList != null) {
            for (TreeNode left : leftList) {
                TreeNode cur = new TreeNode(i);
                cur.left = left;
                treeNodes.add(cur);
            }
        } else {
            for (TreeNode right : rightList) {
                TreeNode cur = new TreeNode(i);
                cur.right = right;
                treeNodes.add(cur);
            }
        }

        return treeNodes;
    }

    public static void main(String[] args) {
        UniqueBinarySearchTreesII main = new UniqueBinarySearchTreesII();
        List<TreeNode> result = main.generateTrees(3);
        for (TreeNode tree : result) {
            TreeUtil.println(tree);
        }
    }
}
