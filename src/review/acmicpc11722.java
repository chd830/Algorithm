package review;

import java.util.*;
import java.io.*;

// 가장 긴 감소하는 부분 수열
public class acmicpc11722 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] d = new int[N];
        StringTokenizer token = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
        }
        int max = 0;
        for(int i = 0; i < N; i++) {
            d[i] = 1;
            for(int j = 1; j < i; j++) {
                if(arr[i] < arr[j]) {
                    d[i] = Math.max(d[i], d[j]+1);
                }
            }
            max = Math.max(d[i], max);
        }
        System.out.println(max);
    }
}
