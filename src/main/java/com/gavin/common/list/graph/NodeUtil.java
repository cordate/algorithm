/**
 * cordate.com gavin
 * Copyright (c) 2019-2021 All Rights Reserved
 */
package com.gavin.common.list.graph;

import java.util.HashMap;
import java.util.Map;

/**
 * 节点工具类
 * @author gavin
 * @version $Id: NodeUtil.java, v 1.0 2022年11月13日 上午11:59 gavinzhang copyright $
 */
public class NodeUtil {
    public static Node build(Integer[][] nodes) {
        Node[] ns = new Node[nodes.length];

        for (int i = 0; i < nodes.length; i++) {
            ns[i] = new Node(nodes[i][0]);
            // 链表建立
            if (i > 0) {
                ns[i-1].next = ns[i];
            }
        }

        for (int i = 0; i < nodes.length; i++) {
            Node cur = ns[i];
            if (nodes[i][1] == null) {
                continue;
            }
            cur.random = ns[nodes[i][1]];
        }

        return ns[0];
    }

    public static void print(Node node) {
        // 建立索引
        int i = 0;
        Node cur = node;
        Map<Node, Integer> map = new HashMap<>();
        while (cur != null) {
            map.put(cur, i);
            cur = cur.next;
            i++;
        }
        // 开始打印
        System.out.print("[");
        while (node != null) {
            System.out.print("[" + node.val + "," +
                    (node.random==null ? "null" : map.get(node.random)) + "]");
            if (node.next != null) {
                System.out.print(", ");
            }
            node = node.next;
        }
        System.out.print("]");
    }

    public static void main(String[] args) {
        Node node = build(new Integer[][] {{2,3},{1,1},{2,1},{1,2}});
        print(node);
    }
}