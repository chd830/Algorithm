package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 행렬제곱 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        int B = Integer.parseInt(token.nextToken());
        int[][] arr = new int[N][N];
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(token.nextToken());
            }
        }
        int[][] copy = new int[N][N];
        for(int i = 0; i < N; i++) {
            copy[i] = Arrays.copyOf(arr[i], N);
        }
        for(int i = 0; i < B; i++) {
            print(arr);
            pow(arr, copy);
        }
    }

    public static void print(int[][] arr) {
        for(int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }
    public static void pow(int[][] arr, int[][] copy) {
        for(int i = 0, idx = 0; i < N*N; i++) {
            int temp = 0;
            System.out.print((i/N)+", "+idx+"\t");
            for(int j = 0; j < N; j++) {
                temp += (arr[i/N][j] * copy[j][i/N])%1000;
                System.out.print("("+(i/N)+", "+j+")("+j+", "+idx+")");
            }
            arr[i/N][idx++] = temp;
            if(idx == N) {
                idx = 0;
            }
            System.out.print("\t\t");
        }
        System.out.println("\n");
    }
}
