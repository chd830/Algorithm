package com.code;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;

        for (int x : nums) {
        /*
        binarySearch(int[] a, int fromIndex, int toIndex, int key)
        특정 숫자가 포함되었는지 여부와 포함되지 않았을 때 그 숫자의 위치까지 return
        foreach문으로 배열의 요소를 하나하나 가져와서 새 배열인 dp에 넣는다.
        */
            int i = Arrays.binarySearch(dp, 0, len, x);
            if (i < 0)
                i = -(i + 1);
            dp[i] = x;
            if (i == len)
                len++;
            for(int d : dp)
                System.out.print(d+"\t");
            System.out.println("len: "+len);
        }

        return len;
    }
}
