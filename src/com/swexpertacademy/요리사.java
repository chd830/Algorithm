package com.swexpertacademy;

import java.util.*;

public class 요리사 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int[][] map = new int[N][N];
            List<Integer> list = new ArrayList();
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    map[i][j] = sc.nextInt();
                }
            }
            for(int i = 0; i < N; i++) {
                for(int j = i+1; j < N; j++) {
                    if(i != j) {
                        list.add(map[i][j]+map[j][i]);
                    }
                }
            }
            Collections.sort(list);
            System.out.println("#"+t+" ");
        }
    }
}
