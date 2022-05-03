/**
 * cordate.com gavin
 * Copyright (c) 2019-2022 All Rights Reserved
 */
package com.gavin.dataStructure.stackQueue.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/min-stack/
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * 这题需要熟悉栈的特性才能做出来，这里比较简单。
 *
 * @author gavin
 * @version $Id: MinStack.java, v 1.0 2022年04月12日 12:17 AM apple copyright $
 */
public class MinStack {
    private Deque<Integer> min = null;
    private Deque<Integer> num = null;

    public MinStack() {
        min = new LinkedList<>();
        num = new LinkedList<>();
    }

    public void push(int val) {
        num.push(val);
        if (min.isEmpty() || min.peek() > val) {
            min.push(val);
        } else {
            min.push(min.peek());
        }
    }

    public void pop() {
        min.pop();
        num.pop();
    }

    public int top() {
        return num.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
