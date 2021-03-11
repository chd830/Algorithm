package review;

import java.util.*;
import java.io.*;

// 가장 큰 증가 부분 수열
public class acmicpc11055 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        int[] d = new int[N+1];
        StringTokenizer token = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
        }

        int max = 0;
        d[0] = arr[0];
        for(int i = 1; i <= N; i++) {
            d[i] = arr[i];
            for(int j = 1; j < i; j++) {
                if(arr[j] < arr[i]) {
                    d[i] = Math.max(d[i], d[j]+arr[i]);
                }
            }
            max = Math.max(d[i], max);
        }
        System.out.println(max);
    }
}
