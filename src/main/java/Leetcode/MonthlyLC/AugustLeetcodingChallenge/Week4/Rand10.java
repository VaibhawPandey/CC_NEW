package main.java.Leetcode.MonthlyLC.AugustLeetcodingChallenge.Week4;

public class Rand10 {
    public  int rand7() {
        return 0;
    }
    public int Rand10() {
        while (true) {
            int row = 7 * (rand7() - 1);
            int col = rand7();
            int sum = row + col;

            if (sum <= 40)
                return 1 + (sum - 1) % 10;
        }
    }
}
