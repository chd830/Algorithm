package net.acmicpc.re;

import java.util.*;
import java.io.*;

public class 약수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 약수의 개수
        int N = Integer.parseInt(br.readLine());
        StringTokenizer token = new StringTokenizer(br.readLine());
        // 1과 A를 제외한 약수들
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
        }
        Arrays.sort(arr);
        System.out.println(arr[0]*arr[N-1]);
    }
}
