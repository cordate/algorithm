package com.gavin.dataStructure.linkList;

import com.gavin.common.list.ListNode;
import com.gavin.common.list.ListUtil;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 * 删除重复的节点, 这是一个很简单的题目
 *
 * @author gavin
 */
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        return deleteDuplicates2(head);
    }

    public ListNode deleteDuplicates1(ListNode head) {
        if (head == null) return null;
        ListNode pre = head, cur = head;
        cur = cur.next;
        while (cur != null) {
            if (cur.val == pre.val) {
                pre.next = cur.next;
            } else {
                pre = pre.next;
            }
            cur = cur.next;
        }

        return head;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null) return null;
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedList main = new RemoveDuplicatesFromSortedList();
        ListNode r = main.deleteDuplicates(ListUtil.build("1,1,2,3,3"));
        ListUtil.print(r);
    }
}
