package net.acmicpc.re;

import java.util.*;
import java.io.*;

// 2805
public class 나무자르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        long tree = Long.parseLong(token.nextToken());
        int[] arr = new int[N];

        token = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
        }
        Arrays.sort(arr);
        long sum = 0;
        for(int i = arr[N-1]-1; i >= 0; i--) {
            sum = 0;
            for(int j = N-1; j >= 0; j--) {
                if(arr[j] < i)
                    break;
                sum += arr[j]-i;
            }
            if(sum >= tree) {
                System.out.println(i);
                break;
            }
        }
    }
}
