package main.java.Leetcode.MonthlyLC.NovemberLeetcodingChallenge.Week4;

import java.util.HashSet;
import java.util.Set;

public class SmallestIntegerDByK {
    public static void main(String[] args) {
        new SmallestIntegerDByK().smallestRepunitDivByK(15);
    }
    public int smallestRepunitDivByK(int K) {

        if (K % 2 == 0 || K % 5 == 0) return -1;

        long num = 1, k = 1;
        while (k <= K) {

            long temp = num % K;

            if (temp == 0)
                return String.valueOf(num).length();

            num = (num * 10) + 1;
            k++;
        }

        return -1;
    }
}
