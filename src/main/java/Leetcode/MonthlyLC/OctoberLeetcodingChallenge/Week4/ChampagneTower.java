package main.java.Leetcode.MonthlyLC.OctoberLeetcodingChallenge.Week4;

public class ChampagneTower {
    public double champagneTower(int poured, int query_row, int query_glass) {

        double res[] = new double[query_row + 2];
        res[0] = poured;

        for (int i = 0; i <= query_row; i++) {
            for (int j = i; j >= 0; j--)
                res[j + 1] += res[j] = Math.max(0.0, (res[j] - 1)/ 2);
        }

        return Math.min(res[query_glass], 1.0);
    }
}
