package review;

import java.util.*;
import java.io.*;

// 가장 긴 증가하는 부분 수열
public class acmicpc11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer token = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
        }
        int[] d = new int[N];
        Arrays.fill(d, 1);
        int max = 1;
        for(int i = 1; i < N; i++) {
            for(int j = 0; j < i; j++) {
                if(arr[i] > arr[j]) {
                    d[i] = Math.max(d[i], d[j]+1);
                }
            }
            max = Math.max(max, d[i]);
        }
        System.out.println(max);
    }
}
