/**
 * cordate.com gavin
 * Copyright (c) 2019-2022 All Rights Reserved
 */
package com.gavin.thought.recursion;

/**
 * https://leetcode-cn.com/problems/fibonacci-number/
 *
 * @author gavin
 * @version $Id: FibonacciNumber.java, v 1.0 2022年05月02日 9:38 PM apple copyright $
 */
public class FibonacciNumber {
    public int fib(int n) {
        if (n < 2)
            return n;

        return fib(n-1) + fib(n-2);
    }

    public static void main(String[] args) {
        FibonacciNumber main = new FibonacciNumber();
        System.out.println(main.fib(4));
    }
}
