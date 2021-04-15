package main.java.CodingBlocks.CourseCoding.Recursion.Challenges;

import java.util.Scanner;

public class RatInAMaze {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        char board[][] = new char[n][m];
        int startX = -1, startY = -1;
        for (int i = 0; i < n; i++) {
           String temp = scanner.next();
            for (int j = 0; j < m; j++) {
                board[i][j] = temp.charAt(j);
                if (startX == -1 && board[i][j] != 'X') {
                    startX = i; startY = j;
                }
            }
        }

        int visited[][] = new int[n][m];
        boolean isPossible = findPath(board, visited, startX, startY, n, m);
        if (isPossible) printGrid(visited, n, m);
        else System.out.println("-1");
        scanner.close();
    }

    private static boolean findPath(char[][] board, int[][] visited, int i, int j, int n, int m) {
        if (i == n-1 && j == m-1) {
            visited[i][j] = 1;
            return true;
        }

        if (j == m) return findPath(board, visited, i + 1, j - 1, n, m);
        if (i >= n || board[i][j] == 'X') return false;

        visited[i][j] = 1;
        boolean foundPath = findPath(board, visited, i, j + 1, n, m) || findPath(board, visited, i + 1, j, n, m);
        if (foundPath) return true;
        visited[i][j] = 0;

        return false;
    }

    private static void printGrid(int[][] grid, int m, int n) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}
