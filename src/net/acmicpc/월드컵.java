package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 월드컵 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] team = new int[6][3];
        for(int k = 0; k < 4; k++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            for(int i = 0; i < 6; i++) {
                for(int j = 0; j < 3; j++) {
                    team[i][j] = Integer.parseInt(token.nextToken());
                }
            }
        }
    }
//    static void dfs(int teamA, int teamB, int[] score) {
//        if(teamB == 6) {
//            dfs(teamA+1, teamA+2, score);
//            return;
//        }
//        if(teamA > 4) {
//            for(int c = 0; c < score.length; c++) {
//                if(score[c] > 0) {
//                    valid = 0;
//                    return;
//                }
//            }
//            valid = 1;
//            return;
//        }
//        if(score[teamA*3 + 0] > 0 && score[teamB*3 + 2] > 0) {
//            score[teamA*3 + 0]--;
//            score[teamB*3 + 2]--;
//            dfs(teamA, teamB+1, score);
//        }
//    }
}
