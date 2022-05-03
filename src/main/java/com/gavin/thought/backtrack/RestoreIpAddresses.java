/**
 * cordate.com gavin
 * Copyright (c) 2019-2022 All Rights Reserved
 */
package com.gavin.thought.backtrack;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/restore-ip-addresses/
 *
 * @author gavin
 * @version $Id: RestoreIpAddresses.java, v 1.0 2022年05月03日 4:03 PM apple copyright $
 */
public class RestoreIpAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        List<String> list = new ArrayList<>();
        restoreIpAddresses(s, 0, result, list);
        return result;
    }

    private void restoreIpAddresses(String s,
                                    int index, List<String> result, List<String> list) {
        if (index >= s.length() && list.size() == 4) {
            result.add(listToString(list));
            return;
        }

        if (index >= s.length()) {
            return;
        }

        if (list.size() >= 4) {
            return;
        }

        int num = 0;
        int cur = index + 1;
        while (num <= 255 && cur <= s.length()) {
            String str = s.substring(index, cur);
            num = Integer.valueOf(str);
            if (num > 255) {
                break;
            }
            if (s.charAt(index) == '0' && cur - index > 1) {
                break;
            }
            list.add(str);
            restoreIpAddresses(s, cur, result, list);
            list.remove(list.size() - 1);
            cur++;
        }
    }

    private String listToString(List<String> list) {
        StringBuffer buffer = new StringBuffer();
        for (String str : list) {
            buffer.append(str);
            buffer.append('.');
        }
        buffer.deleteCharAt(buffer.length() - 1);

        return buffer.toString();
    }

    public static void main(String[] args) {
        RestoreIpAddresses main = new RestoreIpAddresses();
        System.out.println(JSON.toJSONString(main.restoreIpAddresses("25525511135")));
        System.out.println(JSON.toJSONString(main.restoreIpAddresses("0000")));
        System.out.println(JSON.toJSONString(main.restoreIpAddresses("101023")));
    }
}
