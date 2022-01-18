package Study;

import java.util.Scanner;

public class 방번호 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int[] nums = new int[10];
//        v1
//        for (char c : s.toCharArray()) {
//            if(c == '9')
//                nums[6]++;
//            else
//                nums[(int)c-48]++;
//        }
//        if(nums[6]%2 == 0)
//            nums[6] /= 2;
//        else
//            nums[6] = nums[6]/2+1;
//        int max = nums[0];
//        for(int i : nums)
//            max = Math.max(max, i);
//        System.out.println(max);

//        v2
         for(char c : s.toCharArray())
             nums[(int)c-48]++;
         nums[6] += nums[9];
         nums[6] = nums[6]%2 == 0 ? nums[6]/2 : nums[6]/2+1;
         nums[9] = 0;
         int max = nums[0];
         for(int i : nums)
             max = Math.max(max, i);
        System.out.println(max);
    }
}
