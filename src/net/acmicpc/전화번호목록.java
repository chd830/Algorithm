package net.acmicpc;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/5052
public class 전화번호목록 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        loop: while(T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            String[] nums = new String[N];
            for(int i = 0; i < N; i++) {
                nums[i] = br.readLine();
            }
            Arrays.sort(nums);
            for(int i = 0; i < N-1; i++) {
                if(nums[i].length() < nums[i+1].length()) {
                    if(nums[i+1].indexOf(nums[i]) == 0) {
                        System.out.println("NO");
                        continue loop;
                    }
                }
            }
            System.out.println("YES");
        }
    }
}