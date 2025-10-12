package com.practise.wise.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
*
*   friendships.put("Alice", new HashSet<>(Arrays.asList("Bob", "Charlie", "David")));
        friendships.put("Bob", new HashSet<>(Arrays.asList("Alice", "Charlie", "Eve")));
        friendships.put("Charlie", new HashSet<>(Arrays.asList("Alice", "Bob", "David")));
        friendships.put("David", new HashSet<>(Arrays.asList("Alice", "Charlie")));
        friendships.put("Eve", new HashSet<>(Arrays.asList("Bob")));

*
* */
public class MutualFriends {
    Map<String, Set<String>> friendships = new HashMap<>(); //maintain the friendships map

    public static Map<String, Set<String>> findAllMutualFriends(
            Map<String, Set<String>> friendships, String person) {
        Map<String, Set<String>> result = new HashMap<>(); //result with mutual sets

        Set<String> myFriends = friendships.get(person); //get all my friends

        Set<String> processed = new HashSet<>(); //to avoid cycles

        for (String friend : myFriends) {

            if (processed.contains(friend)) {
                continue;
            }
            processed.add(friend);

            Set<String> friendsFriends = friendships.get(friend); //get friend of friends
            HashSet<String> mutualFriends = myFriends.stream()
                    .filter(f -> friendsFriends.contains(f) && !f.equals(person))
                    .collect(HashSet::new, HashSet::add, HashSet::addAll);

            result.put(friend, mutualFriends);
        }
        return result;
    }

    static void main() {

    }
}
