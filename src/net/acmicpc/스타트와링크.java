package net.acmicpc;

import java.util.Arrays;
import java.util.Scanner;

public class 스타트와링크 {
    static int[][] team;
    static int[] teamInfo;
    static int[] start;
    static int[] link;
    static int max;
    static int min;
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        team = new int[N][N];
        teamInfo = new int[N];
        start = new int[N/2];
        link = new int[N/2];
        for(int i = 0; i< N; i++) {
            teamInfo[i] = (i+1);
        }
        for(int i = 0 ;i < N; i++) {
            for(int j = 0; j < N; j++) {
                team[i][j] = sc.nextInt();
            }
        }
        divideTeam(0);
    }
    public static void divideTeam(int idx) {
        if(idx == N/2) {
            for(int i = 0, j= 0; i < N; i++) {
                if(teamInfo[i]  > 0) {
                    link[j] = teamInfo[i];
                    j++;
                }
            }
            System.out.println(Arrays.toString(start)+" "+Arrays.toString(link));
            
            return;
        }
        for(int i = 0; i < N; i++) {
            if(teamInfo[i] > 0) {
                start[idx] = teamInfo[i];
                teamInfo[i] = -1;
                divideTeam(idx+1);
                teamInfo[i] = (i+1);
            }
        }
    }
}