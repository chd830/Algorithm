/*
package com.swexpertacademy;

import java.util.Scanner;

public class 벌꿀채취Solution {
    static int N;
    static int M;
    static int C;
    static int[][] map;
    static int[][] maxMap;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t <= T; t++) {
            N = sc.nextInt();
            M = sc.nextInt();
            C = sc.nextInt();
            map = new int[N][N];
            maxMap = new int[N][N];
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            System.out.println("#"+t+" ");
        }
    }
    static void makeMaxMap() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N-M; j++) {

            }
        }
    }
    */
/*
    i: 행위치
    j: 열위치
    cnt: 부분집합을 고려하는 원소 수
    sum: 부분집합에 속한 원소들의 합
    powSum: 부분집합에 속한 원소의 이익
     *//*

    static void makeMaxSubset(int i, int j, int cnt, int sum, int powSum) {
        //부분집합의 합이 목표량을 초과하면 끝낸다.
        if(sum > C) {
            return;
        }
        if(cnt == M) {
            if(maxMap[i][j-M] < powSum) {
                maxMap[i][j-M] = 0;
            }
        }
        //i, j위치 원소 선택
        makeMaxSubset(i, j+1, cnt+1, sum+map[i][j], powSum+map[i][j]*map[i][j]);
        //i, j위치 비선택
        makeMaxSubset(i, j+1, cnt+1, sum, powSum);
    }
    static int getMaxBenefit() {
        int max = 0;
        int temp = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j <= N-M; j++) {
                for(int k = j + M; k <= N-M; k++) {
                    temp = maxMap[i][j] + maxMap[i][k];
                }

            }
        }
        return max;
    }
}
*/
