package com.gavin.dataStructure.linkList;

import com.gavin.common.list.graph.Node;
import com.gavin.common.list.graph.NodeUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/copy-list-with-random-pointer/
 * 复制带随机指针的链表
 *
 * 注意这题还有回溯+hash表的解法。hash表用于访问已经创建过的节点
 *
 * @author gavin
 */
public class CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        Node cur = head;
        while (cur != null) {
            Node newCur = new Node(cur.val);
            newCur.next = cur.next;
            cur.next = newCur;
            cur = newCur.next;
        }

        cur = head;
        while (cur != null) {
            if (cur.random != null)
                cur.next.random = cur.random.next;
            cur = cur.next.next;
        }

        cur = head; Node move = null;
        while (cur != null) {
            if (move == null) {
                move = cur.next;
            } else {
                move.next = cur.next;
                move = move.next;
            }
            cur = cur.next.next;
        }

        return head.next;
    }

    public static void main(String[] args) {
        CopyListWithRandomPointer2 main = new CopyListWithRandomPointer2();
        Node param = NodeUtil.build(new Integer[][]{{7,null},{13,0},{11,4},{10,2},{1,0}});
        NodeUtil.print(main.copyRandomList(param));
    }
}

/**
 * 这是递归回溯的解法
 */
class CopyListWithRandomPointer2 {
    public Map<Node, Node> map = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) return head;
        Node cur = map.get(head);
        if (cur == null) {
            cur = new Node(head.val);
            map.put(head, cur);
            cur.next = copyRandomList(head.next);
            cur.random = copyRandomList(head.random);
        }
        return cur;
    }
}
