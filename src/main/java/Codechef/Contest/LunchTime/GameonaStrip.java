package main.java.Codechef.Contest.LunchTime;

import java.util.Scanner;

public class GameonaStrip {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {

            int n = scanner.nextInt();
            int arr[] = new int[n];

            for (int j = 0; j < n; j++)
                arr[j] = scanner.nextInt();

            int bP = getBestPosition(arr);

            if (bP == -1)
                System.out.println("No");

            arr[bP] = 1;
            int tP = getBestPosition(arr);

            if (tP == -1)
                System.out.println("Yes");

            arr[tP] = 1;




        }
    }

    private static int getBestPosition(int[] arr) {

        int max0Count = 0, sP = -1, eP = -1, tempCount = 0, tempSp = -1, tempEp = -1;
        for (int j = 1; j < arr.length - 1; j++) {
            if (arr[j] == 0) {
                tempCount++;
                if (tempSp == -1)
                    tempSp = j;
                tempEp = j;
                if (tempCount > max0Count) {
                    max0Count = tempCount;
                    sP = tempSp;
                    eP = tempEp;
                }
            } else {
                tempCount = 0;
                tempSp = -1; tempEp = -1;
            }
        }

        if (sP == -1)
            return sP;

        int mid = max0Count / 2;
        return sP + mid;

    }
}
