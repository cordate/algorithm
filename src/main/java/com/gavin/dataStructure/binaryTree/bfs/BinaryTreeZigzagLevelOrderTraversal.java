package com.gavin.dataStructure.binaryTree.bfs;

import com.alibaba.fastjson.JSON;
import com.gavin.common.tree.TreeNode;
import com.gavin.common.tree.TreeUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
 *
 * @author gavin
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean order = true;
        List<List<Integer>> result = new ArrayList<>();
        while(!q.isEmpty()) {
            int n = q.size();
            List<Integer> tmp = new ArrayList<>();
            while (n > 0) {
                TreeNode c = q.poll();
                if (order) {
                    tmp.add(c.val);
                } else {
                    tmp.add(0, c.val);
                }
                if (c.left != null) {
                    q.offer(c.left);
                }
                if (c.right != null) {
                    q.offer(c.right);
                }
                n--;
            }
            order = !order;
            result.add(tmp);
        }

        return result;
    }

    public static void main(String[] args) {
        BinaryTreeZigzagLevelOrderTraversal main = new BinaryTreeZigzagLevelOrderTraversal();
        System.out.println(JSON.toJSONString(main.zigzagLevelOrder(TreeUtil.build("3,9,20,null,null,15,7"))));
    }
}
