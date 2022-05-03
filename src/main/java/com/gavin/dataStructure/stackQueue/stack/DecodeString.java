/**
 * cordate.com gavin
 * Copyright (c) 2019-2022 All Rights Reserved
 */
package com.gavin.dataStructure.stackQueue.stack;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/decode-string/
 * 字符串解码
 *
 * 栈和递归是相辅相成的，所以这题还有递归的解法，注意学习
 *
 * @author gavin
 * @version $Id: DecodeString.java, v 1.0 2022年04月12日 09:24 AM apple copyright $
 */
public class DecodeString {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                String str = "";
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    str += s.charAt(i);
                    i++;
                }
                i--;
                stack.push(str);
            } else if (Character.isLetter(s.charAt(i))) {
                String str = "";
                while (i < s.length() && Character.isLetter(s.charAt(i))) {
                    str += s.charAt(i);
                    i++;
                }
                i--;
                stack.push(str);
            } else if (s.charAt(i) == ']') {
                // 这里如果格式对，一定存在数字
                String str = "";
                while (!isDigit(stack.peek())) {
                    str = stack.pop() + str;
                }
                int n = Integer.valueOf(stack.pop());
                StringBuffer buffer = new StringBuffer();
                while (n > 0) {
                    buffer.append(str);
                    n--;
                }
                stack.push(buffer.toString());
            }
        }

        String ret = "";
        while (!stack.isEmpty()) {
            ret = stack.pop() + ret;
        }

        return ret;
    }

    public boolean isDigit(String s) {
        for (char c : s.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        DecodeString main = new DecodeString();
        System.out.println(main.decodeString("3[a]2[bc]"));
        System.out.println(main.decodeString("3[a2[c]]"));
        System.out.println(main.decodeString("2[abc]3[cd]ef"));
        System.out.println(main.decodeString("abc3[cd]xyz"));
    }
}
