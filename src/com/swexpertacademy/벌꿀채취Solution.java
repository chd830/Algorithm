package com.swexpertacademy;

import java.util.Scanner;

public class 벌꿀채취Solution {
    static int N,M,C;
    static int[][] honey;
    static int[][] cal;
    static int answer;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T=sc.nextInt();
        for(int test_case =1; test_case<=T; test_case++) {
            N=sc.nextInt();
            M=sc.nextInt();
            C=sc.nextInt();
            honey= new int[N][N];
            cal= new int[N][N-M+1];
            answer=0;
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    honey[i][j]=sc.nextInt();
                }
            }
            int maxValue=0,maxR=-1,maxC=-1;
            for(int i=0;i<N;i++) {
                for(int j=0;j<N-M+1;j++) {
                    cal[i][j]=calMax(i,j,0,0,0);

                }
            }


            choice(0,0,0,0);


            System.out.println("#"+test_case+" "+answer);
        }
    }

    public static void choice(int r, int c , int value,int count) {
        if(count==2) {
            answer=Math.max(answer, value);
            return;
        }
        if(c>=cal[0].length) {
            c=0;
            r++;
        }
        if(r>=cal.length){
            return;
        }
        choice(r,c+1,value,count);
        choice(r,c+M,value+cal[r][c],count+1);


    }

    public static int calMax(int r, int c,int curSum, int curRet,int pos) {
        if(pos>M||curSum>C) {
            return -1;
        }
        if(pos==M||curSum==C) {
            return curRet;
        }


        return Math.max(calMax(r,c+1,curSum,curRet,pos+1), calMax(r,c+1,curSum+honey[r][c],curRet+(honey[r][c]*honey[r][c]),pos+1));
    }

}