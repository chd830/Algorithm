package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준1로만들기re {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] D = new int[1000001];
        int N = Integer.parseInt(br.readLine());
        D[1] = 0;
        for(int i = 2; i <= N; i++) {
            D[i] = D[i-1]+1;
            if(i%2 == 0) {
                D[i] = Math.min(D[i/2]+1, D[i]);
            }
            if(i%3 == 0) {
                D[i] = Math.min(D[i/3]+1, D[i]);
            }
        }
        System.out.println(D[N]);
    }
}
