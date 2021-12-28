package perm;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/14888
public class 연산자끼워넣기 {
    static int N;
    static int max;
    static int min;
    static int[] arr;
    static int[] nums;
    static int[] oper = new int[4];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        nums = new int[N-1];
        StringTokenizer token = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
        }
        token = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++) {
            oper[i] = Integer.parseInt(token.nextToken());
        }
        // +, -, *, /
        if(N == 2) {
            for(int i = 0; i < 4; i++) {
                if(oper[i] != 0) {
                    switch (i) {
                        case 0:
                            System.out.println(arr[0]+arr[1]);
                            System.out.println(arr[0]+arr[1]);
                            break;
                        case 1:
                            System.out.println(arr[0]-arr[1]);
                            System.out.println(arr[0]-arr[1]);
                            break;
                        case 2:
                            System.out.println(arr[0]*arr[1]);
                            System.out.println(arr[0]*arr[1]);
                            break;
                        case 3:
                            System.out.println(arr[0]/arr[1]);
                            System.out.println(arr[0]/arr[1]);
                            break;
                    }
                }
            }
        }
        else {
            for(int i = 0, idx = 0; i < N-1; ) {
                if(oper[idx] == 0) {
                    idx++;
                }
                else {
                    nums[i++] = idx + 1;
                    oper[idx]--;
                }
            }
            perm = new int[N-1];
            visited = new boolean[N-1];
            permute(0);
            System.out.println(max);
            System.out.println(min);
        }
    }
    static int[] perm;
    static boolean[] visited;
    static void permute(int idx) {
        if(idx == perm.length) {
            int result = arr[0];
            for(int i = 0; i < perm.length; i++) {
                switch (perm[i]) {
                    case 1:
                        result += arr[i+1];
                        break;
                    case 2:
                        result -= arr[i+1];
                        break;
                    case 3:
                        result *= arr[i+1];
                        break;
                    case 4:
                        result /= arr[i+1];
                        break;
                }
            }
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }
        for(int i = 0; i < perm.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                perm[idx] = nums[i];
                permute(idx+1);
                visited[i] = false;
            }
        }
    }
}
