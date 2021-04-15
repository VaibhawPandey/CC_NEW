package main.java.CodingBlocks.CourseCoding.DivideAndConquer.Challenges;

import java.util.Arrays;
import java.util.Scanner;

public class AggresiveCows {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int noOfCows = scanner.nextInt();

        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scanner.nextInt();

        Arrays.sort(arr);
        int s = 0, e = arr[n-1]-arr[0];
        int ans = -1;
        while (s < e) {

            int mid = (s + e)/2;
            boolean canBePlaced = cowsCanBePlaced(arr, mid, n, noOfCows);
            if (canBePlaced) {
                ans = mid;
                s = mid + 1;
            }
            else e = mid;

        }

        System.out.println(ans);
        scanner.close();
    }

    private static boolean cowsCanBePlaced(int[] arr, int diff, int n, int noOfCows) {

        int cnt = 1, lastPos = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] - lastPos >= diff) {
                lastPos = arr[i];
                cnt++;

                if (cnt == noOfCows)
                    return true;
            }
        }

        return false;
    }
}
