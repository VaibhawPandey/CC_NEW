package main.java.Leetcode.MonthlyLC.LC2021.NovemberLeetcodingChallenge.Week4;

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
