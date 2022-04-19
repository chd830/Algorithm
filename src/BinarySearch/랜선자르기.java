package BinarySearch;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1654
public class 랜선자르기 {
    static int N;
    static int K;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        K = Integer.parseInt(token.nextToken());
        arr = new int[N];
        for(int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        long min = 1;
        long mid = 0;
        long max = arr[N-1];
        while(min <= max) {
            mid = (max+min) / 2;
            long cnt = 0;
            for(int i = 0; i < N; i++)
                cnt += arr[i]/mid;
            if(cnt < K)
                max = mid-1;
            else
                min = mid+1;
        }
        System.out.println(max);
    }
}