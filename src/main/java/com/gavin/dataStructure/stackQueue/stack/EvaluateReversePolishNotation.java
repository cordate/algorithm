/**
 * cordate.com gavin
 * Copyright (c) 2019-2022 All Rights Reserved
 */
package com.gavin.dataStructure.stackQueue.stack;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
 * 逆波兰表达式
 *
 * @author gavin
 * @version $Id: EvaluateReversePolishNotation.java, v 1.0 2022年04月12日 12:25 AM apple copyright $
 */
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();
        for (String token : tokens) {
            switch (token) {
                case "+":
                case "*":
                case "/":
                case "-":
                    handleOp(token, stack);
                    break;
                default:
                    stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }

    public void handleOp(String token, Stack<Integer> stack) {
        int b = stack.pop();
        int a = stack.pop();
        switch (token) {
            case "+":
                stack.push(a+b);
                break;
            case "*":
                stack.push(a*b);
                break;
            case "/":
                stack.push(a/b);
                break;
            case "-":
                stack.push(a-b);
                break;
        }
    }

    public static void main(String[] args) {
        EvaluateReversePolishNotation main = new EvaluateReversePolishNotation();
        System.out.println(main.evalRPN(new String[]{"2","1","+","3","*"}));
        System.out.println(main.evalRPN(new String[]{"4","13","5","/","+"}));
        System.out.println(main.evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }
}
