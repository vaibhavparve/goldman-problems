package com.practise.bloomberg.Unique;

import java.lang.ref.SoftReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/*
 * any number if even n/2 and if odd 3n+1 if we keep repeating this cycle will end to 1.
 * return the number of steps we need to reach 1 for number n, assume only positive numbers.
 * */
public class CollatzConjuncture {
    //why soft reference so gc can collect unused
    public static Map<Long, SoftReference<Integer>> softCache = Collections.synchronizedMap(new HashMap<>());

    public static int getCollatz(long num) {
        if (num <= 0) {
            return 0;
        }

        //if already cached
        if (softCache.containsKey(num)) {
            SoftReference<Integer> softReg = softCache.get(num);
            if (softReg != null) {
                return softReg.get();
            }
        }

        int steps = 0;
        long current = num;
        Map<Long, Integer> tempPath = new HashMap<>();

        //itertive approach to avoid stackoverflow
        while (current != 1) {
            if (tempPath.containsKey(current)) {
                //cycle found
                break;
            }
            tempPath.put(current, steps);

            SoftReference<Integer> currentRef = softCache.get(current);
            if (currentRef != null) {
                Integer cachedSteps = currentRef.get();
                if (cachedSteps != null) {
                    steps = steps + cachedSteps;
                    break;
                }
            }

            //apply collatz function
            if (current % 2 == 0) {
                current = current / 2;
            } else {
                if (current > (Long.MAX_VALUE - 1) / 3) {
                    steps = steps + approxSteps(current);
                } else {
                    current = current * 3 + 1;
                }
            }
            steps++;
        }

        if (current < (Long.MAX_VALUE / 2)) {
            softCache.put(num, new SoftReference<>(steps));
        }
        return steps;
    }

    private static int approxSteps(long current) {
        return (int) (Math.log(current) * 3.5 + 100);
    }

    static void main() {
        CollatzConjuncture test = new CollatzConjuncture();

        System.out.println(STR."Collatz \{CollatzConjuncture.getCollatz(5L)}");
    }

}
