package main.java.Vaibhaw_GH.src;

import java.util.Scanner;

public class MoonsAndUmbrellas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {

            int X = scanner.nextInt();
            int Y = scanner.nextInt();
            char input[] = scanner.next().toCharArray();

            char previousChar = '-', nextChar = '-';
            for (int j = 0; j < input.length; j++) {
                if (input[j] != '?') {
                    previousChar = input[j];
                    continue;
                }
                int prevIndex = j;
                while (j < input.length && input[j] == '?')
                    j++;

                if (j != input.length) nextChar = input[j];

                if (previousChar == '-' && nextChar == '-') continue;

                for (int k = prevIndex; k < j; k++)
                    input[k] = previousChar == '-' ? nextChar: previousChar;

                previousChar = nextChar;
                nextChar = '-';
            }

            long res = 0;
            // if (previousChar != '-' || nextChar != '-') {
                for (int j = 1; j < input.length; j++) {
                    if (input[j] == input[j - 1]) continue;

                    if (input[j - 1] == 'C' && input[j] == 'J')
                        res += X;
                    else
                        res += Y;
                }
            // }

            // System.out.println(input);
            System.out.println("Case #" + (i + 1) + ": " + res);
        }
        scanner.close();
    }
}
