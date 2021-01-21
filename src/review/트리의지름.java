package review;

import java.util.*;
import java.io.*;

public class 트리의지름 {
    static boolean[] visited;
    static int[][] list;
    static int max;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new int[N+1][N+1];
        StringTokenizer token = null;
        for(int i = 0; i < N-1; i++) {
            token = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(token.nextToken());
            int n2 = Integer.parseInt(token.nextToken());
            int n3 = Integer.parseInt(token.nextToken());
            list[n1][n2] = n3;
            list[n2][n1] = n3;
        }

        for(int i = 1; i <= N; i++) {
            visited = new boolean[N+1];
            visited[i] = true;
            recur(i, 0);
        }
        System.out.println(max);
    }
    static void recur(int idx, int sum) {
        max = Math.max(max, sum);
        for(int i = 1; i <= N; i++) {
            if(!visited[i] && list[idx][i] != 0) {
                visited[i] = true;
                recur(i, sum+list[idx][i]);
            }
        }
    }
}
