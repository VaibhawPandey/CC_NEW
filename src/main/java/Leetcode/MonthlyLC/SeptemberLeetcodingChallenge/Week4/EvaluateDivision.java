package main.java.Leetcode.MonthlyLC.SeptemberLeetcodingChallenge.Week4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvaluateDivision {
    class Item {
        String dest;
        double val;

        Item(String dest, double val) {
            this.dest = dest;
            this.val = val;
        }
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        Map<String, List<Item>> map = new HashMap<>();
        double res[] = new double[queries.size()];

        for (int i = 0; i < equations.size(); i++) {

            double reveseVal = 1/values[i];
            List<Item> itemList = map.getOrDefault(equations.get(i).get(0), new ArrayList<>());
            itemList.add(new Item(equations.get(i).get(1), values[i]));
            map.put(equations.get(i).get(0), itemList);

            itemList = map.getOrDefault(equations.get(i).get(1), new ArrayList<>());
            itemList.add(new Item(equations.get(i).get(0), reveseVal));
            map.put(equations.get(i).get(1), itemList);
        }

        for (List<String> query: queries) {

        }

        return res;
    }
}
