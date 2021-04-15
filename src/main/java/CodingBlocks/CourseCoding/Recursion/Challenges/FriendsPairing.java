package main.java.CodingBlocks.CourseCoding.Recursion.Challenges;

import java.util.Scanner;

public class FriendsPairing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int maxN = 30;
        long p[] = new long[maxN+1];
        p[0] = 0; p[1] = 1; p[2] = 2;

        for (int i = 3; i <= maxN; i++)
            p[i] = p[i-1] + (i-1) * p[i-2];

        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            System.out.println(p[n]);
        }
        scanner.close();
    }
}
