package main.java.CodingBlocks.CourseCoding.DivideAndConquer.Challenges;

import java.util.Scanner;

public class PivotInSortedAndRotatedArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scanner.nextInt();

        int left = 0, right = n-1;
        while (left < right) {

            int mid = (left + right)/2;
            if (mid != 0 && arr[mid - 1] > arr[mid]) {
                 right = mid - 1;
                 break;
            } else if (arr[left] > arr[mid]) {
                  right = mid - 1;
            } else
                left = mid;

        }

        System.out.println(right);
        scanner.close();
    }
}
