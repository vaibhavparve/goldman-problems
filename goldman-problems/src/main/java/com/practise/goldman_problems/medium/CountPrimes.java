package com.practise.goldman_problems.medium;

public class CountPrimes {
    public int countPrimesOptimized(int n) {
        //handle edge
        if (n < 2) {
            return 0;
        }

        boolean[] isPrime = new boolean[n];
        int count = 0;

        for (int i = 2; i < n; i++) {
            isPrime[i] = true; //initially mark all as prime
        }

        //sieve of Eratosthenes algorithm
        for (int p = 2; p * p < n; p++) {

            if (isPrime[p]) {//is its still prime
                for (int i = p * p; i < n; i = i + p) {
                    isPrime[i] = false;
                }
            }
        }

        for (int i = 0; i < isPrime.length; i++) {
            if (isPrime[i]) {
                count++;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        CountPrimes test = new CountPrimes();
        System.out.println(test.countPrimesOptimized(10));
    }
}
