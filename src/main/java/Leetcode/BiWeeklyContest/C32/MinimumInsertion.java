package main.java.Leetcode.BiWeeklyContest.C32;

public class MinimumInsertion {

    public int minInsertions(String s) {

        int res = 0, right = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {

                if (right % 2 != 0) {
                    right--;
                    res++;
                }

                right += 2;
            } else {
                right--;

                if (right < 0) {
                    right += 2;
                    res++;
                }
            }
        }

        return res + right;
    }
}
