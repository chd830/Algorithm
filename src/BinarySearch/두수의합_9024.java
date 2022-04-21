package BinarySearch;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/9024
public class 두수의합_9024 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < T; t++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(token.nextToken());
            int K = Integer.parseInt(token.nextToken());
            int[] arr = new int[N];
            token = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(token.nextToken());
            Arrays.sort(arr);
            int start = 0;
            int end = N-1;
            long min = (long)arr[start]+arr[end];
            int cnt = 0;
            while(start < end) {
                long sum = (long)arr[start]+arr[end];
                if(Math.abs(K-min) > Math.abs(K-sum))
                    min = sum;
                if(sum < K)
                    start++;
                else
                    end--;
            }
            start = 0;
            end = N-1;
            cnt = 0;
            while(start < end) {
                long sum = (long)arr[start]+arr[end];
                if(Math.abs(K-min) == Math.abs(K-sum))
                    cnt++;
                if(sum < K)
                    start++;
                else
                    end--;
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb.toString());
    }
}