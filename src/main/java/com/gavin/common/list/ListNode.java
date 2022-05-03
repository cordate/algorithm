/**
 * cordate.com gavin
 * Copyright (c) 2019-2021 All Rights Reserved
 */
package com.gavin.common.list;

/**
 * @author gavin
 * @version $Id: ListNode.java, v 1.0 2021年11月08日 下午4:07 gavinzhang copyright $
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {};
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}