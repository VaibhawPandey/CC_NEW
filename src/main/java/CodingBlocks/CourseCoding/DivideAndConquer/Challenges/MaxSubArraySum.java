package main.java.CodingBlocks.CourseCoding.DivideAndConquer.Challenges;

import java.util.Scanner;

public class MaxSubArraySum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            int n = scanner.nextInt();
            int arr[] = new int[n];

            for (int i = 0; i < n; i++)
                arr[i] = scanner.nextInt();

            System.out.println(getMaxSum(arr, 0, n-1));
        }
        scanner.close();
    }

    private static int getMaxSum(int[] arr, int l, int r) {

        if (l < r) {

            int mid = (l + r)/2;
            return Math.max(Math.max(getMaxSum(arr, l, mid), getMaxSum(arr, mid + 1, r)),
                    getMidSum(arr, l, mid, r));
        }

        return 0;
    }

    private static int getMidSum(int[] arr, int l, int mid, int r) {
        int left_Sum = Integer.MIN_VALUE, right_Sum = Integer.MIN_VALUE;

        int temp_Sum = 0;
        for (int i = mid; i >= l; i--) {
            temp_Sum += arr[i];
            left_Sum = Math.max(left_Sum, temp_Sum);
        }

        temp_Sum = 0;
        for (int i = mid + 1; i <= r; i++) {
            temp_Sum += arr[i];
            right_Sum = Math.max(right_Sum, temp_Sum);
        }

        return Math.max(Math.max(left_Sum, right_Sum), left_Sum + right_Sum);
    }


}
