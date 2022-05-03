/**
 * cordate.com gavin
 * Copyright (c) 2019-2021 All Rights Reserved
 */
package com.gavin.other.lfu.lru;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/lru-cache/submissions/
 * 挺有意思的题目，这里要特别注意题目的说明
 *  * 双向链表：头和尾都有空余节点
 *  * capacity到达容量要进行删除处理
 *  * 删除时，如果put已经存在的不用删除，否则需要删除
 * @author gavin
 * @version $Id: MyLru.java, v 1.0 2021年11月14日 下午7:37 gavinzhang copyright $
 */
public class MyLru2 {
    private HashMap<Integer, Node> map;
    private Node root;
    private Node tail;
    private int capacity;

    public MyLru2(int capacity) {
        map = new HashMap<>(capacity);
        root = new Node(null, null);
        tail = new Node(null, null);
        root.next = tail;
        tail.prev = root;
        this.capacity = capacity;
    }

    public Integer get(Integer key) {
        Node cur = map.get(key);
        // 判空容易遗忘
        if (cur==null) return -1;
        // 关键就是移动到头部
        cur.moveTop(root);
        return cur.value;
    }

    public void put(Integer key, Integer value) {
        // 先校验是否存在
        if (map.get(key) == null) {
            // 再来校验是否满了
            if (map.size() >= capacity) {
                // 满了删除
                map.remove(tail.prev.key);
                tail.prev.remove();
            }
            //再在头部插入一条新的
            map.put(key, root.insertAfter(key, value));
            return;
        } else {
            map.get(key).value = value;
            // 存在就移动到头部
            map.get(key).moveTop(root);
        }
    }

    public static void main(String[] args) {
        MyLru lru = new MyLru(2);
        lru.put(1,1);
        lru.put(2,2);
        lru.get(1);
        lru.put(3,3);
    }
}