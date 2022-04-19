package Dynamic;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/22115
public class 창영이와커피 {
    static final int LIMIT = 1234567;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int K = Integer.parseInt(token.nextToken());
        int[] arr = new int[N];
        token = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(token.nextToken());
        int[][] dp = new int[N+1][K+1];
        int[] d = new int[K+1];
        Arrays.fill(d, LIMIT);
        d[0] = 0;
        for(int i = 0; i < N; i++) {
            for(int j = K; j >= arr[i]; j--) {
                d[j] = Math.min(d[j], d[j-arr[i]]+1);
            }
        }
        System.out.println(d[K] == LIMIT ? -1 : d[K]);
    }
}