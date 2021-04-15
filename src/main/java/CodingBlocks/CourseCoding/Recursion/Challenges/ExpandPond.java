package main.java.CodingBlocks.CourseCoding.Recursion.Challenges;

import java.util.Scanner;

public class ExpandPond {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt(), n = scanner.nextInt();
        int arr[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                arr[i][j] = scanner.nextInt();
        }

        int max = Integer.MIN_VALUE;
        int direction[][] = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1) {
                    arr[i][j] = 2;
                    max = Math.max(max, getRes(arr, i, j, m, n,  0, 0, direction));
                    arr[i][j] = 1;
                } }
        }
        System.out.println(max);
        scanner.close();
    }

    private static int getRes(int[][] arr, int i, int j, int m, int n, int noOfNeighbours, int maxNeighbours, int[][] direction) {
        // Base Case
        maxNeighbours = Math.max(maxNeighbours, noOfNeighbours);

        // Code
        for (int k = 0; k < direction.length; k++) {
            int p = i + direction[k][0], q = j + direction[k][1];
            if (isValidMove(p, q, m, n) && arr[p][q] == 0) {
                 arr[p][q] = 2;
                 maxNeighbours = getRes(arr, p, q, m, n, noOfNeighbours + 1, maxNeighbours, direction);
                 arr[p][q] = 0;
            }
        }

        return maxNeighbours;
    }

    private static boolean isValidMove(int i, int j, int m, int n) {
        if (i < 0 || j < 0 || i >= m || j >= n)
            return false;

        return true;
    }
}
