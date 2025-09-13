package com.practise.goldman_problems.medium;

import java.util.HashMap;
import java.util.Map;

public class FractionToDecimal {

    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder result = new StringBuilder();

        //approach check for negative case and apply - sign to the numerator
        // divide and get the first part of the result and if reminder is zero return the result
        // keep dividing reminder unitil we find a pattern, upto certain index.

        if ((numerator < 0) ^ (denominator < 0)) {
            result.append("-");
        }

        Long num = Math.abs((long) numerator);
        Long den = Math.abs((long) denominator);
        result.append(num / den);

        num %= den;

        if (num == 0) {
            return result.toString();
        }
        //lets maintain a reminder map till the momemt it reminder
        result.append(".");
        Map<Long, Integer> reminderMap = new HashMap<>();
        while (num != 0) {
            if (reminderMap.containsKey(num)) {
                int index = reminderMap.get(num);
                result.insert(index, "(");
                result.append(")");
                break;
            }
            reminderMap.put(num, result.length());
            num = num * 10;
            result.append(num / den);
            num = num % den;
        }

        return result.toString();
}

static void main() {
    FractionToDecimal test = new FractionToDecimal();

    System.out.printf("result %s%n", test.fractionToDecimal(22, 7));

}
}
