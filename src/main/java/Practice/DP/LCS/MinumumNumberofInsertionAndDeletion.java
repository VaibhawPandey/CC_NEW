package main.java.Practice.DP.LCS;

import java.util.Scanner;

import static main.java.Practice.DP.LCS.ShortestCommonSupersequence.longestCommonSuperSequence;

/*
* Minimum number of insertion and deletion to convert a string to other.
 */
public class MinumumNumberofInsertionAndDeletion {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.next(), s2 = scanner.next();

        int dp[][] = longestCommonSuperSequence(s1, s2);
        System.out.println("Number of insertion and deletion required:- " + ((s1.length() - dp[s1.length()][s2.length()]) + (s2.length() - dp[s1.length()][s2.length()])));
    }


}
