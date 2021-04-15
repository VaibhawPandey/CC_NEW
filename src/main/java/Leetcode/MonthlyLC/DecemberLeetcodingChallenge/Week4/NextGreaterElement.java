package main.java.Leetcode.MonthlyLC.DecemberLeetcodingChallenge.Week4;

import java.util.Arrays;

public class NextGreaterElement {
    public static void main(String[] args) {
        System.out.println(new NextGreaterElement().nextGreaterElement(99999999));
    }

    public int nextGreaterElement(int n) {
        int dec_pos = -1;
        char num[] = (n + "").toCharArray();

        for (int i = 0; i < num.length; i++) {
            while (i < num.length - 1 && num[i] > num[i+1])
                i++;

            if (i < num.length - 1)
                dec_pos = i;
        }

        if (dec_pos == -1)
            return -1;

        Arrays.sort(num, dec_pos + 1, num.length);

        for (int i = dec_pos + 1; i < num.length; i++) {
            if (num[i] > num[dec_pos]) {
                char c = num[dec_pos];
                num[dec_pos] = num[i];
                num[i] = c;
                break;
            }
        }

        long res = Long.parseLong(new String(num));
        return res >= Integer.MAX_VALUE ? -1: (int) res;
    }
}
