package main.java.CodingBlocks.CourseCoding.DivideAndConquer;

import java.util.Scanner;

/**
 * Find square root by using divide and conquer
 */
public class MonotonicBS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int s = 0, e = n, p = 4;
        double ans = 0.0;

        while (s < e) {
            int mid = (s + e) >> 1;

            if (mid*mid == n) {
                ans = mid;
                break;
            } else if (mid*mid > n) {
                e = mid - 1;
            }
            else
                s = mid + 1;

            ans = mid;
        }

        double inc = 0.1;
        for (int i = 0; i < p; i++) {

            if (ans*ans == n) {
                break;
            }

            while (ans * ans < n)
                ans += inc;

            ans -= inc;
            inc /= 10;
        }

        System.out.println(ans);
        scanner.close();
    }
}
