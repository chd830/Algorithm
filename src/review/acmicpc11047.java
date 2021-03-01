package review;

import java.util.*;
import java.io.*;

// 동전 0
public class acmicpc11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int K = Integer.parseInt(token.nextToken());
        int[] coins = new int[N];
        for(int i = N-1; i >= 0; i--) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        int idx = 0;
        int count = 0;
        while(K > 0) {
            if(K/coins[idx] > 0) {
                count += K/coins[idx];
                K %= coins[idx];
            }
            idx++;
        }
        System.out.println(count);
    }
}
