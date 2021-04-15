package main.java.Leetcode.MonthlyLC.AugustLeetcodingChallenge.Week1;

import java.util.Arrays;
import java.util.HashSet;

public class MyHashSet {

    int hashSet[];
    int index = 0;
    int initialCapacity = 10;
    /** Initialize your data structure here. */
    public MyHashSet() {
        hashSet = new int[initialCapacity];
        Arrays.fill(hashSet, -1);
    }

    public void add(int key) {

        if (index == initialCapacity) {
            initialCapacity += 10;
            hashSet = getNewHashSet(initialCapacity);
            Arrays.fill(hashSet, -1);
        }

        if (!contains(key)) {
            hashSet[index] = key;
            index++;
        }
    }

    private int[] getNewHashSet(int initialCapacity) {
        int newHashSet[] = new int[initialCapacity];
        for (int i = 0; i < index; i++)
            newHashSet[i] = hashSet[i];

        return newHashSet;
    }

    public void remove(int key) {

        int indexofKey = Integer.MAX_VALUE;
        for (int i = 0; i < index; i++) {

            if (hashSet[i] == key)
                indexofKey = i;

            if (indexofKey != Integer.MAX_VALUE);
               hashSet[i] = hashSet[i+1];
        }

        System.out.println("Delete key:-" + key);
        System.out.println(indexofKey +"--" +index);

        if (indexofKey != Integer.MAX_VALUE) {
            index--;
            hashSet[index] = 0;
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {

        for (int i = 0; i < hashSet.length; i++) {
            if (hashSet[i] == key)
                return true;
        }

        return false;
    }
}
