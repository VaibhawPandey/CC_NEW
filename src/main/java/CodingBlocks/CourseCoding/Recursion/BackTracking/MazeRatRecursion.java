package main.java.CodingBlocks.CourseCoding.Recursion.BackTracking;

import java.util.Scanner;

public class MazeRatRecursion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt(), n = scanner.nextInt();
        int maze[][] = new int[m][n];

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                maze[i][j] = scanner.nextInt();
            }

        maze[0][0] = 1;
        allPaths(maze, 0, 0, m, n);
        scanner.close();
    }

    private static void allPaths(int[][] maze, int i, int j, int m, int n) {
        if (i == m-1 && j == n-1) {
            printMaze(maze);
            System.out.println();
            return;
        }

        if (isValid(i + 1, j, m, n) && maze[i+1][j] != -1) {
            maze[i+1][j] = 1;
            allPaths(maze, i+1, j, m, n);
            maze[i+1][j] = 0;
        }
        if (isValid(i, j + 1, m , n) && maze[i][j+1] != -1) {
            maze[i][j+1] = 1;
            allPaths(maze, i, j+1, m, n);
            maze[i][j+1] = 0;
        }
    }

    private static boolean isValid(int i, int j, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= n)
            return false;

        return true;
    }

    private static void printMaze(int[][] maze) {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
    }
}
