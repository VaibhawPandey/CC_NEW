package main.java.Leetcode.WeeklyContest.WC206;

public class SPInBinaryMatrix {
    public static void main(String[] args) {
        new SPInBinaryMatrix().numSpecial(new int[][]{{0,0,0,0,0,0,0,0,0,0},{0,1,0,0,0,0,1,0,0,0},{1,0,0,1,0,0,0,1,0,0},{0,0,0,0,0,1,0,0,0,1}});
    }
    public int numSpecial(int[][] mat) {
        int count = 0;

        for (int i = 0; i < mat.length; i++) {
            boolean appeared = false;
            boolean added = false;
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) {
                    if (!appeared && columnCheck(i, j, mat, mat.length)) {
                        added = true;
                        count++;
                    } else if (appeared) {
                        if (added)
                            count--;
                        break;
                    }

                    appeared = true;
                }
            }
        }

        return count;
    }

    private boolean columnCheck(int i, int j,int[][] mat, int size) {
        for (int k = 0; k < size; k++) {
            if (k != i) {
                if (mat[k][j] == 1)
                    return false;
            }
        }

        return true;
    }
}
