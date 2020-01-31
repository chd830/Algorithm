package com.swexpertacademy;

import java.util.Arrays;
import java.util.Scanner;

//재미있는 오셀로 게임
public class d3_4615 {
    static String[][] arr;
//    public static void main(String[] args) {
    public d3_4615() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            arr = new String[N+1][N+1];
            int M = sc.nextInt();
            for(int i = 0; i < M; i++) {
                int r = sc.nextInt();
                int c = sc.nextInt();
                int color = sc.nextInt();
                game(r, c, color);
//                arr[r][c] = color == 1 ? "B" : "W";
            }
        }
        for(int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }
    int[][] pos = {{0,-1},{-1,-1},{-1,0},{-1, 1},{0,1},{1,1},{1,0},{-1,1}};
    static public void game(int r, int c, int color) {
        if(color == 1) { //흑돌
            for(int i = 0 ;i < 8; i++) {

            }
        }
        if(color == 2) { //백돌

        }
    }
}
