package review;

import java.util.*;
import java.io.*;

// 동전 1
public class acmicpc2293 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int K = Integer.parseInt(token.nextToken());
        int[] arr = new int[N];
        int[] coins = new int[K+1];
        coins[0] = 1;
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            for(int j = arr[i]; j <= K; j++) {
                coins[j] += coins[j - arr[i]];
                System.out.println(j+"\t"+(j-arr[i])+Arrays.toString(coins));
            }
        }
        System.out.println(coins[K]);
    }
}
