/**
 * cordate.com gavin
 * Copyright (c) 2019-2022 All Rights Reserved
 */
package com.gavin.dataStructure.stackQueue.queue;

import com.gavin.common.graph.Node;
import com.gavin.common.graph.NodeUtil;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/clone-graph/
 * 给你无向 连通 图中一个节点的引用，请你返回该图的 深拷贝（克隆）。
 *
 * 这题有两种解法（其实就是树的遍历）：
 *    1. 递归式的深度优先
 *    2. 基于队列的广度优先(没想起来)
 *
 * @author gavin
 * @version $Id: CloneGraph.java, v 1.0 2022年04月12日 0:45 AM apple copyright $
 */
public class CloneGraph {
    private Map<Node, Node> map = new HashMap<>();

    /**
     * 这里也可以使用stack，而非递归实现dfs。
     * 但是同样的问题，方向很多，需要中间值记录已经走过的方向
     *
     * @param node
     * @return
     */
    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }

        Node n = map.get(node);
        if (n == null) {
            n = new Node(node.val);
            map.put(node, n);
            if (node.neighbors != null && !node.neighbors.isEmpty()) {
                for (Node neighbor : node.neighbors) {
                    n.neighbors.add(cloneGraph(neighbor));
                }
            }
        }

        return n;
    }

    public static void main(String[] args) {
        CloneGraph2 main = new CloneGraph2();
        NodeUtil.print(main.cloneGraph(NodeUtil.build(new int[][]{{2,4},{1,3},{2,4},{1,3}})));
    }
}

/**
 * 基于队列的广度优先处理(模式学习)
 */
class CloneGraph2 {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }
        Map<Node, Node> map = new HashMap<>();

        Queue<Node> q = new LinkedList<>();
        map.put(node, new Node(node.val));
        q.offer(node);

        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (cur.neighbors != null && !cur.neighbors.isEmpty()) {
                for (Node neighbor : cur.neighbors) {
                    Node n = map.get(neighbor);
                    if (n == null) {
                        n = new Node(neighbor.val);
                        map.put(neighbor, n);
                        q.offer(neighbor);
                    }
                    map.get(cur).neighbors.add(n);
                }
            }
        }

        return map.get(node);
    }
}
