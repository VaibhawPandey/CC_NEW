package main.java.Leetcode.MonthlyLC.LC2021.SeptemberLeetcodingChallenge.Week1;

public class RepeatSubstringPattern {
    public static void main(String[] args) {
        new RepeatSubstringPattern().repeatedSubstringPattern("ababab");
    }
    public boolean repeatedSubstringPattern(String s) {

        int start = 0, end = s.length() - 1;

        while (start < end && start < (end / 2)) {

            while (s.charAt(start) != s.charAt(end) && start < (end / 2))
                start++;

            if (s.charAt(start) == s.charAt(end)) {

                int i = start, j = end;
                int count = 0;
                while (i < j) {
                    j = j - (i + 1);
                    if (s.charAt(i) == s.charAt(j))
                        count++;
                    else
                        break;
                }

                if (i == j) {

                    StringBuilder sub = new StringBuilder(s.substring(0, start + 1));
                    String temp = sub.toString();
                    for (int k = 0; k < count; k++)
                        sub.append(temp);

                    if (sub.toString().equals(s))
                        return true;
                }
            } else
                return false;

            start++;
        }

        return false;
    }
}
