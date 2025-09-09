package com.practise.goldman_problems.medium;

import java.util.Map;
import java.util.TreeMap;

public class CarPooling {

    /*[[8, 16, 20], [9, 18, 19], [7, 13, 16],
     [7, 13, 16], [8, 15, 18], [3, 17, 18],
     [6, 6, 18], [1, 2, 6], [5, 3, 7],
     [1, 16, 20], [3, 12, 20],
     [8, 18, 20], [5, 7, 17],
     [9, 14, 15], [7, 9, 17],
     [7, 12, 18], [6, 15, 19],
     [6, 18, 19], [8, 18, 20], [2, 12, 16]]


There is a car with capacity empty seats. The vehicle only drives east (i.e., it cannot turn around and drive west).
You are given the integer capacity and an array trips where trips[i] = [numPassengersi, fromi, toi] indicates that the ith trip has numPassengersi
passengers and the locations to pick them up and drop them off are fromi and toi respectively.
 The locations are given as the number of kilometers due east from the car's initial location.
Return true if it is possible to pick up and drop off all passengers for all the given trips, or false otherwise.
    * */
    public boolean carPooling(int[][] trips, int capacity) {
        // lets think of maintaining a timeline of at what distance how many passengers added or removed in an order, lets use treeMap as it maintains the order of insertion

        Map<Integer, Integer> timeline = new TreeMap<>(); //why treeMap cause it maintains the order of insertion for keys which are starting point of distance so its sort of an ordered timeline

        for (int[] trip : trips) {
            int passengers = trip[0];
            int from = trip[1];
            int to = trip[2];

            timeline.put(from, timeline.getOrDefault(from, 0) + passengers); //add passengers at from location
            timeline.put(to, timeline.getOrDefault(to, 0) - passengers);  // remove passengers at to location
        }
        int currentPassengers = 0;
        for (int moment : timeline.values()) {
            currentPassengers = moment + currentPassengers;
            if (currentPassengers > capacity) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CarPooling test = new CarPooling();
        int[][] trip = {{2, 1, 5}, {3, 3, 7}};
        System.out.println(test.carPooling(trip, 4));
        System.out.println(test.carPooling(trip, 5));
    }

}
