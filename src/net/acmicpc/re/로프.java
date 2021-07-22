package net.acmicpc.re;

import java.util.*;
import java.io.*;

// 2217
public class 로프 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        int max = 0;
        for(int i = N-1, cnt = 1; i >= 0; i--, cnt++)
            max = Math.max(cnt*arr[i], max);
        System.out.println(max);
    }
}
