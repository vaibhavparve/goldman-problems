package com.practise.bloomberg.Unique;

import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CollatzConjunctureII {
    private static final Map<Long, SoftReference<Integer>> collatz =
            new ConcurrentHashMap<>();

    public int getCollatz(long num) {
        int steps = 0;
        //How many steps it takes to reach one for every number
        if (num < 0) {
            return 0; //solve oly for positive integers
        }

        SoftReference<Integer> integerSoftReference = collatz.get(num);
        if (integerSoftReference != null) {
            Integer cached = integerSoftReference.get();
            if (cached != num) {
                return cached;
            } else {
                collatz.remove(num);
            }
        }

        long current = num;
        while (current != 1) {

            if (collatz.containsKey(current)) {
                steps = steps + collatz.get(current).get(); //optimize
                break;
            }

            if (current % 2 == 0) {
                current = current / 2; //if its even divide by 2
                steps++;
            } else {
                if (current > (Long.MAX_VALUE - 1) / 3) {
                    //aprox
                    return steps + (int) (Math.log(current) * 3.5);
                }
                current = (3 * current + 1);
                steps++;
            }
        }
        if (num < 1_000_000) {
            collatz.put(num, new SoftReference<>(steps));
        }
        return steps;
    }


}
