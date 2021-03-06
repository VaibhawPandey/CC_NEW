package main.java.Leetcode.MonthlyLC.LC2021.JulyLeetcodingChallenge.Week2;

public class ReverseBits {

    public static void main(String[] args) {
        System.out.println(new ReverseBits().reverseBits(43261596));
    }

    public int reverseBits(int n) {

        int result = 0;

        for (int i = 0; i < 32; i++) {
            result += n & 1;
            n = n >>> 1;

            if (i < 31)
                result = result << 1;
        }

        return result;
    }
}
