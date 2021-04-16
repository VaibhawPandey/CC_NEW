package main.java.CodingBlocks.CourseCoding.DivideAndConquer.Challenges;

import java.util.Scanner;

public class MurthalParatha {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int p = scanner.nextInt();
        int l = scanner.nextInt();
        int r[] = new int[l];
        int R = Integer.MAX_VALUE;

        for (int i = 0; i < l; i++) {
            r[i] = scanner.nextInt();
            R = Math.min(R, r[i]);
        }

        //
        int s = 0, e = R * ((p * (p + 1))/2);

        int ans = 0;

        while (s <= e) {

            int mid = (s + e)/2;
            boolean isMakingParathaPossible = isMakingParathaPossible(r, mid, p);
            if (isMakingParathaPossible) {
                ans = mid;
                e = mid - 1;
            } else
                s = mid + 1;
        }

        System.out.println(ans);
        scanner.close();
    }

    private static boolean isMakingParathaPossible(int[] r, int mid, int p) {
        int noOfParatha = 0;
        for (int i = 0; i < r.length; i++) {
            int k = 0;
            while (r[i] * (k * (k + 1)) <= 2 * mid)
                k++;
            noOfParatha += k - 1;

            if (noOfParatha >= p)
                return true;
        }

        return false;
    }
}
