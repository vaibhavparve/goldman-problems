package com.practise.bloomberg.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomizedSet {

    //insert(int val) O(1) hashmpa

    //remove O(1) hashmap

    //getRandom(0) o(1) get by index from an array

    public List<Integer> values;

    public Map<Integer, Integer> valueIndex;

    public Random random;

    public RandomizedSet() {
        values = new ArrayList<>();
        valueIndex = new HashMap<>();
        random = new Random();
    }

    //if does not ocntain return false
    public boolean insert(int val) {
        if (!valueIndex.containsKey(val)) {
            values.add(val);
            valueIndex.put(val, values.size() - 1);
            return true;
        } else {
            return false;
        }
    }

    //avoid O(n) array shifting during deletion
    public boolean remove(int val) {
        if (valueIndex.containsKey(val)) {
            Integer indexToRemove = valueIndex.get(val);
            int lastIndex = values.size() - 1;

            if (indexToRemove != lastIndex) {
                int lastElement = values.get(lastIndex);
                //set last index as index to remove so no need for reshuffling
                values.set(indexToRemove, lastElement);
                //last element is moved to index to remove
                valueIndex.put(lastElement, indexToRemove);
            }
            values.remove(lastIndex);

            valueIndex.remove(val);

            return true;
        }
        return false;
    }

    public int getRandom() {
        int i = random.nextInt(values.size());
        return values.get(i);
    }
}
