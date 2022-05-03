package com.gavin.dataStructure.linkList;

import com.gavin.common.list.ListNode;
import com.gavin.common.list.ListUtil;

/**
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 * 判断是不是回文串，这题的递归方式需要好好理解学习啊，后面需要持续学习
 * 这题一共有三种解法：
 *    1. 转为数组，使用双指针法
 *    2. 递归
 *    3. 快慢指针法
 *
 * @author gavin
 */
public class PalindromeLinkedList {
    private ListNode frontPointer;

    public boolean isPalindrome(ListNode head) {
        frontPointer = head;
        return recursivelyCheck(head);
    }

    public boolean recursivelyCheck(ListNode head) {
        if (head != null) {
            if (!recursivelyCheck(head.next)) {
                return false;
            }
            if (head.val != frontPointer.val) {
                return false;
            }
            frontPointer = frontPointer.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode param = ListUtil.build("1,2,2,1");
        PalindromeLinkedList main = new PalindromeLinkedList();
        System.out.println(main.isPalindrome(param));
    }
}
