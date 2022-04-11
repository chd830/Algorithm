package 구현;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/2003
public class 수들의합2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        long M = Long.parseLong(token.nextToken());
        int[] arr = new int[N];
        token = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(token.nextToken());
        long sum = 0;
        int answer = 0;
        int start = 0;
        int i = 0;
        while(true) {
            if(sum > M) {
                sum -= arr[start++];
                continue;
            }
            if(sum == M)
                answer++;
            if(i >= N)
                break;
            sum += arr[i++];
        }
        System.out.println(answer);
    }
}
