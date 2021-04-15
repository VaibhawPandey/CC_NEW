package main.java.Leetcode.MonthlyLC.SeptemberLeetcodingChallenge.Week3;

public class UniquePath3 {
    public static void main(String[] args) {
        System.out.println(new UniquePath3().uniquePathsIII(new int[][]{{1,0,0,0},{0,0,0,0},{0,0,0,2}}));
    }
    int count = 0, zeroCount = 0;
    public int uniquePathsIII(int[][] grid) {

        int direction[][] = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int startX = -1, startY = -1, endX = -1, endY = -1;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0)
                    zeroCount++;
                else if (grid[i][j] == 1) {
                    startX = i; startY = j;
                }
            } }

        uniquePathRecursive(grid, startX, startY, direction);

        return count;
    }

    private void uniquePathRecursive(int[][] grid, int startX, int startY, int[][] direction) {
        // boolean res = false;
        if (grid[startX][startY] == 2) {
            if (zeroCount == -1) count++;
            return;
            // return;
        }

        grid[startX][startY] = 1;

        zeroCount--;
        for (int i = 0; i < direction.length; i++) {
            int p = startX + direction[i][0], q = startY + direction[i][1];

            if (isValid(p, q, grid.length, grid[0].length) && (grid[p][q] == 0 || grid[p][q] == 2)) {
                int temp = grid[p][q];
                uniquePathRecursive(grid, p, q, direction);
                grid[p][q] = temp;
            }
        }
        zeroCount++;

        // return res;
    }

    private boolean isValid(int x, int y,int m, int n) {

        if (x < 0 || x >= m || y < 0 || y >= n)
            return false;

        return true;
    }


}
