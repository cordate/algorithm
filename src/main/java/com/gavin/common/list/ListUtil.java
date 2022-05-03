/**
 * cordate.com gavin
 * Copyright (c) 2019-2021 All Rights Reserved
 */
package com.gavin.common.list;

import java.util.*;

/**
 * @author gavin
 * @version $Id: ListUtil.java, v 1.0 2021年11月08日 下午4:09 gavinzhang copyright $
 */
public class ListUtil {
    public static ListNode build(String m) {
        if ("".equals(m.trim())) {
            return null;
        }

        String[] chars = m.split(",");
        int[] nums = new int[chars.length];
        for (int i=0;i<nums.length;i++) {
            nums[i] = Integer.valueOf(chars[i]);
        }

        return build(nums);
    }

    public static ListNode build(int[] nums) {
        ListNode head = new ListNode(-1);
        ListNode pre = head;
        for (int i : nums) {
            pre.next = new ListNode(i);
            pre = pre.next;
        }
        return head.next;
    }

    public static void print(ListNode node) {
        List<Integer> list = new ArrayList<>();
        while (node != null) {
            list.add(node.val);
            node = node.next;
        }
        System.out.println(Arrays.toString(list.toArray()));
    }

    /**
     * 用于生成圆环的操作
     * @param m
     * @return
     */
    public static ListNode buildCircle(String m) {
        String[] chars = m.split(",");
        int[] nums = new int[chars.length];
        for (int i=0;i<nums.length;i++) {
            nums[i] = Integer.valueOf(chars[i]);
        }

        ListNode head = new ListNode(-1);
        ListNode pre = head;
        Map<Integer, ListNode> map = new HashMap<>();

        for (int i=0; i<nums.length-1; i++) {
            pre.next = new ListNode(nums[i]);
            map.put(nums[i], pre.next);
            pre = pre.next;
        }

        pre.next = map.get(nums[nums.length - 1]);
        return head.next;
    }

    public static void main(String[] args) {
        ListNode node = build("1,2,34,4");
        print(node);
    }
}