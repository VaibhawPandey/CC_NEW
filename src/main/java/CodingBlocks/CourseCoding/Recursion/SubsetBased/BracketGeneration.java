package main.java.CodingBlocks.CourseCoding.Recursion.SubsetBased;

import java.util.Scanner;

public class BracketGeneration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        recurBracket(0, 0, n, "");
        scanner.close();
    }

    private static void recurBracket(int open, int close, int n, String subRes) {

        if (close == n) {
            System.out.println(subRes);
            return;
        }

        if (open < n) recurBracket(open + 1, close, n, subRes + "(");
        if (close < open) recurBracket(open, close + 1, n, subRes + ")");
    }
}
