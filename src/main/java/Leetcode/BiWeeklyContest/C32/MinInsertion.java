package main.java.Leetcode.BiWeeklyContest.C32;

import java.util.Stack;

public class MinInsertion {

    public int minInsertions(String s) {

        Stack<Character> stack = new Stack<>();
        int countSB = 0, countSBBeforeFB = -1;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
//                if (countSB >= 2)
//                    countSB -= 2;
//                else
                stack.push('(');
            } else {
                countSB++;
                if (countSB >= 2 && stack.size() > 0) {
                    countSB -= 2;
                    stack.pop();
                } else if (countSB >= 2)
                      countSBBeforeFB = countSB;
            }

        }

        if (stack.size() == 0 && countSB == 0)
            return 0;



        return 0;
    }
}
