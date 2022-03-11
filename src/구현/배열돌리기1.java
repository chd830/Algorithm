package 구현;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/16926
public class 배열돌리기1 {
    static int N;
    static int M;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        int R = Integer.parseInt(token.nextToken());
        arr = new int[N][M];
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(token.nextToken());
            }
        }
//        print();
        while(R-- > 0) {
            for(int i = 0; i < Math.min(N, M)/2; i++)
                rotate(i);
//            print();
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
    static void print() {
        for(int i = 0; i < N; i++)
            System.out.println(Arrays.toString(arr[i]));
        System.out.println();
    }
    static void rotate(int idx) {
        int tmp = arr[idx][idx];
        // 아래로 이동
        for(int i = idx; i < N -idx; i++) {
            int temp = arr[i][idx];
            arr[i][idx] = tmp;
            tmp = temp;
        }
        // 오른쪽으로 이동
        for(int i = idx+1; i < M -idx; i++) {
            int temp = arr[N -1-idx][i];
            arr[N -1-idx][i] = tmp;
            tmp = temp;
        }
        // 위로 이동
        for(int i = N -2-idx; i >= idx; i--) {
            int temp = arr[i][M -1-idx];
            arr[i][M -1-idx] = tmp;
            tmp = temp;
        }
        // 왼쪽으로 이동
        for(int i = M -2-idx; i >= idx; i--) {
            int temp = arr[idx][i];
            arr[idx][i] = tmp;
            tmp = temp;
        }
    }
}
