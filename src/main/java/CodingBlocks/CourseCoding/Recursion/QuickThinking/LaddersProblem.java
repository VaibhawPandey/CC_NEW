package main.java.CodingBlocks.CourseCoding.Recursion.QuickThinking;

import java.util.Scanner;

public class LaddersProblem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        // Number of steps user can climb at once
        int step = scanner.nextInt();
        System.out.println(numberOfSteps(0, n, step));
        scanner.close();
    }

    private static int numberOfSteps(int k, int n, int step) {
        if (k == n)
            return 1;

        if (k > n)
            return 0;

        int res = 0;
        for (int i = 1; i <= step; i++) {
            res += numberOfSteps(k + i, n, step);
        }

        return res;
    }

}
