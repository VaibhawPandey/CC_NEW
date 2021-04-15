package main.java.Leetcode.MonthlyLC.SeptemberLeetcodingChallenge.Week3;

import java.util.HashMap;
import java.util.Map;

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
