/**
 * cordate.com gavin
 * Copyright (c) 2019-2021 All Rights Reserved
 */
package com.gavin.common.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gavin
 * @version $Id: Node.java, v 1.0 2021年11月13日 上午11:57 gavinzhang copyright $
 */
public class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}