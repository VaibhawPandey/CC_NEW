package main.java.Codechef.MonthlyContest.August2020Contest;

import java.util.Scanner;

public class CardGame {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {

            // System.out.println();
           int num1 = scanner.nextInt();
           int num2 = scanner.nextInt();

           num1 = num1 % 9 == 0 ? (num1 / 9) : (num1 / 9) + 1;
           num2 = num2 % 9 == 0 ? (num2 / 9) : (num2 / 9) + 1;

            if (num1 == num2)
                System.out.println("1 " +num1);
            else if (num1 > num2)
                System.out.println("0 " +num1);
            else
                System.out.println("1 " +num2);

        }
    }
}
