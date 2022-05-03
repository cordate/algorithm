package com.gavin.dataStructure.linkList;

import com.gavin.common.list.ListNode;
import com.gavin.common.list.ListUtil;

/**
 * https://leetcode-cn.com/problems/partition-list/
 * 这题难度中等，实现起来稍微有些复杂
 *
 * @author gavin
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode cur = null, ch = null;
        ListNode pre = null, ph = null;
        while (head != null) {
            if (head.val < x) {
                if (cur != null) {
                    cur.next = head;
                } else {
                    ch = head;
                }
                cur = head;
            } else {
                if (pre != null) {
                    pre.next = head;
                } else {
                    ph = head;
                }
                pre = head;
            }
            ListNode n = head.next;
            head.next = null;
            head = n;
        }

        cur.next = ph;

        return ch;
    }

    public static void main(String[] args) {
        PartitionList main = new PartitionList();
        ListUtil.print(main.partition(ListUtil.build("1,4,3,2,5,2"), 3));
    }
}
