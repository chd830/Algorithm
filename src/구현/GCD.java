package 구현;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/9613
public class GCD {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            nums = new int[Integer.parseInt(token.nextToken())];
            for(int j = 0; j < nums.length; j++)
                nums[j] = Integer.parseInt(token.nextToken());
            sum = 0;
            comb(0, 0);
            sb.append(sum).append("\n");
        }
        System.out.println(sb.toString());
    }
    static long sum;
    static int[] arr = new int[2];
    static int[] nums;
    static void comb(int idx, int cur) {
        if(cur == 2) {
            sum += GCD(nums[arr[0]], nums[arr[1]]);
            return;
        }
        if(idx == nums.length)
            return;
        arr[cur] = idx;
        comb(idx+1, cur+1);
        comb(idx+1, cur);
    }
    static int GCD(int a, int b) {
        if(b == 0)
            return a;
        return GCD(b, a%b);
    }
}