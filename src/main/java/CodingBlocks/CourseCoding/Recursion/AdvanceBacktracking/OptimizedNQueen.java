package main.java.CodingBlocks.CourseCoding.Recursion.AdvanceBacktracking;

import java.util.Scanner;

import static main.java.CodingBlocks.CourseCoding.Recursion.BackTracking.NQueenProblem.printBoard;

public class OptimizedNQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int board[][] = new int[n][n];
        int count = 2 * (n-1);
        int c[] = new int[count + 1];
        int d[] = new int[count + 1];
        int col[] = new int[n];
        int cnt[] = {0};
        qQueenMove(board, c, d, col, 0, n, cnt);
        // printBoard(board);
        System.out.println(cnt[0]);
        scanner.close();
    }

    private static boolean qQueenMove(int[][] board, int[] c, int[] d, int[] col, int i, int n, int count[]) {
        if (i == n) {
            count[0]++;
            return true;
        }

        for (int j = 0; j < n; j++) {
            if (col[j] != 1 && c[i + j] != 1 && d[i - j + n - 1] != 1) {
                board[i][j] = col[j] = c[i + j] = d[i - j + n - 1] = 1;
                boolean isPossible = qQueenMove(board, c, d, col, i + 1, n, count);
                // if (isPossible) return true;
                board[i][j] = col[j] = c[i + j] = d[i - j + n - 1] = 0;
            }
        }

        return false;
    }
}
