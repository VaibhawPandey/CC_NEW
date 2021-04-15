package main.java.CodingBlocks.CourseCoding.Recursion.Challenges;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RecursionCode {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<String> resList = new ArrayList<String>();
        recurString(n, String.valueOf(n).length() - 1, "", resList);
        scanner.close();
        System.out.println(resList);
    }

    private static void recurString(int n, int len, String subRes, List<String> res) {
        if (len <= 0) {
            res.add(subRes);
            return;
        }

        int temp = (int) Math.pow(10, len);
        if (n / temp != 0) recurString(n % temp, len - 1, subRes + (char) ('a' - 1 + n / temp), res);
        temp = (int) Math.pow(10, len - 1);
        if (len > 0 && (n / temp) <= 26) recurString(n % temp, len - 2, subRes + (char) ('a' - 1 + n / temp), res);
    }
}
