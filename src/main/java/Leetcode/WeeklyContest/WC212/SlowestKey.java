package main.java.Leetcode.WeeklyContest.WC212;

public class SlowestKey {
    public char slowestKey(int[] releaseTimes, String keysPressed) {

        char keyArray[] = keysPressed.toCharArray();

        int maxReleaseTime = releaseTimes[0];
        char res = keyArray[0];

        for (int i = 1; i < keyArray.length; i++) {

            int time = releaseTimes[i] - releaseTimes[i-1];

            if (time> maxReleaseTime) {
                maxReleaseTime = time;
                res = keyArray[i];
            }

            if (time == maxReleaseTime && keyArray[i] < res) {
                res = keyArray[i];
            }

        }

        return res;
    }
}
