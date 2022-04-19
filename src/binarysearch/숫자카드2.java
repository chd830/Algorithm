package binarysearch;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/10816
public class 숫자카드2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer token = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        token = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++) {
            int n = Integer.parseInt(token.nextToken());
            sb.append(upperbound(n)-lowerbound(n)).append(" ");
        }
        System.out.println(sb.toString());
    }
    static int N;
    static int[] arr;
    static int lowerbound(int n) {
        int start = 0;
        int end = N;
        while(start < end) {
            int mid = (start+end)/2;
            if(arr[mid] >= n)
                end = mid;
            else
                start = mid+1;
        }
        return start;
    }
    static int upperbound(int n) {
        int start = 0;
        int end = N;
        while(start < end) {
            int mid = (start+end)/2;
            if(arr[mid] > n)
                end = mid;
            else
                start = mid+1;
        }
        return start;
    }
}
