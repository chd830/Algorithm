package 구현;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/9084
public class 동전 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer token = new StringTokenizer(br.readLine());
            int[] coin = new int[N];
            for(int i = 0; i < N; i++)
                coin[i] = Integer.parseInt(token.nextToken());
            int value = Integer.parseInt(br.readLine());
            int[] d = new int[value+1];
            d[0] = 1;
            for(int i = 0; i < N; i++) {
                for(int j = coin[i]; j <= value; j++) {
                    d[j] += d[j-coin[i]];
                }
            }
            System.out.println(d[value]);
        }
    }
}
