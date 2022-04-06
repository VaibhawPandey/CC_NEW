package main.java.Leetcode.MonthlyLC.LC2021.OctoberLeetcodingChallenge.Week2;

import java.util.Stack;

public class RemoveDuplicates {
    public static void main(String[] args) {
        new RemoveDuplicates().removeDuplicateLetters("cbacdcbc");
    }

    public String removeDuplicateLetters(String s) {

        if (s.length() == 0)
            return s;

        Stack<Integer> stack = new Stack();
        int[] last = new int[26], seen = new int[26];

        for (int i = 0; i < s.length(); i++)
            last[s.charAt(i) - 'a'] = i;

        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            if (seen[c]++ > 0) continue;
            while (!stack.empty() && stack.peek() > c && i < last[stack.peek()])
                seen[stack.pop()] = 0;
            stack.push(c);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = stack.size() - 1; i >= 0; i--)
            sb.append(stack.get(i));

        return sb.toString();
    }
//    public String removeDuplicateLetters(String s) {
//
//        if (s.length() == 0)
//            return s;
//
//        int alphabetCount[] = new int[26];
//        char sChar[] = s.toCharArray();
//
//        for (int i = 0; i < sChar.length; i++) {
//            alphabetCount[sChar[i] - 'a']++;
//        }
//
//        String res = "";
//        for (int i = 0; i < sChar.length; i++) {
//            int c = sChar[i] - 'a';
//            boolean isSorted = true;
//            if (alphabetCount[c] > 1) {
//                for (int j = 0; j < c; j++) {
//                    if (alphabetCount[j] > 0)
//                        isSorted = false;
//                }
//            }
//
//            if (alphabetCount[c] != 0 && isSorted) {
//                res += (char) (c + 'a');
//                alphabetCount[c] = 0;
//            } else
//                alphabetCount[c]--;
//        }
//
//        return res;
//    }
}
