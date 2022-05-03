/**
 * cordate.com gavin
 * Copyright (c) 2019-2022 All Rights Reserved
 */
package com.gavin.other.lfu.lru;

/**
 * @author gavin
 * @version $Id: Node.java, v 1.0 2022年05月03日 5:19 PM apple copyright $
 */
class Node {
    public Integer key;
    public Integer value;
    public Node next;
    public Node prev;

    public Node(Integer key, Integer value) {
        this.key = key;
        this.value = value;
    }

    public boolean remove() {
        Node next = this.next;
        Node prev = this.prev;
        prev.next = next;
        next.prev = prev;
        return true;
    }

    public Node insertAhead(Integer key, Integer value) {
        Node prev = this.prev;
        Node n = new Node(key, value);
        prev.next = n;
        n.next = this;
        this.prev = n;
        n.prev = prev;
        return n;
    }

    public Node insertAfter(Integer key, Integer value) {
        Node next = this.next;
        Node n = new Node(key, value);
        this.next = n;
        n.next = next;
        next.prev = n;
        n.prev = this;
        return n;
    }

    public boolean moveTop(Node root) {
        remove();
        Node next = root.next;
        root.next = this;
        this.next = next;
        next.prev = this;
        this.prev = root;
        return true;
    }
}
