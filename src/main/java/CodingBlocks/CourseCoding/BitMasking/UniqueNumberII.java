package main.java.CodingBlocks.CourseCoding.BitMasking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UniqueNumberII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int res = 0;
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
           if (i == 0) {
               arr[i] = scanner.nextInt();
               res = arr[i];
           } else {
               arr[i] = scanner.nextInt();
               res = res ^ arr[i];
           }
        }

        int temp = res, pos = 0;
        while (temp > 0) {
            if ((temp&1) == 1)
                break;
            pos++;
            temp = temp >> 1;
        }

        List<Integer> arrList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            temp = arr[i];
            int j = 0;
            while (temp > 0) {
                if ((temp&1) == 1) {
                    if (pos == j)
                        arrList.add(temp);
                    break;
                }
                j++;
                temp = temp >> 1;
            }
        }

        int resA = 0;
        for (int i = 0; i < arrList.size(); i++) {
            if (i == 0)
                resA = arrList.get(i);
            else
                resA = arrList.get(i) ^ resA;
        }

        int resB = res ^ resA;

        System.out.println(resA + " " + resB);




    }
}
