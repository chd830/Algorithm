package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 한수1065 {
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        cnt = 0;
        for(int i = Integer.parseInt(str); i > 0 ; i--) {
            if(checkNum(""+i)) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
    static boolean checkNum(String num) {
        char[] nums = num.toCharArray();
        if(nums.length == 1) {
            return true;
        }
        int d = nums[nums.length-2] - nums[nums.length-1];
        for(int len = nums.length-1; len >= 1; len--) {
            int dif = nums[len-1] - nums[len];
            if(dif != d) {
                return false;
            }
        }
        return true;
    }
}
