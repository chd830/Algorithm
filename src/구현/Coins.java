package 구현;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/3067
public class Coins {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            StringTokenizer token = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(token.nextToken());
            int M = Integer.parseInt(br.readLine());
            int[] d = new int[M+1];
            d[0] = 1;
            for(int i = 1; i <= N; i++) {
                for(int j = arr[i-1]; j <= M; j++) {
                    d[j] += d[j-arr[i-1]];
                }
            }
            System.out.println(d[M]);
        }
    }
}
