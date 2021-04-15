package main.java.Codechef.MonthlyContest.December2020Contest;


import java.io.PrintWriter;

public class PositivePrefixes {
    public static void main(String[] args) {
        // Scanner scanner = new Scanner(System.in);
        FastReader fastReader = new FastReader();
        PrintWriter writerObj = new PrintWriter(System.out);
        int t = fastReader.nextInt();
//        while (t-- > 0) {
//
//            int n = scanner.nextInt();
//            int k = scanner.nextInt();
//
//            long sum = (long) (k * (k + 1))/2;
//            long halfSum = sum/2 + sum % 2;
//            for (int i = 1; i <= n; i++) {
//
//                int temp = i * (-1);
//
//                if (i > k)
//                    System.out.print(temp);
//                else
//                if (halfSum > i) {
//                    halfSum -= i;
//                    System.out.print(temp);
//                } else
//                    System.out.print(i);
//
//                System.out.print(' ');
//            }
//        }
        while (t-- > 0) {

            int n = fastReader.nextInt();
            int k = fastReader.nextInt();
            int arr[] = new int[n+1];
            int diff = n % 2 == 0 ? k - (n/2): k - ((n+1)/2);

            for (int i = 1; i <= n; i++) {
                if (n % 2 == 0) {
                    if (i % 2 == 0)
                    arr[i] = i;
                    else
                        arr[i] = i * -1;
                } else {
                    if (i % 2 == 0)
                        arr[i] = i * -1;
                    else
                        arr[i] = i;
                }

//                if (diff < 0 && (n + (diff + 1) * 2) == i) {
//                    arr[i] *= -1;
//                    diff++;
//                } else if (diff > 0 && ((n - (diff - 1) * 2) - 1) == i) {
//                    arr[i] *= -1;
//                    diff--;
//                }
//
//                System.out.print(arr[i] + " ");

            }

            for (int i = n; i > 0; i = i - 2) {
                if (diff == 0)
                    break;

                if (diff < 0) {
                    arr[i] *= -1;
                    diff++;
                } else {
                    arr[i-1] *= -1;
                    diff--;
                }
            }

            for (int i = 1; i <= n; i++)
                writerObj.print(arr[i] +" ");

            writerObj.flush();
        }
    }
}
