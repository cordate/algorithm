package com.gavin.dataStructure.binaryTree.bfs;

import com.alibaba.fastjson.JSON;
import com.gavin.common.tree.TreeNode;
import com.gavin.common.tree.TreeUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 *
 * @author gavin
 */
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
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
            result.add(tmp);
        }

        return result;
    }

    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversal main = new BinaryTreeLevelOrderTraversal();
        System.out.println(JSON.toJSONString(main.levelOrder(TreeUtil.build("3,9,20,null,null,15,7"))));
    }
}
