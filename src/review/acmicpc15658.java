package review;

import java.util.*;
import java.io.*;

// 연산자 끼워넣기(2)
public class acmicpc15658 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        StringTokenizer token = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(token.nextToken());
        }
        opers = new int[4];
        token = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++) {
            opers[i] = Integer.parseInt(token.nextToken());
        }
        calc(1, nums[0]);
        System.out.println(max+"\n"+min);
    }
    static int N;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int[] nums;
    static int[] opers;
    static void calc(int idx, int sum) {
        if(idx == N) {
            max = Math.max(max, sum);
            min = Math.min(min, sum);
//            System.out.println(max+"\t"+min);
            return;
        }
        for(int i = 0; i < opers.length; i++) {
            if(opers[i] > 0) {
                opers[i]--;
                switch (i) {
                    case 0:
                        calc(idx+1, sum+nums[idx]);
                        break;
                    case 1:
                        calc(idx+1, sum-nums[idx]);
                        break;
                    case 2:
                        calc(idx+1, sum*nums[idx]);
                        break;
                    case 3:
                        calc(idx+1, sum/nums[idx]);
                        break;
                }
                opers[i]++;
            }
        }
    }
}
