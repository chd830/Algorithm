package BinarySearch;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1219
public class 가장긴증가하는부분수열2 {
    static int N;
    static int[] arr;
    static int[] d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        d = new int[N];
        StringTokenizer token = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
           arr[i] = Integer.parseInt(token.nextToken());
        int LIS = 0;
        for(int i = 0; i < N; i++) {
            int idx = binarySearch(arr[i], 0, LIS, LIS+1);
            if(idx == -1)
                d[LIS++] = arr[i];
            else
                d[idx] = arr[i];
        }
        System.out.println(LIS);
    }
    static int binarySearch(int num, int start, int end, int size) {
        int result = 0;
        while(start <= end) {
            int mid = (start+end)/2;
            if(num <= d[mid]) {
                result = mid;
                end = mid-1;
            }
            else
                start = mid+1;
        }
        if(start == size)
            return -1;
        return result;
    }
}
