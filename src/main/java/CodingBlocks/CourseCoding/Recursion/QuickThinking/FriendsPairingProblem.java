package main.java.CodingBlocks.CourseCoding.Recursion.QuickThinking;

import java.util.Scanner;

public class FriendsPairingProblem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        System.out.println(recurseFriend(n));
    }

    private static int recurseFriend(int n) {
        if (n == 0) return 1;

        if (n < 0) return 0;

        return recurseFriend(n-1) + (n-1) * recurseFriend(n-2);
    }
}
