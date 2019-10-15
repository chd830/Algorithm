package com.code;

public class JumpGame {
    public boolean canJump(int[] nums) {
        int max = 0;
        for(int i = 0; i < nums.length; i++) {
            System.out.println(i+", nums["+i+"]: "+nums[i]+", max: "+max);
            if(i > max) {
                return false;
            }
            max = Math.max(nums[i] + i, max);
        }
        return true;
    }
}
