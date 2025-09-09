package com.practise.goldman_problems.gcd;


/*
* You are given a string s in the form "a/b", where a and b are integers (which may be positive or negative).
Your task is to reduce the fraction into its lowest terms.

If the fraction reduces to an integer, return the integer (as a string).
If not, return the simplified fraction in the form "p/q".
Ensure the denominator is always positive (move any negative sign to the numerator).
*
* Input: "13/12"
Output: "13/12"

Input: "4/6"
Output: "2/3"

Input: "10/100"
Output: "1/10"

Input: "100/400"
Output: "1/4"

Input: "7/35"
Output: "1/5"

Input: "-12/13"
Output: "-12/13"

Input: "12/-4"
Output: "-3"

Input: "-8/-4"
Output: "2"
* */
public class SimplifyFractions {

    public static void main(String[] args) {
        SimplifyFractions prob = new SimplifyFractions();

        System.out.println("simplified fraction of 13/12: " + prob.getSimplifiedFraction("13/12"));
        System.out.println("simplified fraction of 12/-4: " + prob.getSimplifiedFraction("12/-4"));
        System.out.println("simplified fraction of 7/35: " + prob.getSimplifiedFraction("7/35"));
        System.out.println("simplified fraction of -12/13: " + prob.getSimplifiedFraction("-12/13"));
        System.out.println("simplified fraction of 100/400: " + prob.getSimplifiedFraction("100/400"));
    }

    public String getSimplifiedFraction(String s) {
        String result;
        String[] split = s.split("/");
        int numerator = Integer.parseInt(split[0]);
        int denominator = Integer.parseInt(split[1]);

        if (denominator < 0) {
            denominator = -denominator;
            numerator = -numerator;
        }

        /*GCD stands for Greatest common Divisor or HCF Highest common factor */
        int gcd = gcd(Math.abs(numerator), Math.abs(denominator));

        numerator /= gcd;
        denominator /= gcd;

        if (denominator == 1) {
            result = String.valueOf(numerator);
        } else {
            result = numerator + "/" + denominator;
        }

        return result;
    }

    /*this is the key* consider example of GCD of (48, 18) Euclidean algorithm for GCD is GCD(a/b) = GCD(b, a%b) */
    public int gcd(int a, int b) {
        while (b != 0) {
            int temp = b; //temp =18
            b = a % b; // b = 12
            a = temp; // a =18
        }
        return a;
    }
}
