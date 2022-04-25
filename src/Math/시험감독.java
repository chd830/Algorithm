package Math;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/13458
public class 시험감독 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer token = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(token.nextToken());
        token = new StringTokenizer(br.readLine());
        int B = Integer.parseInt(token.nextToken());
        int C = Integer.parseInt(token.nextToken());
        long cnt = 0;
        for(int i = 0; i < N; i++) {
            arr[i] -= B;
            if(arr[i] < 0)
                arr[i] = 0;
            cnt++;
            cnt += arr[i]/C;
            if(arr[i]%C != 0)
                cnt++;
        }
        System.out.println(cnt);
    }
}