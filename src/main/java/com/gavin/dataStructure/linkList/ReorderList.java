package com.gavin.dataStructure.linkList;

import com.gavin.common.list.ListNode;
import com.gavin.common.list.ListUtil;

/**
 * https://leetcode-cn.com/problems/reorder-list/
 *
 * 这题的解法比较简单，先找中位点，然后逆转后面的表，然后进行合并即可
 * 当然这题有个很简单的解题方法，就是使用数据下标进行重新链表的组装。
 *
 * @author gavin
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode l2 = slow.next;
        slow.next = null;
        l2 = reverseList(l2);

        while (head != null && l2 != null) {
            ListNode tmp1 = head.next;
            ListNode tmp2 = l2.next;
            head.next = l2;
            l2.next = tmp1;
            l2 = tmp2;
            head = tmp1;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode cur = null, tmp = null;
        while (head != null) {
            tmp = head.next;
            head.next = cur;
            cur = head;
            head = tmp;
        }

        return cur;
    }

    public static void main(String[] args) {
        ReorderList main = new ReorderList();
        ListNode head = ListUtil.build("1,2,3,4,5");
        main.reorderList(head);
        ListUtil.print(head);
    }
}
