package net.acmicpc.re;

import java.util.*;
import java.io.*;

// 2579
public class 계단오르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        int[] d = new int[N+1];
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 세개를 연속으로 밟진 못하지만 한개나 두개씩 오를 수 있음
        d[1] = arr[1];
        if(N >= 2)
            d[2] = arr[1]+arr[2];
        /*
        10  20  15  25  10  20
        10: 0
        10+20: 0+1
        10+20+15: 0+1+2
        10+20+25: 0+1+3
        10+20+25+10: 0+1+3+4
        10+20+25+20: 0+1+3+5
         */

        for(int i = 3; i <= N; i++) {
            d[i] = Math.max(d[i-2]+arr[i], arr[i]+arr[i-1]+d[i-3]);
        }
        System.out.println(d[N]);
    }
}
