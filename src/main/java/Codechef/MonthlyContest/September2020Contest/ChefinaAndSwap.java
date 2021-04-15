package main.java.Codechef.MonthlyContest.September2020Contest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ChefinaAndSwap {

    public static void main(String[] args) throws Exception {

        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        // Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.readLine());

        for (int i = 0; i < t; i++) {

            long n = Long.parseLong(scanner.readLine());

            long sum = (n * (n + 1))/2;
            long res = 0;
            if ((sum & 1) != 0) {
                System.out.println(res);
                continue;
            }

            double half = sum/2;
            double k = (Math.sqrt(8 * half + 1)/2) - 0.5;

            int pos = (int) k;
            if (k - pos == 0)
                res = getComb(pos) + getComb(n - pos);

            res += n - pos;
            System.out.println(res);
        }
    }

    private static long getComb(long pos) {
        return (pos * (pos - 1))/2;
    }

//    public static void main(String[] args) {
//
//        Scanner scanner = new Scanner(System.in);
//        int t = scanner.nextInt();
//
//        for (int i = 0; i < t; i++) {
//
//            int n = scanner.nextInt();
//            long sum = (n * (n + 1))/2;
//
//
//        }
//    }
//    public static void main(String[] args) {
//
//        Scanner scanner = new Scanner(System.in);
//        int t = scanner.nextInt();
//        Map<Long, Long> map = new HashMap<>();
//
//        for (int i = 0; i < t; i++) {
//
//            long n = scanner.nextInt();
//            long sum = (n * (n + 1))/2;
//
//            if (n <= 2 || sum % 2 != 0) {
//                System.out.println(0);
//                continue;
//            }
//
//            if (map.containsKey(n)) {
//                System.out.println(map.get(n));
//                continue;
//            }
//
//
//
//            long left = 1, right = n, partSum = 0;
//            while (left < right - 1) {
//                long mid = (left + right) / 2;
//                long midSum = (mid * (mid + 1))/2;
//
//                if (sum - midSum >= sum/2) {
//                    left = mid;
//                    partSum = midSum;
//                }
//                else {
//                    right = mid;
//                }
//            }
//
//            long count = left;
//
////            long count = 0, partSum = 0;
////            for (long j = n; j >= 0; j--) {
////
////                partSum += j;
////                count++;
////                if (partSum >= sum/2)
////                    break;
////            }
//            // long midSum = (count * (count + 1))/2;
//            long res = 0;
//
//            if (partSum == sum/2) {
//                res = ((count * (count - 1))/2) + ((n - count) * (n - count - 1))/2 + count;
//            } else {
//                res = count;
//            }
//
//            map.put(n, res);
//
//            System.out.println(res);
//        }
//    }
}
