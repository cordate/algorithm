package com.gavin.common.list.graph;

/**
 * Node 链表带随机节点的图
 *
 * @author gavin
 */
public class Node {
    public int val;
    public Node next;
    public Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
