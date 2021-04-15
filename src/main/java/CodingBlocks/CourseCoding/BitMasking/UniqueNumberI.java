package main.java.CodingBlocks.CourseCoding.BitMasking;

import java.util.Scanner;

public class UniqueNumberI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        if (n == 0)
            return;
        int arr[] = new int[n];
        int res = 0;
        for (int i = 0; i < n; i++)
            if (i == 0)
                res = scanner.nextInt();
            else
                res = res ^ scanner.nextInt();

        System.out.println(res);
    }
}
