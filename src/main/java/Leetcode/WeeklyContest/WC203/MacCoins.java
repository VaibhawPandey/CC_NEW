package main.java.Leetcode.WeeklyContest.WC203;

import java.util.Arrays;

public class MacCoins {

    public static void main(String[] args) {
        new MacCoins().maxCoins(new int[] {11});
    }

    public int maxCoins(int[] piles) {

        Arrays.sort(piles);
        int bob = -1;
        int res = 0;

        for (int i = piles.length - 2; i > bob && i >= 0; i = i - 2) {

            res += piles[i];
            bob++;
        }

        return res;
    }
}
