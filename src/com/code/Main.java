package com.code;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        JumpGame j = new JumpGame();
        int[] nums = {3, 2, 1, 0, 4};
        System.out.println(j.canJump(nums));
    }
}
