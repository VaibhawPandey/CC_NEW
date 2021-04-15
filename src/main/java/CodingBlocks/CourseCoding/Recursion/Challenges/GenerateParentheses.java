package main.java.CodingBlocks.CourseCoding.Recursion.Challenges;

import java.util.Scanner;

public class GenerateParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        recurParen(n, 0, 0, "");
        scanner.close();
    }

    private static void recurParen(int n, int open, int close, String subRes) {
        if (close == n) {
            System.out.println(subRes);
            return;
        }

        if (close < open) recurParen(n, open, close + 1, subRes + ')');
        if (open < n) recurParen(n, open + 1, close, subRes + '(');

    }
}
