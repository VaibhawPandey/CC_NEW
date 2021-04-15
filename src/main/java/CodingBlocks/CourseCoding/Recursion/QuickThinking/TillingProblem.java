package main.java.CodingBlocks.CourseCoding.Recursion.QuickThinking;

import java.util.Scanner;

public class TillingProblem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        System.out.println(tillingProblemRecur(n));
    }

    private static int tillingProblemRecur(int n) {
        if (n <= 3)
            return 1;

        return tillingProblemRecur(n-1) + tillingProblemRecur(n-4);
    }
}
