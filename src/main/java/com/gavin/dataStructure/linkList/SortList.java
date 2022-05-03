package com.gavin.dataStructure.linkList;

import com.gavin.common.list.ListNode;
import com.gavin.common.list.ListUtil;

/**
 * https://leetcode-cn.com/problems/sort-list/
 * 这题使用归并排序的思想进行处理，我这里写的是冒泡排序
 *
 * @author gavin
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        while (head != null) {
            ListNode cur = dummy;
            ListNode hNext = head.next;

            if (cur.next == null) {
                cur.next = head;
                head.next = null;
                head = hNext;
                continue;
            }

            while (cur.next != null) {
                if (cur.next.val >= head.val) {
                    ListNode next = cur.next;
                    cur.next = head;
                    head.next = next;
                    break;
                }
                cur = cur.next;
            }

            if (cur.next == null) {
                cur.next = head;
                head.next = null;
            }

            head = hNext;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        SortList2 main = new SortList2();
        ListUtil.print(main.sortList(ListUtil.build("4,2,1,3,6")));
    }
}

/**
 * 二分处理，归并排序
 * 递归分为自底向上和自上向下
 */
class SortList2 {
    public ListNode sortList(ListNode head) {
        return sortList(head, null);
    }

    public ListNode sortList(ListNode head, ListNode tail) {
        if (head == null) {
            return head;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        ListNode slow = head, fast = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        ListNode mid = slow;
        ListNode list1 = sortList(head, mid);
        ListNode list2 = sortList(mid, tail);
        ListNode sorted = merge(list1, list2);
        return sorted;
    }

    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead, temp1 = head1, temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if (temp1 != null) {
            temp.next = temp1;
        } else if (temp2 != null) {
            temp.next = temp2;
        }
        return dummyHead.next;
    }
}
