package review;

import java.util.*;
import java.io.*;

public class 링크와스타트 {
    static int N;
    static int min;
    static int[][] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        min = Integer.MAX_VALUE;
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N];
        arr = new int[N][N];
        StringTokenizer token = null;
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(token.nextToken());
            }
        }
        comb(0, 0);
        System.out.println(min);
    }
    static void comb(int idx, int cnt) {
        if(cnt >= 2 && N-cnt >= 2) {
//            System.out.println(Arrays.toString(visited)+"\t"+cnt+", "+(N-cnt));
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
        }
        for(int i = idx; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                comb(i+1, cnt+1);
                visited[i] = false;
            }
        }
    }
}
