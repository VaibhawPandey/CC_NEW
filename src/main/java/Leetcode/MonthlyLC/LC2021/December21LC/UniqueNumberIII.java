package main.java.Leetcode.MonthlyLC.December21LC;

public class UniqueNumberIII {
    int count = 0;
    public static void main(String[] args) {
        new UniqueNumberIII().uniquePathsIII(new int[][]{{1,0,0,0},{0,0,0,0},{0,0,2,-1}});
        System.out.println(new UniqueNumberIII().count);
    }
    public int uniquePathsIII(int[][] grid) {
        int srcX = -1, srcY = -1;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    srcX = i; srcY = j;
                    break;
                }
            }

        int direction[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        // boolean visited[][] = new boolean[grid.length][grid[0].length];

        findPath(grid, srcX, srcY, direction, srcX, srcY);

        return count;
    }

    private boolean findPath(int[][] grid, int srcX, int srcY, int[][] direction, int mainSrcX, int mainSrcY) {
        if (grid[srcX][srcY] == 2) return true;

        for (int i = 0; i < direction.length; i++) {
            int p = srcX + direction[i][0], q = srcY + direction[i][1];

            if (isValid(p, q, grid.length, grid[0].length) && (grid[p][q] == 0 || grid[p][q] == 2)) {
                grid[p][q] = grid[p][q] == 0 ? 3 : 2;
                boolean res = findPath(grid, p, q, direction, mainSrcX, mainSrcY);
                if (res) {
                    if (mainSrcX == srcX && mainSrcY == srcY) count++;
                    return true;
                }
                grid[p][q] = 0;
            }
        }

        return false;
    }

    private boolean isValid(int p, int q, int m, int n) {
        if (p < 0 || q < 0 || p >= m || q >= n) return false;

        return true;
    }
}
