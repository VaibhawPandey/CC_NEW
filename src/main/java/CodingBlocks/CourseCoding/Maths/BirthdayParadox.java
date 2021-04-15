package main.java.CodingBlocks.CourseCoding.Maths;

import java.util.Scanner;

public class BirthdayParadox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float n = scanner.nextFloat(), cnt = 365, denom = 365, p = 1;
        int  noOfPeople = 0;

        if (n == 1.0) {
            System.out.println(366);
            return;
        }

        while (p > (1 - n)) {
            p = p * (cnt) / denom;
            cnt--;
            noOfPeople++;
        }

        System.out.println(noOfPeople);
    }
}
