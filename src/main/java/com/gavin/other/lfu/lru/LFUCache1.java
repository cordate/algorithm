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
public class LFUCache1 {
    public Map<Integer, LfuNode1> map;
    public int capacity;
    public LfuNode1 head, tail;

    public LFUCache1(int capacity) {
        map = new HashMap<>(capacity);
        head = new LfuNode1(null, null);
        tail = new LfuNode1(null, null);
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
    }

    public int get(int key) {
        LfuNode1 node = map.get(key);
        if (node == null) {
            return -1;
        }
        node.visit++;
        node.moveTo();
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;
        LfuNode1 node = map.get(key);
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

class LfuNode1 {
    public Integer key;
    public Integer value;
    public int visit = 0;
    public long visitTime = System.nanoTime();
    public LfuNode1 next;
    public LfuNode1 prev;

    public LfuNode1(Integer key, Integer v) {
        this.value = v;
        this.key = key;
    }

    public LfuNode1 insertAfter(int key, int v) {
        LfuNode1 next = this.next;
        LfuNode1 n = new LfuNode1(key, v);
        this.next = n;
        n.next = next;
        next.prev = n;
        n.next = this;
        return n;
    }

    public LfuNode1 insertAheand(int key, int v) {
        LfuNode1 prev = this.prev;
        LfuNode1 n = new LfuNode1(key, v);
        prev.next = n;
        n.next = this;
        this.prev = n;
        n.prev = prev;
        return n;
    }

    public void remove() {
        LfuNode1 next = this.next;
        LfuNode1 prev = this.prev;
        next.prev = prev;
        prev.next = next;
    }

    public void moveTo() {
        LfuNode1 prev = this.prev;
        while (prev.key!= null && prev.visit <= this.visit) {
            prev = prev.prev;
        }
        this.remove();
        LfuNode1 next = prev.next;
        prev.next = this;
        this.next = next;
        next.prev = this;
        this.prev = prev;
    }
}