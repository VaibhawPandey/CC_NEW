package main.java.Leetcode.WeeklyContest.WC218;

public class GoalParser {
    public String interpret(String command) {

        StringBuilder res = new StringBuilder();
        char commandChar[] = command.toCharArray();
        int n = commandChar.length, i = 0;

        if (n == 0)
            return "";

        while (i < n) {
            if (commandChar[i] == 'G') {
                res.append('G');
                i++;
            } else if (commandChar[i] == '(' && commandChar[i+1] == ')') {
                res.append('o');
                i = i + 2;
            } else {
                res.append("al");
                i = i + 4;
            }
        }

        return res.toString();
    }
}
