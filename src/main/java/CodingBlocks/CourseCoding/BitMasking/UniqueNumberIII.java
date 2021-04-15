package main.java.CodingBlocks.CourseCoding.BitMasking;

import java.util.Scanner;

public class UniqueNumberIII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int temp;
        int cnt[] = new int[64];
        for (int i = 0; i < n; i++) {
            temp = scanner.nextInt();
            int j = 0;
            while (temp > 0) {
                if ((temp&1) == 1)
                    cnt[j]++;
                j++;
                temp = temp >> 1;
            }
        }

        int res = 0;
        for (int i = 0; i < 64; i++) {
            res += (cnt[i] % 3) == 1 ? Math.pow(2, i): 0;
        }

        System.out.println(res);
    }
}
