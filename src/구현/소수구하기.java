package 구현;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1929
public class 소수구하기 {
    static boolean[] prime;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());
        prime = new boolean[M+1];
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;
        for(int i = 2; i <= M; i++) {
            for(int j = i+i; j <= M; j += i) {
                prime[j] = false;
            }
        }
        for(int i = N; i <= M; i++) {
            if(prime[i])
                System.out.println(i);
        }
    }
}
