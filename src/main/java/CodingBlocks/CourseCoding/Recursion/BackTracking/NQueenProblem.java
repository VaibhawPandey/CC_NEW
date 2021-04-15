package main.java.CodingBlocks.CourseCoding.Recursion.BackTracking;

import java.util.Scanner;

public class NQueenProblem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int board[][] = new int[n][n];
        placeQueen(board, 0);
        printBoard(board);
        scanner.close();
    }

    private static boolean placeQueen(int[][] board, int i) {
        if (i == board.length)
            return true;

        for (int k = 0; k < board.length; k++) {
            if (isValidMove(board, i, k)) {
                board[i][k] = 1;
                boolean isCorrect = placeQueen(board, i + 1);
                if (isCorrect) return true;
                board[i][k] = 0;
            }
        }

        return false;
    }

    private static boolean isValidMove(int[][] board, int i, int j) {

        // Check horizontally up
        for (int k = 0; k < i; k++) {
            if (board[k][j] == 1)
                return false;
        }

        // Check diagonally left
        int k = i - 1, l = j - 1;
        while (isValid(k, l, board.length, board[0].length)) {
            if (board[k][l] == 1)
                return false;
            k--;
            l--;
        }

        // Check diagonally right
        k = i - 1;
        l = j + 1;
        while (isValid(k, l, board.length, board[0].length)) {
            if (board[k][l] == 1)
                return false;
            k--;
            l++;
        }

        return true;
    }

    private static boolean isValid(int k, int j, int m, int n) {
        if (k < 0 || k >= m || j < 0 || j >= n)
            return false;

        return true;
    }

    public static void printBoard(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
