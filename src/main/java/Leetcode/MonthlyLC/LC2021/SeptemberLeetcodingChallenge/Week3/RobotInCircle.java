package main.java.Leetcode.MonthlyLC.LC2021.SeptemberLeetcodingChallenge.Week3;

public class RobotInCircle {
    public boolean isRobotBounded(String instructions) {

        int direction[][] = {{0,1}, {1,0}, {0, -1}, {-1, 0}};
        int d = 3;

        for (int i = 0; i < instructions.length(); i++) {
            if (instructions.charAt(i) == 'L')
                d = (d + 3) % 4;
        }

        return true;
    }
}
