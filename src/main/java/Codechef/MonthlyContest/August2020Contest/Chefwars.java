package main.java.Codechef.MonthlyContest.August2020Contest;

import java.util.Scanner;

public class Chefwars {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {

            int d = scanner.nextInt();
            int h = scanner.nextInt();
            int mid = (int) Math.ceil(d/2);
            System.out.println( h > mid ? 1: 0);

        }

    }
}
