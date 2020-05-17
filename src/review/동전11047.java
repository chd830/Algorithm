package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 동전11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int K = Integer.parseInt(token.nextToken());
        int[] coins = new int[N];
        for(int i = N-1; i >= 0; i--) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        int cnt = 0;
        for(int i = 0; i < N; i++) {
            if(K/coins[i] > 0) {
                cnt += K/coins[i];
                K %= coins[i];
            }
        }
        System.out.println(cnt);
    }
}
