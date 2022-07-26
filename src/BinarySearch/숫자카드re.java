package BinarySearch;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/10815
public class 숫자카드re {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] cards = new int[N];
        StringTokenizer token = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            cards[i] = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(br.readLine());
        token = new StringTokenizer(br.readLine());
        int[] arr = new int[M];
        for(int i = 0; i < M; i++)
            arr[i] = Integer.parseInt(token.nextToken());
        Arrays.sort(cards);
        StringBuilder sb = new StringBuilder();
        loop: for(int i = 0; i < M; i++) {
            int n = arr[i];
            int start = 0;
            int end = N;
            while(start < end) {
                int mid = (start+end)/2;
                if(n == cards[mid]) {
                    sb.append("1 ");
                    continue loop;
                }
                if(n < cards[mid]) {
                    end = mid;
                }
                else
                    start = mid+1;
            }
            sb.append("0 ");
        }
        System.out.println(sb.toString());
    }
}
