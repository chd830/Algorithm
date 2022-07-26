package BinarySearch;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1920
public class 수찾기re {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer token = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i = 0 ;i < N; i++)
            arr[i] = Integer.parseInt(token.nextToken());
        Arrays.sort(arr);
        int M = Integer.parseInt(br.readLine());
        int[] find = new int[M];
        token = new StringTokenizer(br.readLine());
        for(int i =  0; i < M; i++)
            find[i] = Integer.parseInt(token.nextToken());
        loop: for(int i = 0; i < M; i++) {
            int start = 0;
            int end = N-1;
            while(start <= end) {
                int mid = (start+end)/2;
                if(arr[mid] == find[i]) {
                    System.out.println(1);
                    continue loop;
                }
                if(arr[mid] > find[i])
                    end = mid-1;
                else
                    start = mid+1;
            }
            System.out.println(0);
        }
    }
}
