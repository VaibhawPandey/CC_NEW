package main.java.Leetcode.MonthlyLC.LC2021.DecemberLeetcodingChallenge.Week1;

public class SpiralMatrix {
    public static void main(String[] args) {
        int n = 4;
        int res[][] = new SpiralMatrix().generateMatrix(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(res[i][j] + " ");
            System.out.println();
        }
    }
    int res[][];
    int num = 1;
    public int[][] generateMatrix(int n) {

        res = new int[n][n];
        solve(0, 0, n);
        return res;
    }

    private void solve(int posX, int posY, int n) {

        int direction[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        boolean isDone = false;
        while (!isDone) {
            isDone = true;

            while (isValid(posX, posY, n) && res[posX][posY] == 0) {
                res[posX][posY] = num;
                num++;
                posY++;
                isDone = false;
            }

            posY--;
            posX++;

            while (isValid(posX, posY, n) && res[posX][posY] == 0) {
                res[posX][posY] = num;
                num++;
                posX++;
                isDone = false;
            }

            posX--;
            posY--;

            while (isValid(posX, posY, n) && res[posX][posY] == 0) {
                res[posX][posY] = num;
                num++;
                posY--;
                isDone = false;
            }

            posY++;
            posX--;

            while (isValid(posX, posY, n) && res[posX][posY] == 0) {
                res[posX][posY] = num;
                num++;
                posX--;
                isDone = false;
            }

            posX++;
            posY++;
        }
    }


//    private void solve(int posX, int posY, int n) {
//
//        if (!isValid(posX, posY, n) || res[posX][posY] != 0)
//            return;
//
//        res[posX][posY] = num;
//        num++;
//
//        solve(posX, posY + 1, n);
//        solve(posX + 1, posY, n);
//        solve(posX, posY - 1, n);
//        solve(posX - 1, posY, n);
//    }

    private boolean isValid(int posX, int posY, int n) {

        if (posX < 0 || posX >= n || posY < 0 || posY >= n)
            return false;

        return true;
    }
}
