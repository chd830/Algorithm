package net.acmicpc.re;

import java.util.*;
import java.io.*;

//1644
public class 소수의연속합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] prime = new boolean[N+1];
        List<Integer> primeList = new ArrayList<>();
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;
        for(int i = 2; i <= N; i++) {
            for(int j = i+i; j <= N; j += i) {
                prime[j] = false;
            }
        }
        for(int i = 0; i <= N; i++) {
            if(prime[i])
                primeList.add(i);
        }
        int start = 0;
        int end = primeList.size()-1;
        int sum = 0;
        int cnt = 0;
        int idx = 0;
        while(start <= end) {
            if(sum == N)
                cnt++;
            if(sum >= N) {
                sum -= primeList.get(idx++);
            }
            else
                sum += primeList.get(start++);
        }
        if(prime[N])
            cnt++;
        System.out.println(cnt);
    }
}
