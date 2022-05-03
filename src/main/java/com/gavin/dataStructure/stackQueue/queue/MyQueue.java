/**
 * cordate.com gavin
 * Copyright (c) 2019-2022 All Rights Reserved
 */
package com.gavin.dataStructure.stackQueue.queue;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/implement-queue-using-stacks/
 * 用栈实现Queue，要注意in和out的区别
 *
 * @author gavin
 * @version $Id: MyQueue.java, v 1.0 2022年04月13日 1:05 AM apple copyright $
 */
public class MyQueue {
    private Stack<Integer> inStack;
    private Stack<Integer> outStack;
    public MyQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
        return outStack.pop();
    }

    public int peek() {
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
        return outStack.peek();
    }

    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }
}
