package com.practise.capitalone;

public class PalindromeNumberWithoutString {

    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) { //x!=0 is very important to check
            return false;
        }

        int reversed = 0;

        while(x >reversed){
            reversed = reversed*10 + x%10; //reversing the digits
            x= x/10;
        }

        return x ==reversed;
    }
}
