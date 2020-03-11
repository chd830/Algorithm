package com.swexpertacademy;

import java.util.*;

public class 하나로 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            List<int[]> list = new ArrayList();
            int[][] map = new int[N][2];
            for(int j = 0; j < 2; j++) {
                for(int i = 0; i < N; i++) {
                    map[i][j] = sc.nextInt();
                }
            }
            for(int i = 0; i < N; i++) {
                list.add(map[i]);
            }
            for(int[] l : list) {
                System.out.println(l[0] +" "+l[1]);
            }
//            System.out.println("#"+t+" ");
        }
    }
}
