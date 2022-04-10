package 구현;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/2004
public class 조합0의개수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());
        System.out.println(Math.min(countTwo(N)-countTwo(M)-countTwo(N-M), countFive(N)-countFive(M)-countFive(N-M)));
    }
    static long countTwo(int n) {
        int cnt = 0;
        while(n >= 5) {
            cnt += n/5;
            n /= 5;
        }
        return cnt;
    }
    static long countFive(int n) {
        int cnt = 0;
        long start = 5;
        while(n >= 2) {
            cnt += n/2;
            n /= 2;
        }
        return cnt;
    }
}
