package com.swexpertacademy;

import java.util.*;

public class 요리사 {
    static int N;
    static int[] nums;
    static boolean[] visited;
    static int[][] map;
    static List<Integer> list;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t <= T; t++) {
            N = sc.nextInt();
            map = new int[N][N];
            nums = new int[N];
            visited = new boolean[N];
            list = new ArrayList();
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    map[i][j] = sc.nextInt();
                }
            }
            //N/2의 수를 뽑아서...시너지의 수를 구한다...
            for(int i = 0; i < N; i++) {
                nums[i] = (i+1);
            }
            permute(0, 0);
//            System.out.println("#"+t+" ");
        }
    }

    public static void permute(int idx, int s_idx) {
        if(idx == nums.length) {
            return;
        }
        if(s_idx == N/2) {
            int sum = 0;
            /*
            1, 2
            2, 1

            1, 2 >> 2, 1
            2, 3 >> 3, 2
            3, 1 >> 1, 3
             */
            int sum1 = 0;
            int sum2 = 0;
            for(int i = 0; i < N; i++) {
                for(int j = i+1; j < N; j++) {

                }
            }
            return;
        }
        for(int i = idx; i < N; i++) {
            visited[i] = true;
            permute(idx+1, i+1);
            visited[i] = false;
        }
    }
}
