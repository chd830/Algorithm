package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 모든순열 {
    static int N;
    static int[] sub;
    static boolean[] visited;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        sub = new int[N];
        visited = new boolean[N];
        permute(0);
        System.out.println(sb.toString());
    }
    static void permute(int idx) {
        if(idx == N) {
            for(int i = 0; i < N-1; i++) {
                sb.append(sub[i]).append(" ");
            }
            sb.append(sub[N-1]).append("\n");
        }
        for(int i = 1; i <= N; i++) {
            if(!visited[i-1]) {
                sub[idx] = i;
                visited[i-1] = true;
                permute(idx+1);
                visited[i-1] = false;
            }
        }
    }
}
