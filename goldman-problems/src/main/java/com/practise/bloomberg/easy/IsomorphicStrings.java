package com.practise.bloomberg.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IsomorphicStrings {
    //solve using hashmap and hashset to note vitied chars
    //corner case

    boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> charMap = new HashMap<>(); //store the occurance
        Set<Character> visited = new HashSet<>(); //visited

        int n = s.length();

        for (int i = 0; i < n; i++) {
            if (charMap.containsKey(s.charAt(i))) {
                if (charMap.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
            } else {
                if (visited.contains(t.charAt(i))) {
                    return false;
                }
                charMap.put(s.charAt(i), t.charAt(i));
                visited.add(t.charAt(i));
            }
        }
        return true;
    }
}
