package main.java.CodingBlocks.CourseCoding.Recursion.Challenges;

import java.util.Scanner;

public class RobotCollectPoint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int grid[][] = new int[n][5];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 5; j++) {
                    grid[i][j] = scanner.nextInt();
                }
            }
            int res = 0, loopCount = 0;
            // do {
                // printGrid(grid, n, 5);
                updateGrid(grid, n-5, n);
                int visited[][] = new int[n][5];
                int direction[][] = {{-1, -1}, {-1, 0}, {-1, 1}};
                int sum = 0, i = n, j = 2;
                for (int d = 0; d < direction.length; d++) {
                    int p = i + direction[d][0], q = j + direction[d][1];
                    if (visited[p][q] == 0)
                        sum += getSum(grid, visited, p, q, n, 0, direction);
                }
                // res = Math.max(res, sum);
                // printGrid(grid, n, 5);
                // loopCount++;
            // } while (loopCount + 5 < n);
            System.out.println(sum);
        }
        scanner.close();
    }

    private static int[][] updateGrid(int[][] grid, int start, int end) {
        for (int i = start; i < end; i++) {
            for (int j = 0; j < 5; j++) {
               if (grid[i][j] == -1) grid[i][j] = 0;
            }
        }

        return grid;
    }

    private static void printGrid(int[][] grid, int m, int n) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int getSum(int[][] grid, int[][] visited, int p, int q, int n, int sum, int[][] direction) {

        visited[p][q] = 1;
        // grid[p][q] = (p >= start && p < end && grid[p][q] == -1) ? 0: grid[p][q];
         sum += grid[p][q];
        // sum += grid[p][q];
        for (int i = 0; i < direction.length; i++) {
            int r = p + direction[i][0], s = q + direction[i][1];
            if (isValid(r, s, n) && visited[r][s] == 0)
                sum = getSum(grid, visited, r, s, n, sum, direction);
        }

        return sum;
    }

    private static boolean isValid(int p, int q, int n) {
        if (p < 0 || q < 0 || p >= n || q >= 5)
            return false;

        return true;
    }
}
