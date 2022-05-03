package com.gavin.dataStructure.linkList;

import com.gavin.common.list.ListNode;
import com.gavin.common.list.ListUtil;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list-ii/
 * 这题也需要好好练习一番，才能达到你想要的效果
 *
 * @author gavin
 */
public class ReverseLinkedList2 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) return head;
        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy;
        while (left > 1 && head != null) {
            head = head.next;
            pre = pre.next;
            left--;
            right--;
        }
        pre.next = swap(head, right);

        return dummy.next;
    }

    public ListNode swap(ListNode start, int num) {
        if (start == null) return start;
        ListNode cur = start;
        ListNode pre = null;
        while (cur != null && num > 0) {
            start.next = cur.next;
            if (pre != null)
                cur.next = pre;
            pre = cur;
            cur = start.next;
            num--;
        }

        return pre;
    }

    public static void main(String[] args) {
        ReverseLinkedList2 main = new ReverseLinkedList2();
        ListNode head = ListUtil.build("1,2,3,4,5");
        ListNode result = main.reverseBetween(head, 2, 4);
        ListUtil.print(result);
    }
}
