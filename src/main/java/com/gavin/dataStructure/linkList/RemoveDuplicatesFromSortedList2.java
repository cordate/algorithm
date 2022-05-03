package com.gavin.dataStructure.linkList;

import com.gavin.common.list.ListNode;
import com.gavin.common.list.ListUtil;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
 * 这也是个复杂的题目，链表的实现还是需要练习一下
 *
 * @author gavin
 */
public class RemoveDuplicatesFromSortedList2 {
    public ListNode deleteDuplicates(ListNode head) {
        return deleteDuplicates2(head);
    }

    /**
     * 这个写起来比较麻烦，容易判空出错，逻辑上也容易犯错
     * @param head
     * @return
     */
    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null) return null;
        ListNode dummy = new ListNode(-1, head), cur = dummy;

        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }

        return dummy.next;
    }

    /**
     * 自己实现的逻辑
     * @param head
     * @return
     */
    public ListNode deleteDuplicates1(ListNode head) {
        if (head == null) return null;
        ListNode pre = new ListNode(-1), cur = pre;
        pre.next = head;
        head = head.next;
        while (head != null) {
            if (pre.next.val != head.val) {
                if (pre.next.next == head) {
                    pre = pre.next;
                } else {
                    pre.next = head;
                }
            }
            head = head.next;
        }

        return cur.next;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedList2 main = new RemoveDuplicatesFromSortedList2();
        ListNode r = main.deleteDuplicates(ListUtil.build("1,1,1,2,3"));
        ListUtil.print(r);
        r = main.deleteDuplicates(ListUtil.build("1,2,3,3,4,4,5"));
        ListUtil.print(r);
    }
}
