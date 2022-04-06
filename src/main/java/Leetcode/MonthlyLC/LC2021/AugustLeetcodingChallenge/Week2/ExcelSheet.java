package main.java.Leetcode.MonthlyLC.AugustLeetcodingChallenge.Week2;

public class ExcelSheet {

    public int titleToNumber(String s) {

        int n = s.length();

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += (s.charAt(i) - 'A' + 1) * Math.pow(26, n - i - 1);
        }

        return sum;
    }
}
