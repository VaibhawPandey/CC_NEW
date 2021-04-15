package main.java.Practice.DP.LCS;

import java.util.Stack;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        System.out.println(printLCS("abcdh", "adbchr"));
    }

    public static String printLCS(String s1, String s2) {
        int dp[][] = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 1; i < s1.length(); i++) {
            for (int j = 1; j < s2.length(); j++) {

                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
            }
        }

        int start = s1.length(), end = s2.length();
        Stack<Character> stack = new Stack<>();
        while (start > 0 && end > 0) {

            if (s1.charAt(start-1) == s2.charAt(end-1)) {
                stack.push(s1.charAt(start-1));
                start--;
                end--;
            } else {
                if (dp[start-1][end] > dp[start][end-1])
                    start--;
                else
                    end--;
            }
        }

        String res = new String();
        while (!stack.isEmpty())
              res += stack.pop();

        return res;

    }

    public static int longestCommonSubsequence(String s1, String s2) {
        int dp[][] = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {

                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[s1.length()][s2.length()];
    }
}
