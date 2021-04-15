package main.java.Leetcode.MonthlyLC.SeptemberLeetcodingChallenge.Week4;

public class FindtheDifference {
    public char findTheDifference(String s, String t) {

        int sumS = 0;
        int sumT = t.charAt(t.length() - 1) - 'a';

        for (int i = 0; i < s.length(); i++) {
            sumS += s.charAt(i) - 'a';
            sumT += t.charAt(i) - 'a';
        }

        return (char) (sumT - sumS + 'a');
    }
}
