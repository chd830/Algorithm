package recur;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/16198
public class 에너지모으기 {
    static int N;
    static int max;
    static int[] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N];
        arr = new int[N];
        StringTokenizer token = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
        }
        recur(0, 0);
        System.out.println(max);
    }
    static void recur(int cnt, int sum) {
        if(cnt == N-2) {
            max = Math.max(max, sum);
            return;
        }
        for(int i = 1; i < N-1; i++) {
            if(!visited[i]) {
                visited[i] = true;
                int prev = i;
                int next = i;
                while(prev > 0 && visited[prev])
                    prev--;
                while(next < N && visited[next])
                    next++;
                sum += (arr[prev]*arr[next]);
                recur(cnt+1, sum);
                sum -= (arr[prev]*arr[next]);
                visited[i] = false;
            }
        }
    }
}