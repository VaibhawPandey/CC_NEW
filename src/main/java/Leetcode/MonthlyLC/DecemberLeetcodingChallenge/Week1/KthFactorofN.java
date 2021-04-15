package main.java.Leetcode.MonthlyLC.DecemberLeetcodingChallenge.Week1;

public class KthFactorofN {
    public int kthFactor(int n, int k) {
        int r = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0)
                r++;

            if (r == k)
                return i;
        }

        return -1;
    }
}
