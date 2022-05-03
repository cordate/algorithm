/**
 * cordate.com gavin
 * Copyright (c) 2019-2022 All Rights Reserved
 */
package com.gavin.other.lfu.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/lru-cache/
 * 挺有意思的题目，这里要特别注意题目的说明
 *  1. 双向链表：头和尾都有空余节点
 *  2. capacity到达容量要进行删除处理
 *  3. 删除时，如果put已经存在的不用删除，否则需要删除
 * @author gavin
 * @version $Id: MyLru.java, v 1.0 2022年05月03日 4:39 PM apple copyright $
 */
public class MyLru {
    public Node head;
    public Node tail;
    public int capacity;
    public Map<Integer, Node> data;

    public MyLru(int capacity) {
        this.capacity = capacity;
        data = new HashMap<>(capacity);
    }

    public int get(int key) {
        int val = data.get(key).value;
        Node node = data.get(key);
        if (node.prev == null) {
            // 头结点不处理
            return val;
        }
        head.prev = node;
        node.prev.next = node.next;
        node.next = head;
        node.prev = null;

        return val;
    }

    public void put(int key, int value) {
        Node node = new Node(key, value);
        data.put(key, node);
        if (head == null) {
            head = node;
            tail = node;
            return;
        }
        node.next = head;
        head.prev = node;
        head = node;
    }

    public static void main(String[] args) {
        MyLru lru = new MyLru(2);
        lru.put(1,1);
        lru.put(2,2);
        lru.get(1);
        lru.put(3,3);
    }
}


