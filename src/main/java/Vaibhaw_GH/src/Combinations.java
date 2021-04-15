package main.java.Vaibhaw_GH.src;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combinations {
    public static List<List<Integer>> permute(List<Integer> arr, int k, List<List<Integer>> integers){
        for(int i = k; i < arr.size(); i++){
            java.util.Collections.swap(arr, i, k);
            permute(arr, k+1, integers);
            java.util.Collections.swap(arr, k, i);
        }
        if (k == arr.size() -1){
            integers.add(new ArrayList<>(arr));
        }

        return integers;
    }
    public static void main(String[] args){
        List<List<Integer>> arr = new LinkedList<>();
        new Combinations().permute(java.util.Arrays.asList(1,2,3,4), 0, arr);
    }
}
