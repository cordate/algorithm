/**
 * cordate.com gavin
 * Copyright (c) 2019-2022 All Rights Reserved
 */
package com.gavin.thought.backtrack;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 *
 * @author gavin
 * @version $Id: LetterCombinationsOfAPhoneNumber.java, v 1.0 2022年05月03日 2:38 PM apple copyright $
 */
public class LetterCombinationsOfAPhoneNumber {
    Map<Character, String> phone = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        StringBuffer buffer = new StringBuffer();
        letterCombinations(digits, 0, result, buffer);
        return result;
    }

    private void letterCombinations(String digits, int index, List<String> result, StringBuffer buffer) {
        if (digits.length() == buffer.length()) {
            result.add(buffer.toString());
            return;
        }

        String seqNo = phone.get(digits.charAt(index));

        for (char s : seqNo.toCharArray()) {
            buffer.append(s);
            letterCombinations(digits, index + 1, result, buffer);
            buffer.deleteCharAt(buffer.length()-1);
        }
    }

    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber main = new LetterCombinationsOfAPhoneNumber();
        System.out.println(JSON.toJSONString(main.letterCombinations("23")));
        System.out.println(JSON.toJSONString(main.letterCombinations("2")));
        System.out.println(JSON.toJSONString(main.letterCombinations("")));
    }
}
