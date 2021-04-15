package main.java.Leetcode.WeeklyContest.WC200;

import java.util.*;

public class WinnerInArrayGame {

    public int getWinner(int[] arr, int k) {
        int winner = arr[0];
        int win_Count = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < winner)
                win_Count++;
            else {
                winner = arr[i];
                win_Count = 1;
            }

            if (win_Count == k)
                return winner;
        }

        return winner;
    }
}
