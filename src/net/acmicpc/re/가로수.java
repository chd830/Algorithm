package net.acmicpc.re;

import java.util.*;
import java.io.*;

// 2485
public class 가로수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int[] dist = new int[N-1];
        for(int i = 0; i <= N-2; i++) {
            dist[i] = arr[i+1] - arr[i];
        }
        int n = gcd(dist[0], dist[1]);
        for(int i = 2; i < N-2; i++) {
            n = gcd(n, dist[i]);
            if(n == 1)
                break;
        }
        int total = 0;
        for(int i = 0; i < N-1; i++)
            total += dist[i]/n-1;
        System.out.println(total);
    }
    static int gcd(int n, int m) {
        if(m == 0)
            return n;
        return gcd(m, n%m);
    }
}