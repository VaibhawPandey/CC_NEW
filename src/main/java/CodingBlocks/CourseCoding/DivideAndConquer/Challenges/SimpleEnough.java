package main.java.CodingBlocks.CourseCoding.DivideAndConquer.Challenges;

import java.util.Scanner;

public class SimpleEnough {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong(), l = scanner.nextLong(), r = scanner.nextLong();
        long range = getRange(n);
        System.out.println(getResult(n, 1, range, l, r));
    }

    private static long getResult(long n, long s, long end, long l, long r) {
        if (end < l || s > r || s > end)
            return 0;

        long mid = (s + end)/2, ans = 0;
        if (mid >= l && mid <= r && n % 2 == 1)
            ans++;

        ans += getResult(n/2, s, mid-1, l, r);
        ans += getResult(n/2, mid + 1, end, l, r);

        return ans;
    }

    private static long getRange(long n) {
        if (n <= 1)
            return n;
        else
            return getRange(n/2)*2 + 1;
    }
}
