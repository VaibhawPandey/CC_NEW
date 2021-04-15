package main.java.Codechef.MonthlyContest.December2020Contest;

import java.util.Scanner;

public class VaccineDistribution {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {

            int n = scanner.nextInt();
            int d = scanner.nextInt();

            if (d == 1) {
                for (int i = 0; i < n; i++)
                scanner.nextInt();

                System.out.println(n);
                continue;
            }

            int riskPersonCount = 0;
            for (int i = 0; i < n; i++) {
                int temp = scanner.nextInt();
                if (temp <= 9 || temp >= 80)
                    riskPersonCount++;
            }

            int normalPersonCount = n - riskPersonCount;
            int result = (int) Math.ceil((double) normalPersonCount/ (double) d) + (int) Math.ceil((double) riskPersonCount/ (double) d);
            System.out.println(result);
        }
    }
}
