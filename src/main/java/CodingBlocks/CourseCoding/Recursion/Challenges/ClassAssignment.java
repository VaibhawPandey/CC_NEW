package main.java.CodingBlocks.CourseCoding.Recursion.Challenges;

import java.util.Scanner;

public class ClassAssignment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int maxN = 25;
        long ans[][] = new long[maxN + 1][2];

        ans[1][0] = 1;
        ans[1][1] = 1;
        for (int i = 2; i <= maxN; i++) {
            ans[i][0] = ans[i-1][0] + ans[i-1][1];
            ans[i][1] = ans[i-1][0];
        }

        int t = scanner.nextInt();
        int count = 1;
        while (t-- > 0) {
            int n = scanner.nextInt();
            System.out.println("#" + (count++) + " : " + (ans[n][0] + ans[n][1]));
        }

        scanner.close();
    }
}
