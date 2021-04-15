package main.java.Codechef.MonthlyContest.NovemberContest;

import main.java.Codechef.MonthlyContest.December2020Contest.FastReader;

import java.util.Arrays;

public class AdaAndDishes {
    public static void main(String[] args) {
        FastReader fastReader = new FastReader();

        int t = fastReader.nextInt();
        while (t-- > 0) {

            int n = fastReader.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = fastReader.nextInt();

            Arrays.sort(arr);
            int res = arr[arr.length - 1], index = arr.length - 2, set1Sum = res, set2Sum = 0;

            while (index >= 0) {

                if (set1Sum >= set2Sum)
                    set2Sum += arr[index];
                else
                    set1Sum += arr[index];

                res = Math.max(set1Sum, set2Sum);
                index--;
            }

            System.out.println(res);
        }
    }
}
