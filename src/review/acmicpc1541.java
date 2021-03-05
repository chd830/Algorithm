package review;

import java.util.*;
import java.io.*;

// 잃어버린 괄호
public class acmicpc1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String strs = br.readLine();
        String[] nums = strs.split("\\-|\\+");
        char[] opers = strs.replaceAll("[0-9]","").toCharArray();
        int res = Integer.parseInt(nums[0]);
        int sum = 0;
        boolean check = false;
        // 1+2-3+7-5+3
        for(int i = 1; i < nums.length; i++) {
            if(opers[i-1] == '-') {
                if(check) {
                    res -= sum;
                    sum = Integer.parseInt(nums[i]);
                }
                else {
                    sum += Integer.parseInt(nums[i]);
                    check = !check;
                }
            }
            else if(check) {
                sum += Integer.parseInt(nums[i]);
            }
            else {
                res += Integer.parseInt(nums[i]);
            }
        }
        if(sum != 0) {
            res -= sum;
        }
        System.out.println(res);
    }
}
