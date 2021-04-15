package main.java.CodingBlocks.CourseCoding.Recursion.Challenges;

import java.util.Scanner;

public class FunkyChessBoard {
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[][] = new int[n][n];
        int startX = -1, startY = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = scanner.nextInt();
                if (startX == -1 && arr[i][j] != 0) {
                    startX = i; startY = j;
                }
            }
        }
        int[][] direction = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {2, -1}, {2, 1}, {1, 2}};
        arr[startX][startY] = 2;
        new FunkyChessBoard().updateChessBoardFlow(arr, startX, startY, n, direction);
        // System.out.println(getRes(arr, n));
        System.out.println(min);
        scanner.close();
    }

    private static int getRes(int[][] arr, int n) {
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
               if (arr[i][j] == 1) res++;
            }
        }

        return res;
    }

    private void updateChessBoardFlow(int[][] arr, int i, int j, int n, int[][] direction) {
        for (int k = 0; k < direction.length; k++) {
            int p = i + direction[k][0], q = j + direction[k][1];
            if (isValidMove(p, q, n) && arr[p][q] == 1) {
                arr[p][q] = 2;
                updateChessBoardFlow(arr, p, q, n, direction);
                min = Math.min(min, getRes(arr, n));
                arr[p][q] = 1;
            }
        }
    }

    private static boolean isValidMove(int i, int j, int n) {
        if (i < 0 || j < 0 || i >= n || j >= n)
            return false;

        return true;
    }
}
