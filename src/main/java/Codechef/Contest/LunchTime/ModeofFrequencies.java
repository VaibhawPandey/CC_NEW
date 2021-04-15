package main.java.Codechef.Contest.LunchTime;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ModeofFrequencies {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {

            int n = scanner.nextInt();

            int frequency[] = new int[11];
            // int maxFrequency = Integer.MIN_VALUE;

            for (int j = 0; j < n; j++) {
                int temp = scanner.nextInt();
                frequency[temp]++;
            }

            List<Integer> frequencySize[] = new ArrayList[10001];
            for (int j = 1; j <= 10; j++) {

                if (frequency[j] > 0) {
                    if (frequencySize[frequency[j]] == null)
                        frequencySize[frequency[j]] = new ArrayList<>();

                    frequencySize[frequency[j]].add(j);
                }
            }

            int maxElementSize = Integer.MIN_VALUE, minElement = Integer.MAX_VALUE;
            for (int j = 1; j <= 10; j++) {

                if (frequency[j] > 0) {
                    if (frequencySize[frequency[j]].size() > maxElementSize) {
                        maxElementSize = frequencySize[frequency[j]].size();
                        minElement = frequencySize[frequency[j]].get(0);
                    } else if (frequencySize[frequency[j]].size() == maxElementSize) {
                        maxElementSize = frequencySize[frequency[j]].size();
                        minElement = Math.min(minElement, frequencySize[frequency[j]].get(0));
                    }
                }
            }

            System.out.println(minElement);
        }
    }
}
