package main.java.Leetcode.MonthlyLC.LC2021.OctoberLeetcodingChallenge.Week4;

public class StoneGame4 {
    public static void main(String[] args) {
        new StoneGame4().winnerSquareGame(15);
    }
    public boolean winnerSquareGame(int n) {

        int count = 0, last = 0;
        while (true) {
            int s = (int) Math.sqrt(n - last);
            if (s == 1)
                break;

            count++;
            last += (s * s);
        }

        count += (n - last);

        return count % 2 == 1;
    }
}
