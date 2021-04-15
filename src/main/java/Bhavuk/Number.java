package main.java.Bhavuk;

import java.util.HashMap;
import java.util.Map;

public class Number {

    public static void main(String[] args) {

        new Number().solution(new String[]{"test1a", "test2", "test1b", "test1c", "test3"}, new String[]{"WA", "Ok", "RE", "Ok", "TLE"});
    }

    public int solution (String T[], String R[]) {

        Map<Character, Boolean> resultStatusByGroup = new HashMap<>();

        for (int i = 0; i < T.length; i++) {

            String t = T[i];
            char s = t.charAt(t.length() - 1);

            if (Character.isAlphabetic(s)) {
                char group = t.charAt(t.length() - 2);
                if (resultStatusByGroup.getOrDefault(group, true)) {
                    boolean status = R[i].equalsIgnoreCase("OK") ? true: false;
                    resultStatusByGroup.put(group, status);
                }
            } else {
                boolean status = R[i].equalsIgnoreCase("OK") ? true: false;
                resultStatusByGroup.put(s, status);
            }
        }

        int count = 0;
        for (Map.Entry entry: resultStatusByGroup.entrySet())
            if ((boolean) entry.getValue()) {
                count++;
            }

        return (count * 100)/resultStatusByGroup.size();
    }
}
