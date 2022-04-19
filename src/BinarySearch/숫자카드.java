package BinarySearch;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/10815
public class 숫자카드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer token = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(token.nextToken());
        Arrays.sort(arr);
        int M = Integer.parseInt(br.readLine());
        token = new StringTokenizer(br.readLine());

        loop: for(int i = 0; i < M; i++) {
            int n = Integer.parseInt(token.nextToken());
            int start = 0;
            int end = N-1;
            while(start < end) {
                int mid = (start+end)/2;
                if(arr[mid] == n) {
                    sb.append("1 ");
                    continue loop;
                }
                else if(arr[mid] < n)
                    start = mid+1;
                else
                    end = mid-1;
            }
            if(arr[start] == n)
                sb.append("1 ");
            else
                sb.append("0 ");
        }
        System.out.println(sb.toString());
    }
}
