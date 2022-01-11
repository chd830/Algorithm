package recur;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/14888
public class 연산자끼워넣기 {
    static int N;
    static int max;
    static int min;
    static int[] nums;
    static boolean[] visited;
    static List<Integer> oper;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        nums = new int[N];
        oper = new ArrayList<>();
        StringTokenizer token = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(token.nextToken());
        }
        token = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++) {
            int num = Integer.parseInt(token.nextToken());
            for(int j = num; j > 0; j--) {
                oper.add(i);
            }
        }
        visited = new boolean[oper.size()];
        recur(0, nums[0]);
        System.out.println(max);
        System.out.println(min);
    }
    static void recur(int idx, int sum) {
        if(idx == oper.size()) {
            max = Math.max(max, sum);
            min = Math.min(min, sum);
            return;
        }
        for(int i = 0; i < oper.size(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                switch (oper.get(i)) {
                    case 0:
                        recur(idx+1, sum+nums[idx+1]);
                        break;
                    case 1:
                        recur(idx+1, sum-nums[idx+1]);
                        break;
                    case 2:
                        recur(idx+1, sum*nums[idx+1]);
                        break;
                    case 3:
                        recur(idx+1, sum/nums[idx+1]);
                        break;
                }
                visited[i] = false;
            }
        }
    }
}
