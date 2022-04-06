package main.java.Leetcode.MonthlyLC.LC2021.OctoberLeetcodingChallenge.Week5;

public class MaxDistanceClosestPerson {
    public int maxDistToClosest(int[] seats) {

        int n = seats.length;
        if (n == 0)
            return 0;

        int start = -1;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (start == -1) {
                if (seats[i] == 1)
                    start = i;
                res = Math.max(res, i);
            } else if (seats[i] == 1) {
                int mid = (start + ((i - start) / 2));
                int temp = Math.min(mid - start, i - mid);
                res = Math.max(res, temp);
                start = i;
            }
        }

        if (start == -1)
            start = 0;

        if (start != n - 1) {
            res = Math.max(res, n - start - 1);
        }

        return res;
    }
}
