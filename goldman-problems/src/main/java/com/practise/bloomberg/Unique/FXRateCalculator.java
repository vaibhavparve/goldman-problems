package com.practise.bloomberg.Unique;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class FXRateCalculator {

    public static double maxExchangeRate(List<String[]> fxRates, String from, String to) {
        // Build graph with currencies as nodes and exchange rates as edges
        Map<String, Map<String, Double>> graph = new HashMap<>();
        Set<String> currencies = new HashSet<>();

        // Add all currencies and build adjacency list
        for (String[] rate : fxRates) {
            String fromCurrency = rate[0];
            String toCurrency = rate[1];
            double exchangeRate = Double.parseDouble(rate[2]);

            currencies.add(fromCurrency);
            currencies.add(toCurrency);

            graph.putIfAbsent(fromCurrency, new HashMap<>());
            graph.putIfAbsent(toCurrency, new HashMap<>());

            // Direct exchange
            graph.get(fromCurrency).put(toCurrency, exchangeRate);
            // Reverse exchange (1/rate)
            graph.get(toCurrency).put(fromCurrency, 1.0 / exchangeRate);
        }

        // If source or target currency doesn't exist
        if (!currencies.contains(from) || !currencies.contains(to)) {
            return -1.0;
        }

        // If source equals target
        if (from.equals(to)) {
            return 1.0;
        }

        // Use modified Dijkstra's algorithm to find maximum exchange rate path
        Map<String, Double> maxRates = new HashMap<>();
        PriorityQueue<CurrencyNode> pq = new PriorityQueue<>((a, b) -> Double.compare(b.rate, a.rate));

        // Initialize
        for (String currency : currencies) {
            maxRates.put(currency, 0.0);
        }
        maxRates.put(from, 1.0);
        pq.offer(new CurrencyNode(from, 1.0));

        while (!pq.isEmpty()) {
            CurrencyNode current = pq.poll();
            String currentCurrency = current.currency;
            double currentRate = current.rate;

            // Skip if we've already found a better rate
            if (currentRate < maxRates.get(currentCurrency)) {
                continue;
            }

            // Early termination if we reached target
            if (currentCurrency.equals(to)) {
                return currentRate;
            }

            // Explore neighbors
            if (graph.containsKey(currentCurrency)) {
                for (Map.Entry<String, Double> neighbor : graph.get(currentCurrency).entrySet()) {
                    String nextCurrency = neighbor.getKey();
                    double exchangeRate = neighbor.getValue();
                    double newRate = currentRate * exchangeRate;

                    if (newRate > maxRates.get(nextCurrency)) {
                        maxRates.put(nextCurrency, newRate);
                        pq.offer(new CurrencyNode(nextCurrency, newRate));
                    }
                }
            }
        }

        // Return the maximum rate to target currency, or -1 if unreachable
        return maxRates.get(to) > 0 ? maxRates.get(to) : -1.0;
    }

    static class CurrencyNode {
        String currency;
        double rate;

        CurrencyNode(String currency, double rate) {
            this.currency = currency;
            this.rate = rate;
        }
    }

    public static void main(String[] args) {
        // Test case from the example
        List<String[]> fxRates = Arrays.asList(
                new String[]{"USD", "JPY", "109"},
                new String[]{"USD", "GBP", "0.71"},
                new String[]{"GBP", "JPY", "155"}
        );

        String from = "USD";
        String to = "JPY";

        double result = maxExchangeRate(fxRates, from, to);
        System.out.println("Maximum " + to + " for 1 " + from + ": " + result);

        // Test direct conversion: USD -> JPY = 109
        // Test indirect conversion: USD -> GBP -> JPY = 0.71 * 155 = 110.05
        // Maximum should be 110.05

        // Additional test cases
        System.out.println("\nAdditional test cases:");
        System.out.println("GBP to USD: " + maxExchangeRate(fxRates, "GBP", "USD"));
        System.out.println("JPY to USD: " + maxExchangeRate(fxRates, "JPY", "USD"));
        System.out.println("USD to EUR (non-existent): " + maxExchangeRate(fxRates, "USD", "EUR"));
    }
}