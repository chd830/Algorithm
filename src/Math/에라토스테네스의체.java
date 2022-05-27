package Math;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/2960
public class 에라토스테네스의체 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int K = Integer.parseInt(token.nextToken());
        boolean[] prime = new boolean[N+1];
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;
        int result = 2;
        for(int i = 2; i <= N; i++) {
            for(int j = i; j <= N; j += i) {
                if(!prime[j])
                    continue;
                prime[j] = false;
                result = j;
                K--;
                if(K == 0) {
                    System.out.println(result);
                    System.exit(0);
                }
            }
        }
    }
}
