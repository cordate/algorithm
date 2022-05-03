/**
 * cordate.com gavin
 * Copyright (c) 2019-2022 All Rights Reserved
 */
package com.gavin.thought.recursion;

import com.gavin.common.list.ListNode;
import com.gavin.common.list.ListUtil;

/**
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。
 * 你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 *
 * @author gavin
 * @version $Id: SwapNodesInPairs.java, v 1.0 2022年05月02日 8:50 PM apple copyright $
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        cur = cur.next;
        head.next = swapPairs(cur.next);
        cur.next = head;
        return cur;
    }

    /**
     * 迭代法处理起来比较麻烦
     * @param head
     * @return
     */
    public ListNode swapPairs2(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode temp = dummyHead;
        while (temp.next != null && temp.next.next != null) {
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            temp = node1;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        SwapNodesInPairs main = new SwapNodesInPairs();
        ListUtil.print(main.swapPairs(ListUtil.build("1,2,3,4")));
        ListUtil.print(main.swapPairs(ListUtil.build("")));
        ListUtil.print(main.swapPairs(ListUtil.build("1")));
    }
}
