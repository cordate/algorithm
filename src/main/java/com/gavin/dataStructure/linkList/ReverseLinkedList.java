package com.gavin.dataStructure.linkList;

import com.gavin.common.list.ListNode;
import com.gavin.common.list.ListUtil;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list/solution/fan-zhuan-lian-biao-by-leetcode-solution-d1k2/
 * 翻转列表可以使用递归的使用
 *
 * @author gavin
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        return reverseList1(head);
    }

    /**
     * 这个递归方法没有看懂什么意思
     * @param head
     * @return
     */
    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode l = reverseList1(head.next);
        head.next.next = head;
        head.next = null;

        return l;
    }

    public ListNode reverseList2(ListNode head) {
        ListNode dummy = null, tmp;
        while (head != null) {
            tmp = head.next;
            head.next = dummy;
            dummy = head;
            head = tmp;
        }

        return dummy;
    }

    public static void main(String[] args) {
        ReverseLinkedList main = new ReverseLinkedList();
        ListNode r = main.reverseList(ListUtil.build("1,2,3,4,5"));
        ListUtil.print(r);
    }
}
