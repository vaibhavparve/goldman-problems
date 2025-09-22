package com.practise.bloomberg.easy;

import java.util.HashSet;
import java.util.Set;

public class IsPangram {
    public boolean isSentencePangram(String sentence){
        //sentence is pangram if it contains atlest one of all the letters of english
        //corner case
        if(sentence.length()< 26){
            return false;
        }

        Set<Character> charSet = new HashSet<>();
        //just maintain set of all the chars in egnlish
        char a = 'a';
        for(int i=0; i<26; i++){
            charSet.add((char)(a+i));
        }

        for(char c: sentence.toCharArray()){
            charSet.remove(c);
        }

        return charSet.isEmpty();
    }

    static void main() {
        IsPangram test = new IsPangram();

        System.out.println("is pangram {}" + test.isSentencePangram("testdsf"));
    }
}
