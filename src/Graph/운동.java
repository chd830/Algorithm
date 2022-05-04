package Graph;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1956
public class 운동 {
    // INF값이 너무 작으면 64%에서 문제가 생김
    static final int INF = 987654321;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(token.nextToken());
        int E = Integer.parseInt(token.nextToken());
        int[][] arr = new int[V + 1][V+1];
        for(int i = 0; i <= V; i++)
            Arrays.fill(arr[i], INF);
        for(int i = 0; i < E; i++) {
            token = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(token.nextToken());
            int end = Integer.parseInt(token.nextToken());
            int cost = Integer.parseInt(token.nextToken());
            arr[start][end] = Math.min(arr[start][end], cost);
        }
        for(int k = 1; k <= V; k++) {
            for(int i = 1; i <= V; i++) {
                for(int j = 1; j <= V; j++) {
                    if(arr[i][j] > arr[i][k]+arr[k][j])
                        arr[i][j] = arr[i][k]+arr[k][j];
                }
            }
        }
        int min = INF;
        for(int i = 1; i <= V; i++) {
            min = Math.min(min, arr[i][i]);
        }
        System.out.println(min >= INF ? -1 : min);
    }
}
