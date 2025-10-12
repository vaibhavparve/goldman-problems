package com.practise.wise.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class FriendSuggestionsUsingBFS {

    public Set<String> findFriendSuggestions(Map<String, Set<String>> friendships, String person) {
        //if the list does not contain the return the empty set
        Set<String> suggestions = new HashSet<>(); //hashset doesnt contain duplicates
        Queue<String> queue = new LinkedList<>(); //
        Set<String> visited = new HashSet<>(); // to track visited friends and avoid cycles
        //if the person doesn't exist, good to ignore
        if (!friendships.containsKey(person)) {
            return suggestions;
        }

        queue.offer(person);
        visited.add(person);//start with processing first person

        while (!queue.isEmpty()) {
            String current = queue.poll(); //start with the person we added

            if (friendships.containsKey(current)) {
                for (String friend : friendships.get(current)) {
                    if (!visited.contains(friend)) {
                        visited.add(friend);
                        queue.offer(friend); //add to queue
                    }

                    //add to suggestions if its not the original person
                    if (!friend.equals(person)) {
                        suggestions.add(friend);
                    }
                }
            }
        }
        suggestions.removeAll(friendships.get(person)); //remove all direct friends, only return mutual

        return suggestions;
    }

    public static void main(String[] args) {
        FriendSuggestionsUsingBFS test = new FriendSuggestionsUsingBFS();
        Map<String, Set<String>> friendships = new HashMap<>();

        friendships.put("Alice", Set.of("Bob", "Charlie"));
        friendships.put("Bob", Set.of("Alice", "David", "Eve"));
        friendships.put("Charlie", Set.of("Alice", "Frank"));
        friendships.put("David", Set.of("Bob", "Grace"));
        friendships.put("Eve", Set.of("Bob"));
        friendships.put("Frank", Set.of("Charlie"));
        friendships.put("Grace", Set.of("David"));

        Set<String> suggestions = test.findFriendSuggestions(friendships, "Alice");
        System.out.println("Friend suggestions for Alice: " + suggestions);
    }
}
