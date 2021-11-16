package net.acmicpc;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1946
public class 신입사원 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] paper = new int[N];
            int[] grade = new int[N];
            for(int i = 0; i < N; i++) {
                token = new StringTokenizer(br.readLine());
                paper[i] = Integer.parseInt(token.nextToken());
                grade[i] = Integer.parseInt(token.nextToken());
            }
        }
    }
}
