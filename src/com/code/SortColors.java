package com.code;

public class SortColors {
    public static void sortColors(int[] nums) {
        //각각 0,1,2의 숫자를 세서 숫자만큼 nums를 채운다.
        int[] count = new int[3];
        for(int num : nums) {
            if(num == 0)
                count[0]++;
            else if(num == 1)
                count[1]++;
            else
                count[2]++;
        }
        for(int i = 0; i < nums.length; i++) {
            if(count[0] > 0) {
                nums[i] = 0;
                count[0]--;
            }
            else if(count[1] > 0) {
                nums[i] = 1;
                count[1]--;
            }
            else {
                nums[i] = 2;
                count[2]--;
            }
        }
        for(int num : nums) {
            System.out.print(num+"\t");
        }
    }
}
