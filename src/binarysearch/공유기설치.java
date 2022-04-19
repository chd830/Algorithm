package BinarySearch;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/2110
public class 공유기설치 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        C = Integer.parseInt(token.nextToken());
        // C개의 공유기를 설치하기위한 최대거리구하기
        arr = new int[N];
        for(int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);

        int start = 1;
        int end = arr[N-1]-arr[0]+1;

        while(start < end) {
            int mid = (start+end)/2;
            if(can(mid) < C)
                end = mid;
            else
                start = mid+1;
        }
        System.out.println(start-1);
    }
    static int N;
    static int C;
    static int[] arr;
    static int can(int dist) {
        int cnt = 1;
        int last = arr[0];
        for(int i = 1; i < N; i++) {
            int locate = arr[i];
            if(locate-last >= dist) {
                cnt++;
                last = locate;
            }
        }
        return cnt;
    }
}