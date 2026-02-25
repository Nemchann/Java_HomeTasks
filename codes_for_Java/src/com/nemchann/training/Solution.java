package com.nemchann.training;

public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x < 10) return true;

        int xOriginal = x;
        int xReversed = 0;
        while (xOriginal > 0){
            xReversed *= 10;
            xReversed += xOriginal % 10;
            xOriginal /= 10;
            System.out.println("reversed = " + xReversed + " orig = " + xOriginal);
        }
        System.out.println(xReversed);
        if (xReversed == x) return true;
        return false;
    }
}