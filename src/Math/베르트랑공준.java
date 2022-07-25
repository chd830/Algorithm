package Math;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/4948
public class 베르트랑공준 {
    static boolean[] nums = new boolean[300000];
    static void set() {
        Arrays.fill(nums, true);
        nums[0] = nums[1] = false;
        for(int i = 2; i < nums.length/2; i++) {
            for(int j = i+i; j < nums.length; j+=i) {
                nums[j] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        set();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = "";
        StringBuilder sb = new StringBuilder();
        while(!(n = br.readLine()).equals("0")) {
            int start = Integer.parseInt(n);
            int cnt = 0;
            for(int i = start+1; i <= start*2; i++) {
                if(nums[i])
                    cnt++;
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb.toString());
    }
}
