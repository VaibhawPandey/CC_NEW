package main.java.Codechef.Contest.APC;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class ArrayNDistinct {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {

            int n = scanner.nextInt();
            int k = scanner.nextInt();
            HashSet<Integer> hashSet = new HashSet<>();
            Map<Integer, Integer> map = new HashMap<>();

            int arr[] = new int[n];
            int sum[] = new int[n + 1];

            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
                sum[i + 1] += sum[i] + arr[i];
                hashSet.add(arr[i]);
            }

            int noOfdistinctKey = hashSet.size();

            int res = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {

                if (i < k) {
                    map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
                    // hashSet.add(arr[i]);
                } else {
                    map.put(arr[i-k], map.get(arr[i-k]) - 1);
                    if (map.getOrDefault(arr[i-k], 0) == 0)
                        map.remove(arr[i-k]);
                    map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
                }

                if (i >= k - 1) {
                    if (map.size() == noOfdistinctKey)
                        res = Math.max(res, sum[i + 1] - sum[i - k + 1]);
                }
            }

            System.out.println(res);
        }
    }
}
