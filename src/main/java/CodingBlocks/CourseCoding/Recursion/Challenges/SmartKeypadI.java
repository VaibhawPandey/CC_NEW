package main.java.CodingBlocks.CourseCoding.Recursion.Challenges;

import java.util.Scanner;

public class SmartKeypadI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String table[] = { " ", ".+@$", "abc", "def", "ghi", "jkl" , "mno", "pqrs" , "tuv", "wxyz" };
        char n[] = scanner.next().toCharArray();
        recurString(n, "", table, 0, n.length);
        scanner.close();
    }

    private static void recurString(char n[], String subRes, String[] table, int pos, int len) {
        if (pos == len) {
            System.out.println(subRes);
            return;
        }

        int rem = n[pos] - '0';
        if (rem == 0) {
            recurString(n, subRes, table, pos + 1, len);
            return;
        }

        char str[] = table[rem].toCharArray();
        for (int i = 0; i < str.length; i++) {
            recurString(n, subRes + str[i], table, pos + 1, len);
        }
    }
}
