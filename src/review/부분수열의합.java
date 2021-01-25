package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 부분수열의합 {
    static int N;
    static int S;
    static int res;
    static int[] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        S = Integer.parseInt(token.nextToken());
        res = 0;
        arr = new int[N];
        visited = new boolean[N];
        token = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
        }
        subset(0, 0);
        System.out.println(res);
    }
    static void subset(int idx, int cnt) {
        if(cnt != 0) {
            int sum = 0;
            for(int i = 0; i < arr.length; i++) {
                sum += visited[i] ? arr[i] : 0;
            }
            if(sum == S) {
                res++;
            }
        }
        for(int i = idx; i < arr.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                subset(i+1, cnt+1);
                visited[i] = false;
            }
        }
    }
}
