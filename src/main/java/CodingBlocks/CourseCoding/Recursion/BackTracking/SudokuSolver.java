package main.java.CodingBlocks.CourseCoding.Recursion.BackTracking;

import java.util.Scanner;

public class SudokuSolver {
    public static void main(String[] args) {
        int grid[][] = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
                { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
                { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };

        solveSuduko(grid, 3, 9, 0, 0);
        printSuduko(grid);
    }

    private static void printSuduko(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean solveSuduko(int[][] grid, int gridSize, int n, int i, int j) {
        if (i == n) return true;

        if (j == n) return solveSuduko(grid, gridSize, n, i + 1, 0);
        if (grid[i][j] != 0) return solveSuduko(grid, gridSize, n, i, j+1);

        for (int k = 1; k <= 9; k++) {
            if (isAvailable(grid, gridSize, k, i, j)) {
                grid[i][j] = k;
                boolean isSolved = solveSuduko(grid, gridSize, n, i, j+1);
                if (isSolved) return true;
                grid[i][j] = 0;
            }
        }
        return false;
    }

    private static boolean isAvailable(int[][] grid, int gridSize, int num, int i, int j) {
        // Check row
        for (int k = 0; k < grid.length; k++) {
            if (grid[i][k] == num)
                return false;
        }

        // Check column
        for (int k = 0; k < grid.length; k++) {
           if (grid[k][j] == num)
               return false;
        }

        int gridStartX = (int) (Math.floor(i/gridSize) * gridSize), gridStartY = (int) (Math.floor(j/gridSize) * gridSize);
        for (int k = gridStartX; k < gridStartX + gridSize; k++) {
            for (int l = gridStartY; l < gridStartY + gridSize; l++) {
                if (grid[k][l] == num)
                    return false;
            }
        }

        return true;
    }
}
