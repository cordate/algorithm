/**
 * cordate.com gavin
 * Copyright (c) 2019-2021 All Rights Reserved
 */
package com.gavin.common.graph;

import java.util.*;

/**
 * @author gavin
 * @version $Id: NodeUtil.java, v 1.0 2021年11月13日 上午11:59 gavinzhang copyright $
 */
public class NodeUtil {
    public static Node build(int[][] nodes) {
        Node[] ns = new Node[nodes.length];
        for (int i = 0; i < nodes.length; i++) {
            ns[i] = new Node(i+1);
        }

        for (int i = 0; i < nodes.length; i++) {
            Node cur = ns[i];
            for (int n : nodes[i]) {
                cur.neighbors.add(ns[n-1]);
            }
        }

        return ns[0];
    }

    public static void print(Node node) {
        Set<Node> visited = new HashSet<>();
        List<Node> tmp = new ArrayList<>();
        tmp.add(node);
        while (!tmp.isEmpty()) {
            List<Node> next = new ArrayList<>();
            for (Node n : tmp) {
                if (visited.contains(n)) {
                    continue;
                }
                visited.add(n);
                next.addAll(n.neighbors);
            }
            tmp = next;
        }
        System.out.print("[");
        Node[] list = visited.toArray(new Node[]{});
        Arrays.sort(list, (o1, o2) -> (o1.val > o2.val) ? 1 : (o1.val == o2.val) ? 0 : -1);
        for (int i = 0; i < list.length; i++) {
            System.out.print("[");
            for (Node n : list[i].neighbors) {
                if (n == list[i].neighbors.get(list[i].neighbors.size()-1)) {
                    System.out.print(n.val);
                } else
                    System.out.print(n.val + ",");
            }
            System.out.print(i==visited.size()-1? "]" : "],");
        }
        System.out.print("]");
    }

    public static void main(String[] args) {
        Node node = build(new int[][] {{2,4},{1,3},{2,4},{1,3}});
        print(node);
    }
}