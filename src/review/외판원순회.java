package review;

import java.util.*;
import java.io.*;

public class 외판원순회 {
    static int N;
    static int min;
    static int[] route;
    static int[][] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        min = Integer.MAX_VALUE;
        arr = new int[N][N];
        route = new int[N];
        visited = new boolean[N];
        for(int i = 0; i < N; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N; j++) {
                arr[i][j] = Integer.parseInt(token.nextToken());
            }
        }
        perm(0);
        System.out.println(min == Integer.MAX_VALUE ? 0 : min);
    }
    static void perm(int idx) {
        if(idx == N) {
            visit();
            return;
        }
        for(int i = 0 ;i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                route[idx] = i;
                perm(idx+1);
                visited[i] = false;
            }
        }
    }
    static void visit() {
        int sum = 0;
        int val = 0;
        for(int i = 0; i < N-1; i++) {
            val = arr[route[i]][route[i+1]];
            if(val == 0) {
                return;
            }
            sum += val;
        }
        val = arr[route[N-1]][route[0]];
        if(val == 0) {
            return;
        }
        sum += val;
        min = Math.min(min, sum);
    }
}
