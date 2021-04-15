package main.java.CodingBlocks.CourseCoding.DivideAndConquer;

import java.util.Scanner;

public class AggresiveCows {
    public static void main(String[] args) {
        int stalls[] = {1, 2, 4, 8, 9};
        int n = 5, cows = 3;

        int s = 0, e = stalls[n-1]-stalls[0], ans = -1;

        while (s <= e) {
            int mid = (s + e)/2;

            boolean canPlace = canPlaceCow(stalls, n, cows, mid);
            if (canPlace) {
                ans = mid;
                s = mid + 1;
            }
            else
                e = mid - 1;
        }

        System.out.println(ans);
    }

    private static boolean canPlaceCow(int[] stalls, int n, int cows, int mid) {
        int cnt = 1, last_cow = stalls[0];

        for (int i = 1; i < n; i++) {
            if (stalls[i]-last_cow >= mid) {
                last_cow = stalls[i];
                cnt++;

                if (cnt == cows)
                    return true;
            }
        }

        return false;
    }
}
