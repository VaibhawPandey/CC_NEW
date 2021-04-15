package main.java.Leetcode.WeeklyContest.WC218;

public class ConBinaryNumber {
    public static void main(String[] args) {
        System.out.println(new ConBinaryNumber().concatenatedBinary(42));
    }
    public int concatenatedBinary(int n) {

        int pow = (int) Math.pow(2, 0);
        int k = 0;
        long res = 0;

        for (int i = 1; i <= n; i++) {
            if (i >= pow) {
                k++;
                pow = (int) Math.pow(2, k);
            }

            res = (res << k) + i;
        }

        return (int) (res % 1000000007);
    }
}
