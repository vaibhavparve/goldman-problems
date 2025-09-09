package com.practise.goldman_problems.medium;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheWithLinkedHashMap {
    private final int capacity;
    private final LinkedHashMap<Integer, Integer> cache;

    public LRUCacheWithLinkedHashMap(int capacity) {
        this.capacity = capacity;
        // LinkedHashMap with access-order = true
        this.cache = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        cache.put(key, value);
    }
}
