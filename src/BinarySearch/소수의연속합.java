package BinarySearch;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1644
public class 소수의연속합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] prime = new boolean[N+1];
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;
        for(int i = 2; i <N; i++) {
            for(int j = i+i; j <= N; j +=i) {
                prime[j] = false;
            }
        }
        List<Integer> primeList = new ArrayList<>();
        for(int i = 2; i <= N; i++) {
            if (prime[i])
                primeList.add(i);
        }
        int cnt = 0;
        int start = 0;
        int idx = 0;
        int end = primeList.size()-1;
        int sum = 0;
        while(start <= end) {
            if(sum == N)
                cnt++;
            if(sum < N)
                sum += primeList.get(start++);
            else
                sum -= primeList.get(idx++);
        }
        System.out.println(prime[N] ? cnt+1 : cnt);
    }
}
