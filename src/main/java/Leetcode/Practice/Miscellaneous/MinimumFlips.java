package main.java.Leetcode.Practice.Miscellaneous;

import java.util.Scanner;

public class MinimumFlips {
    /*
    *  In this problem we need to check total number of flips from '0' to '1'
    *  in the target string because when a position is changed all the char after it change together
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String target = scanner.next();
        char charTarget[] = target.toCharArray();
        // Check base condition
        if (charTarget.length == 0) {
            System.out.println(0);
            return;
        }

        int flip = 0;
        char base = 1;
        for (int i = 0; i < charTarget.length; i++) {

            if (base != charTarget[i]) {
                flip++;
                base = charTarget[i];
            }
        }

        System.out.println(flip);
    }
}
