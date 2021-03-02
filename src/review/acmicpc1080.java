package review;

import java.util.*;
import java.io.*;

// 행렬
public class acmicpc1080 {
    static int N;
    static int M;
    static int[][] A;
    static int[][] B;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        A = new int[N][M];
        B = new int[N][M];
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                A[i][j] = str.charAt(j)-'0';
            }
        }
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                B[i][j] = str.charAt(j)-'0';
            }
        }
        int cnt = 0;
        for(int i = 0; i <= N-3; i++) {
            for(int j = 0; j <= M-3; j++) {
                if(A[i][j] != B[i][j]) {
                    swap(i, j);
                    cnt++;
//                    print();
                }
            }
        }
        System.out.println(isSame() ? cnt : -1);
    }
    static boolean isSame() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(A[i][j] != B[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
    static void print() {
        for(int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(A[i]));
        }
        System.out.println();
    }
    static void swap(int x, int y) {
        for(int i = x; i < x+3; i++) {
            for(int j = y; j < y+3; j++) {
                A[i][j] = A[i][j] == 0 ? 1 : 0;
            }
        }
    }
}

/*
3 4
1110
1110
1110
0001
0001
0001

3 4
0110
0110
0110
0001
0001
0001

3 3
000
000
000
000
000
001
 */