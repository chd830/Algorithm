package com.swexpertacademy;

import java.util.Arrays;
import java.util.Scanner;

public class 벌꿀채취 {
    static int N;
    static int M;
    static int C;
    static int[] sub;
    static int[] map;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t <= T; t++) {
            N = sc.nextInt();
            M = sc.nextInt();
            C = sc.nextInt();
            sub = new int[M*2];
            map = new int[N*N];
            visited = new boolean[N*N];
            for(int i = 0; i < map.length; i++) {
                map[i] = sc.nextInt();
            }
            permute(0);
            System.out.println("#"+t+" "+max);
            max = 0;
        }
    }
    static int max = 0;

    public static void getMax() {
        int[] sub1 = Arrays.copyOfRange(sub, 0, M);
        int[] sub2 = Arrays.copyOfRange(sub, M, M*2);
        Arrays.sort(sub1);
        Arrays.sort(sub2);
        int sum1 = 0;
        int limit = 0;
        for(int i = M-1; i >= 0; i--) {
            if(sub1[i] > limit) {
                break;
            }
            sum1 += sub1[i]*sub1[i];
        }
        int sum2 = 0;
        limit = 0;
        for(int i = M-1; i >= 0; i--) {
            if(sub2[i] < limit) {
                break;
            }
            sum2 += sub2[i]*sub2[i];
        }
        max = Math.max(max, sum1+sum2);
    }
    public static void permute(int idx) {
        if(idx == sub.length) {
            getMax();
            return;
        }
        for(int i = 0; i < map.length; i++) {
            if(!visited[i]) {
                sub[idx] = map[i];
                visited[i] = true;
                permute(idx+1);
                visited[i] = false;
            }
        }
    }
}
