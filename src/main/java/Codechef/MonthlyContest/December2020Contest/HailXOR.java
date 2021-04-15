package main.java.Codechef.MonthlyContest.December2020Contest;

import java.io.PrintWriter;

public class HailXOR {
    public static void main(String[] args) {
        FastReader fastReader = new FastReader();
        PrintWriter printWriter = new PrintWriter(System.out);

        int t = fastReader.nextInt();

        while (t-- > 0) {

            int n = fastReader.nextInt();
            int x = fastReader.nextInt();
            int arr[] = new int[n];
            // int len[] = new int[n];

            for (int i = 0; i < n; i++)
                arr[i] = fastReader.nextInt();

            int i = 0, j = 1, noOfOperation = 0;
            //boolean flag = false;

            for (noOfOperation = 0; noOfOperation < x && i < n-1; noOfOperation++) {

                int len = arr[i] < 2 ? 0 : (int) (Math.log(arr[i]) / Math.log(2.0));
                long p = (long) Math.pow(2, len);
                arr[i] ^= p;
                j = i + 1;

                while (j < n) {
                    int temp = (int) (arr[j]^p);
                    if ((int) temp <= arr[j]) {
                        arr[j] ^= p;
                        //flag = true;
                        break;
                    }
                    j++;
                }

                if (j == n)
                    arr[j-1] ^= p;

                while (i < n && arr[i] == 0)
                    i++;
            }

            if ((x-noOfOperation) % 2 == 1 && n < 3) {
                    arr[n - 1] ^= 1;
                    arr[n - 2] ^= 1;
            }

            for (int k = 0; k < n; k++)
                printWriter.print(arr[k] + " ");

            printWriter.flush();


        }

    }
}
