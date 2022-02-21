package 구현;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/2110
public class 공유기설치 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        C = Integer.parseInt(token.nextToken());
        arr = new int[N];
        for(int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        int start = 1;
        int end = arr[N-1] - arr[0]+1;

        while(start < end) {
            int mid = (start+end)/2;
            if(canInstall(mid) < C) {
                end = mid;
            }
            else {
                start = mid+1;
            }
        }
        System.out.println(start-1);
    }
    static int N;
    static int C;
    static int[] arr;
    static int canInstall(int distance) {
        int cnt = 1;
        int last = arr[0];
        for(int i = 1; i < arr.length; i++) {
            int locate = arr[i];
            if(locate - last >= distance) {
                cnt++;
                last = locate;
            }
        }
        return cnt;
    }
}
