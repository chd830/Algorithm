package BinarySearch;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/2022
public class 구간나누기2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());
        int[] arr = new int[N];
        int min = 0;
        int max = 0;
        token = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }
        int start = 0;
        int end = max-min;
        while(start <= end) {
            int mid = (start+end)/2;
            if(count(arr, mid, M))
                end = mid-1;
            else
                start = mid+1;
        }
        System.out.println(start);
    }
    static boolean count(int[] arr, int value, int M) {
        int cnt = 1;
        int min = arr[0];
        int max = arr[0];
        for(int i = 1; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
            if((max-min) > value) {
                min = arr[i];
                max = arr[i];
                cnt++;
                if(cnt > M)
                    return false;
            }
        }
        return true;
    }
}