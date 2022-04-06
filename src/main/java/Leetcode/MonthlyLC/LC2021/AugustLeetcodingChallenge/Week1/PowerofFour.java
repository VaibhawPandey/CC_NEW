package main.java.Leetcode.MonthlyLC.AugustLeetcodingChallenge.Week1;

public class PowerofFour {

    public static void main(String[] args) {
        System.out.println(new PowerofFour().isPowerOfFour(4));
    }
    public boolean isPowerOfFour(int num) {

        return num > 0 && (num & (num - 1)) == 0 && (num & 0X5555555) != 0;
    }
}
