package com.gavin.common.tree;

import com.gavin.common.tree.TreeNode;

import java.util.*;

/**
 * TreeUtil
 *
 * @author gavin
 */
public class TreeUtil {
    public static TreeNode build(String vals) {
        return build(vals.split(","));
    }

    public static TreeNode build(String[] vals) {
        if (vals == null || vals.length == 0) return null;
        List<TreeNode> list = new ArrayList<>();
        for (int i=0;i<vals.length; i++) {
            if ("null".equals(vals[i]) || vals[i] == null) {
                list.add(null);
                continue;
            }
            TreeNode root = new TreeNode(Integer.valueOf(vals[i]));
            list.add(root);
        }

        for (int i=1;i<vals.length;i++) {
            boolean left = (i % 2) == 1;
            int layer = 0;
            int sum = (i+1) / 2;
            int index = 0;
            while(sum > (2 ^ layer)) {
                sum -= (2 ^ layer);
                index += (2 ^ layer);
                layer++;
            }
            int pos = index + sum / 2;
            TreeNode p = list.get(pos);
            if (left) {
                p.left = list.get(i);
            } else {
                p.right = list.get(i);
            }
        }

        return list.get(0);
    }

    /**
     *
     * @param root
     * @param val
     * @return
     */
    public static TreeNode find(TreeNode root, int val) {
        TreeNode h = root;
        if (h == null) {
            return null;
        }
        if (h.val == val) {
            return h;
        }

        TreeNode left = find(root.left, val);
        if (left == null) {
            return find(root.right, val);
        } else {
            return left;
        }
    }

    public static void print(TreeNode root) {
        String s = Arrays.toString(toArray(root).toArray(new String[]{}));
        System.out.print(s);
    }

    public static void println(TreeNode root) {
        String s = Arrays.toString(toArray(root).toArray(new String[]{}));
        System.out.println(s);
    }

    public static List<String> toArray(TreeNode root) {
        List<String> ret = new ArrayList<>();
        if (root==null) return new ArrayList<>();
        Queue<TreeNode> q = new LinkedList();
        q.offer(root);
        while (!q.isEmpty()) {
            int n = q.size();
            while (n > 0) {
                n--;
                TreeNode node = q.poll();
                if (node == null) {
                    ret.add("null");
                    continue;
                }
                ret.add(node.val + "");
                q.offer(node.left);
                q.offer(node.right);
            }
        }
        for (int i = ret.size() -1; i >=0 ; i--) {
            if ("null".equals(ret.get(i))) {
                ret.remove(i);
                continue;
            }
            break;
        }
        return ret;
    }

    public static void main(String[] args) {
        TreeNode node = build(new String[] {"1", "2", "3", "null", "5", "7"});
        println(node);
    }
}
