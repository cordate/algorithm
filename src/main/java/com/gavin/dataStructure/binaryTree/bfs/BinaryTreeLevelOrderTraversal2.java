package com.gavin.dataStructure.binaryTree.bfs;

import com.alibaba.fastjson.JSON;
import com.gavin.common.tree.TreeNode;
import com.gavin.common.tree.TreeUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
 *
 * @author gavin
 */
public class BinaryTreeLevelOrderTraversal2 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        List<List<Integer>> result = new ArrayList<>();
        while(!q.isEmpty()) {
            int n = q.size();
            List<Integer> tmp = new ArrayList<>();
            while (n > 0) {
                TreeNode c = q.poll();
                tmp.add(c.val);
                if (c.left != null) {
                    q.offer(c.left);
                }
                if (c.right != null) {
                    q.offer(c.right);
                }
                n--;
            }
            result.add(0, tmp);
        }

        return result;
    }

    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversal2 main = new BinaryTreeLevelOrderTraversal2();
        System.out.println(JSON.toJSONString(main.levelOrderBottom(TreeUtil.build("3,9,20,null,null,15,7"))));
    }
}
