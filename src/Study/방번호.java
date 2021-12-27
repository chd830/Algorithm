package Study;

import java.util.Scanner;

public class 방번호 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int[] nums = new int[10];
        for (char c : s.toCharArray()) {
            if(c == '9')
                nums[6]++;
            else
                nums[(int)c-48]++;
        }
        if(nums[6]%2 == 0)
            nums[6] /= 2;
        else
            nums[6] = nums[6]/2+1;
        int max = 0;
        for(int i : nums)
            max = Math.max(max, i);
        System.out.println(max);
    }
}
