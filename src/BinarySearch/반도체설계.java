package BinarySearch;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/2352
public class 반도체설계 {
    static int N;
    static int[] arr;
    static int[] port;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer token = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(token.nextToken());
        port = new int[N];
        int LIS = 0;
        for(int i = 0; i < N; i++) {
            int idx = binarySearch(arr[i], 0, LIS, LIS+1);
            if(idx == -1)
                port[LIS++] = arr[i];
            else
                port[idx] = arr[i];
        }
        System.out.println(LIS);
    }
    static int binarySearch(int num, int start, int end, int size) {
        int result = 0;
        while(start <= end) {
            int mid = (start+end)/2;
            if(num <= port[mid]) {
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