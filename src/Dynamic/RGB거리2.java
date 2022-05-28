package Dynamic;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/17404
public class RGB거리2 {
    static int N;
    static int[][]arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1][3];
        for(int i = 1; i <= N; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(token.nextToken());
            arr[i][1] = Integer.parseInt(token.nextToken());
            arr[i][2] = Integer.parseInt(token.nextToken());
        }
        int[][] d = new int[N+1][3];
        int min = 100000001;
        for(int k = 0; k < 3; k++) {
            for(int i = 0; i < 3; i++) {
                if(i == k)
                    d[1][i] = arr[1][i];
                else
                    d[1][i] = 100000001;
            }
            for(int i = 2; i <= N; i++) {
                d[i][0] = Math.min(d[i-1][1], d[i-1][2])+arr[i][0];
                d[i][1] = Math.min(d[i-1][0], d[i-1][2])+arr[i][1];
                d[i][2] = Math.min(d[i-1][0], d[i-1][1])+arr[i][2];
            }
            for(int i = 0; i < 3; i++) {
                if(i == k)
                    continue;
                min = Math.min(min, d[N][i]);
            }
        }
        System.out.println(min);
    }
}
