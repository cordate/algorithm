/**
 * cordate.com gavin
 * Copyright (c) 2019-2021 All Rights Reserved
 */
package com.gavin.other.lfu.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gavin
 * @version $Id: LFUCache1.java, v 1.0 2021年11月14日 下午8:55 gavinzhang copyright $
 */
public class LFUCache {
    public Map<Integer, LfuNode> map;
    public int capacity;
    public LfuNode head, tail;

    public LFUCache(int capacity) {
        map = new HashMap<>(capacity);
        head = new LfuNode(null, null);
        tail = new LfuNode(null, null);
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
    }

    public int get(int key) {
        LfuNode node = map.get(key);
        if (node == null) {
            return -1;
        }
        node.visit++;
        node.moveTo();
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;
        LfuNode node = map.get(key);
        if (node == null) {
            if (map.size() == capacity) {
                map.remove(tail.prev.key);
                tail.prev.remove();
            }
            tail.insertAheand(key, value);
            tail.prev.moveTo();
            map.put(key, tail.prev);
        } else {
            node.value = value;
            node.visit++;
            node.moveTo();
        }
    }
}

class LfuNode {
    public Integer key;
    public Integer value;
    public int visit = 0;
    public long visitTime = System.nanoTime();
    public LfuNode next;
    public LfuNode prev;

    public LfuNode(Integer key, Integer v) {
        this.value = v;
        this.key = key;
    }

    public LfuNode insertAfter(int key, int v) {
        LfuNode next = this.next;
        LfuNode n = new LfuNode(key, v);
        this.next = n;
        n.next = next;
        next.prev = n;
        n.next = this;
        return n;
    }

    public LfuNode insertAheand(int key, int v) {
        LfuNode prev = this.prev;
        LfuNode n = new LfuNode(key, v);
        prev.next = n;
        n.next = this;
        this.prev = n;
        n.prev = prev;
        return n;
    }

    public void remove() {
        LfuNode next = this.next;
        LfuNode prev = this.prev;
        next.prev = prev;
        prev.next = next;
    }

    public void moveTo() {
        LfuNode prev = this.prev;
        while (prev.key!= null && prev.visit <= this.visit) {
            prev = prev.prev;
        }
        this.remove();
        LfuNode next = prev.next;
        prev.next = this;
        this.next = next;
        next.prev = this;
        this.prev = prev;
    }
}