package com.swexpertacademy;

import java.util.Scanner;

//동철이의 프로그래밍 대회
public class d3_6958 {
//    public static void main(String[] args){
    public d3_6958() {
       Scanner sc = new Scanner(System.in);
       int T = sc.nextInt();
       for(int t = 1; t <= T; t++) {
           int N = sc.nextInt();
           int M = sc.nextInt();
           int[][] problem = new int[N][M];
           int[][] solved = new int[1][2];
           for(int i = 0; i < N; i++) {
               int sum = 0;
               for(int j = 0; j < M; j++) {
                   problem[i][j] = sc.nextInt();
                   if(problem[i][j] == 1) {
                       sum ++;
                   }
               }
               if(solved[0][1] < sum) {
                   solved[0][1] = sum;
                   solved[0][0] = 1;
               }
               else if(solved[0][1] == sum) {
                   solved[0][0]++;
               }
           }
           System.out.println("#"+t+" "+solved[0][0]+" "+solved[0][1]);
       }
    }
}
