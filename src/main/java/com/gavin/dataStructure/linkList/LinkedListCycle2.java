package com.gavin.dataStructure.linkList;

import com.gavin.common.list.ListNode;
import com.gavin.common.list.ListUtil;

/**
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/
 * 这题也可以使用hash表格
 *
 * @author gavin
 */
public class LinkedListCycle2 {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        LinkedListCycle2 main = new LinkedListCycle2();
        System.out.println(main.detectCycle(ListUtil.buildCircle("3,2,0,-4,2")).val);
    }
}
