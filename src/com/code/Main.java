package com.code;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        LongestIncreasingSubsequence l = new LongestIncreasingSubsequence();
        System.out.println(l.lengthOfLIS(new int[] {4,10,4,3,8,9}));
        System.out.println("---------");
        System.out.println(l.lengthOfLIS(new int[] {10,9,2,5,3,4}));
        System.out.println("---------");
        System.out.println(l.lengthOfLIS(new int[] {-2, -1}));
    }
}
