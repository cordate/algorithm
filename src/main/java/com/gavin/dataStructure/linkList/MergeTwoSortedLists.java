package com.gavin.dataStructure.linkList;

import com.gavin.common.list.ListNode;
import com.gavin.common.list.ListUtil;

/**
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * 这题比较简单，实现也很容易
 *
 * 注意这题还有一种递归的写法，以满足不同的处理方式
 *
 * @author gavin
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1;
                list1 = list1.next;
                if (list1 == null) {
                    cur.next.next = list2;
                }
            } else {
                cur.next = list2;
                list2 = list2.next;
                if (list2 == null) {
                    cur.next.next = list1;
                }
            }
            cur = cur.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        MergeTwoSortedLists main = new MergeTwoSortedLists();
        ListUtil.print(main.mergeTwoLists(ListUtil.build("1,2,4"),
                ListUtil.build("1,3,4")));
    }
}
