package BinarySearch;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/13397
public class 수찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer token = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(token.nextToken());
        Arrays.sort(arr);
        int M = Integer.parseInt(br.readLine());
        token = new StringTokenizer(br.readLine());
        loop: for(int i = 0; i < M; i++) {
            int cur = Integer.parseInt(token.nextToken());
            int start = 0;
            int end = N-1;
            while(start < end) {
                int mid = (start+end)/2;
                if(arr[mid] == cur) {
                    System.out.println(1);
                    continue loop;
                }
                if(arr[mid] < cur)
                    start = mid+1;
                else
                    end = mid-1;
            }
            if(arr[start] == cur)
                System.out.println(1);
            else
                System.out.println(0);
        }
    }
}
