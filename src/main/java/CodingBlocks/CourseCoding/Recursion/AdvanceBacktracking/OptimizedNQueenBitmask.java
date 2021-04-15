package main.java.CodingBlocks.CourseCoding.Recursion.AdvanceBacktracking;

import java.util.Scanner;

public class OptimizedNQueenBitmask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int done = ((1<<n) - 1);
        int ans[] = {0};
        solveNQueen(0, 0, 0, done, ans);
        System.out.println(ans[0]);
        scanner.close();
    }

    private static void solveNQueen(int rowMask, int l, int r, int done, int ans[]) {
        if (rowMask == done) {
            ans[0]++;
            return;
        }

        int posLeft = done & (~(rowMask | l | r));
        while (posLeft > 0) {
            int p = posLeft & (-posLeft);
            posLeft -= p;
            solveNQueen(rowMask | p, (l | p) << 1, (r | p) >> 1, done, ans);
        }
    }
}
