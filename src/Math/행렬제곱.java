package Math;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/10830
public class 행렬제곱 {
    static final int MOD = 1000;
    static int N;
    static int[][] origin;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        long B = Long.parseLong(token.nextToken());
        origin = new int[N][N];
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                origin[i][j] = Integer.parseInt(token.nextToken())%MOD;
            }
        }
        int[][] result = pow(origin, B);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++)
                sb.append(result[i][j]).append(" ");
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
    static int[][] pow(int[][] A, long B) {
        if(B == 1)
            return A;

        // 분할정복으로 접근
        int[][] result = pow(A, B/2);

        // 행렬을 제곱하기
        result = multiple(result, result);

        // 홀수번째에는 기존의 배열 곱해주기
        if(B%2 == 1)
            result = multiple(result, origin);
        return result;
    }
    static int[][] multiple(int[][] a, int[][]b) {
        int[][] result = new int[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                for(int k = 0; k < N; k++) {
                    result[i][j] += a[i][k]*b[k][j];
                    result[i][j] %= MOD;
                }
            }
        }
        return result;
    }
}
