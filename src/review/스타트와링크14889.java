package review;

import java.util.*;
import java.io.*;

public class 스타트와링크14889 {
    static int N;
    static int min;
    static int[][] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        min = Integer.MAX_VALUE;
        arr = new int[N][N];
        visited = new boolean[N];
        visited[0] = true;
        StringTokenizer token = null;
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            for(int j = 0 ;j < N; j++) {
                arr[i][j] = Integer.parseInt(token.nextToken());
            }
        }
        perm(1);
        System.out.println(min);
    }
    static void perm(int idx) {
        if(idx == N/2) {
            int sum1 = 0;
            int sum2 = 0;
            for(int i = 0; i < N; i++) {
                for(int j = i+1; j < N; j++) {
                    if(visited[i] != visited[j]) {
                        continue;
                    }
                    if(visited[i]) {
                        sum1 += arr[i][j] + arr[j][i];
                    }
                    else {
                        sum2 += arr[i][j] + arr[j][i];
                    }
                }
            }
            min = Math.min(min, Math.abs(sum1-sum2));
            return;
        }
        for(int i = 1; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                perm(idx+1);
                visited[i] = false;
            }
        }
    }
}
