package com.practise.bloomberg.medium;


import java.util.HashMap;
import java.util.Map;

public class UndergroundSystem {
    //its simple task only confusing bit is how clean code you write
    static class CheckInInfo {
        String stationName; //not storing id as id we will use it in hashmap
        Integer time;

        public CheckInInfo(String stationName, Integer time) {
            this.stationName = stationName;
            this.time = time;
        }
    }

    static class RouteStats {
        int totalTime;
        int count;

        public RouteStats() {
            totalTime = 0;
            count = 0;
        }

        public void addJourney(int t) {
            totalTime = totalTime + t;
            count++;
        }

        public double getAverageTime() {
            if (count == 0) {
                return 0.0;
            }
            return (double) totalTime / count;
        }
    }

    //to store the check-ins
    private Map<Integer, CheckInInfo> checkIns;
    //to store the route stats based on from and to station key
    private Map<String, RouteStats> routeStats;

    public UndergroundSystem() {
        checkIns = new HashMap<>();
        routeStats = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        //record the check-ins
        checkIns.put(id, new CheckInInfo(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        //customer has to be checked in before checking out
        if (!checkIns.containsKey(id)) {
            throw new RuntimeException();
        }

        CheckInInfo checkInInfo = checkIns.get(id);
        int traveTime = t - checkInInfo.time;
        String routeKey = checkInInfo.stationName + '-' + stationName;

        //update route stats
        routeStats.putIfAbsent(routeKey, new RouteStats());
        routeStats.get(routeKey).addJourney(traveTime);

        checkIns.remove(id);
    }

    public double getAverageTime(String startStation, String endStation) {
        String routeKey = startStation + '-' + endStation;
        if (!routeStats.containsKey(routeKey)) {
            return 0.0;
        }
        return routeStats.get(routeKey).getAverageTime();
    }
}
