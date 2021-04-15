package main.java.Leetcode.Practice.Miscellaneous;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ChangePrimePosition {
    public static void main(String[] args) {

        int arr[] = {6, 9, 11, 4, 8, 2, 10, 7, 14};

        List<Integer> primeNums = new ArrayList<>();
        List<Integer> positions = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (isPrime(arr[i])) {
                primeNums.add(arr[i]);
                positions.add(i);
            }
        }

        Collections.sort(primeNums);

        for (int i = 0; i < positions.size(); i++)
            arr[positions.get(i)] = primeNums.get(i);

        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }

    private static boolean isPrime(int num) {
        if (num == 1)
            return false;

        for (int i = 2; i <= num/2; i++) {
            if (num % i == 0)
                return false;
        }

        return true;
    }
}
