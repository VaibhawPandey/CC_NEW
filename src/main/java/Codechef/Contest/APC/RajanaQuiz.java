package main.java.Codechef.Contest.APC;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RajanaQuiz {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[];
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {

            arr = new int[3];
            arr[0] = scanner.nextInt();
            arr[1] = scanner.nextInt();
            arr[2] = scanner.nextInt();
            Arrays.sort(arr);

            String key = "";
            for (int j = 0; j < 3; j++)
                 key += arr[j];

            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        int res = 0;
        for (Map.Entry entry: map.entrySet())
            if ((int) entry.getValue() == 1)
                res++;

        System.out.println(res);
    }
}
