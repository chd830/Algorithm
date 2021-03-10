package review;

import java.util.*;
import java.io.*;

// 점프
public class acmicpc1890 {
    static int N;
    static int[][] arr;
    static long[][] route;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        route = new long[N][N];
        StringTokenizer token = null;
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(token.nextToken());
            }
        }
        route[0][0] = 1;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(route[i][j] == 0 ||(i == N-1 && j == N-1)) {
                    continue;
                }
                int pos = arr[i][j];
                if(pos+i < N) {
                    route[pos+i][j] += route[i][j];
                }
                if(pos+j < N) {
                    route[i][pos+j] += route[i][j];
                }
            }
        }
        for(int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(route[i]));
        }
        System.out.println(route[N-1][N-1]);
    }
}
