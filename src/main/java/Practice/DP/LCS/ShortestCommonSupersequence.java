package main.java.Practice.DP.LCS;

import java.util.Scanner;
import java.util.Stack;

public class ShortestCommonSupersequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.next(), s2 = scanner.next();
        int dp[][] = longestCommonSuperSequence(s1, s2);
        System.out.println("SCS length :- " + ((s1.length() + s2.length()) - dp[s1.length()][s2.length()]));
        System.out.println("SCS :- " + printShortestCommonSupersequence(s1, s2, dp));
    }

    /*
    * Length of Short supersequence formed from two string
    * It's basically mix of length of two string - common subsequence
     */
    public static int[][] longestCommonSuperSequence(String s1, String s2) {

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

        return dp;
    }

    private static String printShortestCommonSupersequence(String s1, String s2, int dp[][]) {

        Stack<Character> stack = new Stack<>();
        int i = s1.length(), j = s2.length();

        while (i > 0 && j > 0) {
            if (s1.charAt(i-1) == s2.charAt(j-1)) {
                stack.push(s1.charAt(i-1));
                i--; j--;
            } else {
                if (dp[i-1][j] > dp[i][j-1]) {
                    stack.push(s1.charAt(i-1));
                    i--;
                }
                else {
                    stack.push(s2.charAt(j-1));
                    j--;
                }
            }
        }

        while (i > 0) {
            stack.push(s1.charAt(i-1));
            i--;
        }

        while (j > 0) {
            stack.push(s2.charAt(j-1));
            j--;
        }

        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty())
            res.append(stack.pop());

        return res.toString();
    }
}
