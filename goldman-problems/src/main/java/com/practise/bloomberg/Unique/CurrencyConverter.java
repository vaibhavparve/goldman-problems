package com.practise.bloomberg.Unique;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CurrencyConverter {

    public double getConversionRate(String[][] rates, String[] fromTo) {

        Map<String, List<Pair>> graph = buildGraph(rates); // maintain all the conversions

        String from = fromTo[0];
        String to = fromTo[1];

        //if its request for same currency //edge case
        if(from.equals(to)){
            return 1.0;
        }

        return bfs(graph, from, to);
    }

    public Map<String, List<Pair>> buildGraph(String[][] rates) {
        Map<String, List<Pair>> graph = new HashMap<>();

        for (String[] rate : rates) {
            String from = rate[0];
            String to = rate[1];
            double exchangeRate = Double.parseDouble(rate[2]);

            graph.putIfAbsent(from, new ArrayList<>()); //add from currency
            graph.get(from).add(new Pair(to, exchangeRate)); // add from,to, exchange rate

            //reverse as well
            graph.putIfAbsent(to, new ArrayList<>());
            graph.get(to).add(new Pair(from, 1 / exchangeRate));
        }
        return graph;
    }

    private double bfs(Map<String, List<Pair>> graph, String from, String to) {
        if(!graph.containsKey(from) || !graph.containsKey(to)){
            return -1; // one of the currencies not found
        }

        Queue<Pair> queue = new LinkedList<>(); //processing the currencies
        Set<String> visited = new HashSet<>(); // to avoid repetation

        queue.offer(new Pair(from, 1.0));
        visited.add(from);

        while(!queue.isEmpty()){
            Pair current = queue.poll();
            String currentCurrency = current.currency;
            double currentRate = current.rate;

            //target found
            if(currentCurrency.equals(to)){
                return currentRate;
            }

            //explores all the neighbours
            if(graph.containsKey(currentCurrency)){
                for(Pair neighbour: graph.get(currentCurrency)){
                    if(!visited.contains(neighbour.currency)){
                        double newRate = currentRate* neighbour.rate;
                        queue.offer(new Pair(neighbour.currency, newRate));
                        visited.add(neighbour.currency);
                    }
                }
            }
        }
        return -1;
    }

    private static class Pair {
        String currency;
        double rate;

        Pair(String currency, double rate) {
            this.currency = currency;
            this.rate = rate;
        }
    }
}
