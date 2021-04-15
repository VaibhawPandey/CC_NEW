package main.java.Leetcode.MonthlyLC.NovemberLeetcodingChallenge.Week3;

import java.util.ArrayDeque;
import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {

        char sChar[] = s.toCharArray();
        if (s.length() == 0)
            return "";

        Stack<String> stack = new Stack<>();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            while (Character.isAlphabetic(sChar[i]) && i < s.length()) {
                res.append(sChar[i]);
                i++;
            }

            if (i == s.length())
                break;

            int k = 1;

            int len  = 0;
            while (Character.isDigit(sChar[i])) {
                len = ((len * 10) + (sChar[i] - '0'));
                i++;
            }

            stack.push(String.valueOf(len));
            stack.push("[");
            i++;


        }

        return "";
    }
}
