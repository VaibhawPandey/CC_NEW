package main.java.CodingBlocks.CourseCoding.Recursion.Challenges;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class MinimumTimeTreversal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {

            int n = scanner.nextInt();
            int input[][] = new int[n][5];
            int sx = scanner.nextInt(), sy = scanner.nextInt(), ex = scanner.nextInt(), ey = scanner.nextInt();
            for (int i = 0; i < n; i++) {
                input[i][0] = scanner.nextInt();
                input[i][1] = scanner.nextInt();
                input[i][2] = scanner.nextInt();
                input[i][3] = scanner.nextInt();
                input[i][4] = scanner.nextInt();
            }

            Arrays.sort(input, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return (o1[0] > o2[0] && o1[1] > o2[1]) ? 1: -1;
                }
            });

            System.out.println(input);
        }
        scanner.close();
    }
}
