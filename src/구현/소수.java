package 구현;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/2581
public class 소수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        boolean[] prime = new boolean[10001];
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;
        for(int i = 2; i < prime.length/2; i++) {
            for(int j = i+i; j < prime.length; j+=i) {
                prime[j] = false;
            }
        }
        int min = -1;
        long sum = 0;
        for(int i = N; i <= M; i++) {
            if(prime[i]) {
                sum += i;
                if(min == -1)
                    min = i;
            }
        }
        if(min == -1)
            System.out.println(-1);
        else {
            System.out.println(sum);
            System.out.println(min);
        }
    }
}
