package main.java.CodingBlocks.CourseCoding.Recursion.QuickThinking;

import java.util.Scanner;

public class TowerofHanoi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        move(n, 'A', 'B', 'C');
    }

    private static void move(int n, char src, char helper, char dest) {

        if (n == 0)
            return;

        move(n-1, src, dest, helper);
        System.out.println("Shift disk " + n + " from " + src + " to " + dest);
        move(n-1, helper, src, dest);
    }
}
