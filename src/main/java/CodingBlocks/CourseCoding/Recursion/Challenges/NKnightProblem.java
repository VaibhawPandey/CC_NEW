package main.java.CodingBlocks.CourseCoding.Recursion.Challenges;

import java.util.Scanner;

public class NKnightProblem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), count = 0;
        int direction[][] = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {2, -1}, {2, 1}, {1, 2}};
        int board[][] = new int[n][n];
        // for (int i = 0; i < n; i++) {
           // for (int j = 0; j < n; j++) {
                if (iterateKnight(board, 0, 0, n, direction, n))
                    count++;
           // }
        // }
        System.out.println();
        System.out.print(count);
        scanner.close();
    }

    private static boolean iterateKnight(int[][] board, int i, int j, int len, int[][] direction, int n) {
        if (len == 0) {
            printboardPos(board);
            return true;
        }

        if (i == n) return iterateKnight(board, 0, 0, len, direction, n);

        if (j==n) {
            return iterateKnight(board, i + 1, 0, len, direction, n);
        }

        if (board[i][j] != 0) {
            return iterateKnight(board, i, j + 1, len, direction, n);
        }


        board[i][j] = 1;
        for (int k = 0; k < direction.length; k++) {
            int p = i + direction[k][0], q = j + direction[k][1];
            if (isValidMove(p, q, n))
                board[p][q] = 2;
        }
        boolean res = iterateKnight(board, i, j + 1, len - 1, direction, n);
        board[i][j] = 0;
        for (int k = 0; k < direction.length; k++) {
            int p = i + direction[k][0], q = j + direction[k][1];
            if (isValidMove(p, q, n))
                board[p][q] = 0;
        }

        return res;
    }

    private static boolean isValidMove(int p, int q, int n) {
        if (p < 0 || q < 0 || p >= n || q >= n)
            return false;

        return true;
    }

    private static void printboardPos(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 1)
                System.out.print("{" + i + "-" + j + "}");
            }
        }
        System.out.print(" ");
    }
}
