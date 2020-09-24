package net.acmicpc.re;

import java.util.*;
import java.io.*;

//조합
public class N과MII {
    static int N;
    static int M;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        arr = new int[M];
        sequence(0, 0);
    }
    public static void sequence(int idx, int sub) {
        if(sub == M) {
            System.out.println(Arrays.toString(arr));
            return;
        }
        if(idx == N) {
            return;
        }
        arr[sub] = idx+1;
        sequence(idx+1, sub+1);
        sequence(idx+1, sub);
    }
}
