package main.java.CodingBlocks.CourseCoding.Recursion.Challenges;

import java.util.Scanner;

public class NQueenCount {
    static int count = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int board[][] = new int[n][n];

        placeQueen(board, 0, n);

        System.out.println(count);
    }

    private static boolean placeQueen(int[][] board, int i, int n) {
        if (i == n) {
            return true;
        }

        // if (i == n) return placeQueen(board, 0, n, noOfQueens);
        // if (j == n) return placeQueen(board, i + 1, 0, n);

        for (int k = 0; k < n; k++) {
            if (isSafe(board, i, k, n)) {
                board[i][k] = 1;
                boolean isPlaced = placeQueen(board, i + 1, n);
                if (isPlaced) count++;
                board[i][k] = 0;
            }
        }

        return false;
    }

    private static boolean isSafe(int[][] board, int i, int j, int n) {

        for (int k = 0; k < n; k++) {
            if (board[k][j] == 1)
                return false;
        }

        int p = i-1, q = j-1;
        while (isValidPosition(board, p, q, n)) {
            if (board[p][q] == 1)
                return false;
            p--; q--;
        }

        p = i-1; q = j + 1;
        while (isValidPosition(board, p, q, n)) {
            if (board[p][q] == 1)
                return false;
            p--; q++;
        }

        return true;
    }

    private static boolean isValidPosition(int[][] board, int p, int q, int n) {
        if (p < 0 || q < 0 || p >= n || q >= n)
            return false;

        return true;
    }
}
