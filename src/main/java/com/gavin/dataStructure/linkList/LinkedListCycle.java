package com.gavin.dataStructure.linkList;

import com.gavin.common.list.ListNode;
import com.gavin.common.list.ListUtil;

/**
 * https://leetcode-cn.com/problems/linked-list-cycle/
 * 这题也可以用hash表格
 *
 * @author gavin
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head==null && head.next == null) return false;
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }

        return fast == slow;
    }

    public static void main(String[] args) {
        LinkedListCycle main = new LinkedListCycle();
        System.out.println(main.hasCycle(ListUtil.buildCircle("3,2,0,-4,2")));
    }
}
