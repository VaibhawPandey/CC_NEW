package main.java.Leetcode.WeeklyContest.WC215;

import java.util.ArrayList;
import java.util.List;

public class DesignOrderedStream {
    String stream[];
    int ptr;
    public void OrderedStream(int n) {
        stream = new String[n];
        ptr = 0;
    }

    public List<String> insert(int id, String value) {

        stream[id - 1] = value;
        List<String> res = new ArrayList<>();
        // System.out.println(id + "--" + ptr);
        while (ptr < stream.length && stream[ptr] != null) {
            res.add(stream[ptr]);
            ptr++;
        }
        // System.out.println(id + "--" + ptr);

        return res;
    }
}
