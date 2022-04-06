package main.java.Leetcode.MonthlyLC.LC2021.OctoberLeetcodingChallenge.Week1;

public class BitwiseComplement {

    public int bitwiseComplement(int N) {

        if (N == 0)
            return 1;

        int bitLen = (int) (Math.log(N)/Math.log(2) + 1);
        int bit = (1 << bitLen) - 1; // Ex:- 16-1 = 15 == 1111 so we can XOR this with N to get result.

        return N ^ bit; // Since number and its complement & is always '11....11', so N xor bit
    }
//    public int bitwiseComplement(int N) {
//
//        if (N == 0)
//            return 0;
//
//        char binaryBits[] = Integer.toBinaryString(N).toCharArray();
//
//        for (int i = 0; i < binaryBits.length; i++)
//            binaryBits[i] = binaryBits[i] == '1' ? '0': '1';
//
//        return Integer.parseInt(new String(binaryBits), 2);
//    }
}
