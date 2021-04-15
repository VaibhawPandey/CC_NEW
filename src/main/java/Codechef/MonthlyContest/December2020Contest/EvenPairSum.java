package main.java.Codechef.MonthlyContest.December2020Contest;

import java.util.Scanner;

public class EvenPairSum {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {

            int A = scanner.nextInt(), B = scanner.nextInt();
            int evenA = A/2, oddA = (int) Math.ceil((double) A/2);
            int evenB = B/2, oddB = (int) Math.ceil((double) B/2);

            long result = (evenA * evenB) + (oddA * oddB);
            System.out.println(result);
        }
    }
}
