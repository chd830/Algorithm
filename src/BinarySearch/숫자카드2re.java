package BinarySearch;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/10816
public class 숫자카드2re {
    static int N;
    static int[] cards;
    static int M;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cards = new int[N];
        StringTokenizer token = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            cards[i] = Integer.parseInt(token.nextToken());
        Arrays.sort(cards);
        M = Integer.parseInt(br.readLine());
        arr = new int[M];
        token = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++)
            arr[i] = Integer.parseInt(token.nextToken());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++) {
            int high = findHigh(arr[i]);
            int low = findLow(arr[i]);
            sb.append(high-low).append(" ");
        }
        System.out.println(sb.toString());
    }
    static int findLow(int n) {
        int start = 0;
        int end = N;
        while(start < end) {
            int mid = (start+end)/2;
            if(cards[mid] >= n)
                end = mid;
            else
                start = mid+1;
        }
        return start;
    }
    static int findHigh(int n) {
        int start = 0;
        int end = N;
        while(start < end) {
            int mid = (start+end)/2;
            if(cards[mid] > n)
                end = mid;
            else
                start = mid+1;
        }
        return start;
    }
}
