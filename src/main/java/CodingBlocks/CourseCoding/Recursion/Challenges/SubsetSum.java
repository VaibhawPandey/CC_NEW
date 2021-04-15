package main.java.CodingBlocks.CourseCoding.Recursion.Challenges;

import java.util.Scanner;

public class SubsetSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            int n = scanner.nextInt();

            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = scanner.nextInt();

            System.out.println(isSubsetSumZero(arr, 0, n, Integer.MIN_VALUE) ? "Yes": "No");
        }
    }

    private static boolean isSubsetSumZero(int[] arr, int pos, int n, int subsetSum) {
        if (pos == n || (subsetSum == 0 && pos != 0)) {
            if (subsetSum == 0) return true;
            else return false;
        }

        return isSubsetSumZero(arr, pos + 1, n, subsetSum == Integer.MIN_VALUE ? arr[pos]: subsetSum + arr[pos]) ||
                isSubsetSumZero(arr, pos + 1, n, subsetSum);
    }
}
