package review;

import java.util.*;
import java.io.*;

// 30
public class acmicpc10610 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] nums = br.readLine().toCharArray();
        // 버블정렬은 오래걸려서 시간초과가 난다.
        Arrays.sort(nums);

        int sum = 0;
        for(char c : nums) {
            sum += c-'0';
        }
        if(sum%3 == 0 && nums[0] == '0') {
            for(int i = nums.length-1; i >= 0; i--) {
                System.out.print(nums[i]);
            }
        }
        else {
            System.out.println(-1);
        }
    }
}
