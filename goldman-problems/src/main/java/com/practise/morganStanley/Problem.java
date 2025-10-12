package com.practise.morganStanley;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Problem {

    // a list of names return most common name
    // list of emplloyees whats most common

    // hashmap name and int --occurance count O(n
    public Optional<String> getMostCommonName(List<String> employees) {
        Map<String, Integer> nameCountMap = new HashMap<>(); //maintan all the count of the names
        int maxOccuranceCount = 0;
        String result = null;

        employees.forEach(
                employee -> {
                    if (nameCountMap.containsKey(employee)) {
                        nameCountMap.put(employee, nameCountMap.get(employee) + 1);
                    } else {
                        nameCountMap.put(employee, 1);
                    }
                }
        );

        for (String key : nameCountMap.keySet()) {
            int currentCount = nameCountMap.get(key); //for this name what is the count
            if (currentCount > maxOccuranceCount) {
                maxOccuranceCount = currentCount;
                result = key;
            }

            //if equal
            if(currentCount == maxOccuranceCount){
                result = null;
            }
        }

        return  Optional.ofNullable(result);
    }

    static void main() {
        Problem testCase = new Problem();

        List<String> input = new ArrayList<>();
        input.add("vaibhav");
//        input.add("vaibhav");
//        input.add("vaibhav");
//        input.add("vaibhav");

        input.add("Liz");
//        input.add("Liz");
//        input.add("Liz");
//        input.add("Liz");
        // handle caase whne both are higher than one
        System.out.println(STR."most common name : {} \{testCase.getMostCommonName(input)}");

    }
}
