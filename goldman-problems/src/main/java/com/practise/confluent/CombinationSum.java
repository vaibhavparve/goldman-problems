package com.practise.confluent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//backtracking or recursion
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort( candidates ); // to eliminate early terminations
        List<List<Integer>> res = new ArrayList<>();
        backtrackCombinations(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtrackCombinations(int[] candidates, int remaining, int start, ArrayList<Integer> current, List<List<Integer>> res) {
        //it means we foudn the sum
        if(remaining == 0){
            res.add(new ArrayList<>(current));
        }

        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > remaining) {
                break;
            }
            current.add(candidates[i]);
            backtrackCombinations(candidates, remaining - candidates[i], i, current, res); //using start again with i means allow repeat
            current.removeLast();
        }
    }
}
