package com.practise.capitalone;

public class AlternateDigitSum {

    public int alternateDigitSum(int n) {
        int sum = 0;

        while(n >0){
            sum =  n%10 - sum; //apparently this is math trick.
            n = n/10;
        }
        return sum;
    }
}
