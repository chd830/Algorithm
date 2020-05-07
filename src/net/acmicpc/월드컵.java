package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
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
            System.out.print(check(team)+" ");
        }
    }
    static public int check(int[][] team) {
        int win = 0;
        int lose = 0;
        HashMap<Integer, Integer> draw = new HashMap();
        for(int i = 0; i < 6; i++) {
            win = team[i][0];
            lose = team[i][1];
            if(draw.containsKey(team[i][1])) {
                draw.put(team[i][1], draw.get(team[i][1])+1);
            }
            else {
                draw.put(team[i][1], 1);
            }
        }
        for(int key : draw.keySet()) {
            if(draw.get(key)%2 != 0) {
                return 0;
            }
        }
        if(win != lose) {
            return 0;
        }
        return 1;
    }
}
