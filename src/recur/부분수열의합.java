package recur;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1182
public class 부분수열의합 {
    static int N;
    static int S;
    static int result;
    static int[] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        result = 0;
        N = Integer.parseInt(token.nextToken());
        S = Integer.parseInt(token.nextToken());
        arr = new int[N];
        visited = new boolean[N];
        token = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
        }
        recur(0, 0, 0);
        System.out.println(result);
    }
    static void recur(int idx, int cnt, int sum) {
        if(cnt != 0) {
            if(sum == S) {
//                for(int i = 0; i < N; i++)
//                    System.out.print(visited[i] ? arr[i]+" " : " ");
//                System.out.println();
                result++;
            }
        }
        for(int i = idx; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                recur(i+1, cnt+1, sum+arr[i]);
                visited[i] = false;
            }
        }
    }
}
