package main.java.CodingBlocks.CourseCoding.Recursion.Challenges;

import java.util.Scanner;

public class OptimalGameStrategyI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[] = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = scanner.nextInt();

        int dp[][] = new int[n][n];
        System.out.println(getMaxValue(arr, 0, arr.length - 1, dp));
        scanner.close();
    }

    private static int getMaxValue(int[] arr, int start, int end, int[][] dp) {
        if (start == end) return arr[start];
        if (start + 1 == end) return Math.max(arr[start], arr[end]);
        if (dp[start][end] != 0) return dp[start][end];


        int res1 = arr[start] + Math.min(getMaxValue(arr, start + 2, end, dp), getMaxValue(arr, start + 1, end - 1, dp));
        int res2 = arr[end] + Math.min(getMaxValue(arr, start + 1, end - 1, dp), getMaxValue(arr, start, end - 2, dp));

        return dp[start][end] = Math.max(res1, res2);
    }
}
