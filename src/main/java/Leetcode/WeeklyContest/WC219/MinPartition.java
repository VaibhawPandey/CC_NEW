package main.java.Leetcode.WeeklyContest.WC219;

public class MinPartition {
    public static void main(String[] args) {
        System.out.println(new MinPartition().minPartitions("82734"));
    }

    public int minPartitions(String n) {

        int res = 0;
        boolean flag = true;
        char nChar[] = n.toCharArray();

        while (flag) {
            flag = false;
            for (int i = 0; i < n.length(); i++) {

                if (nChar[i]-48 > 0) {
                    nChar[i]--;
                    flag = true;
                }
            }

            res++;
        }

        return res-1;
    }
//    public int minPartitions(String n) {
//
//        int res = 0;
//        long num = Long.parseLong(n);
//
//        while (num != 0) {
//
//            long temp = num, p = 1, m = 0;
//            while (temp != 0) {
//
//                long rem = temp % 10;
//                temp /= 10;
//
//                if (rem != 0) m += p;
//
//                p *= 10;
//            }
//
//            num -= m;
//            res++;
//        }
//
//        return res;
//    }
}
