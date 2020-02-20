package com.swexpertacademy;

import java.util.Scanner;

public class 최적경로 {
    static boolean[] visited;
    static int[][] map;
    static int[][] copy;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t <= T; t++) {
            int num = sc.nextInt();
            map = new int[num][2];
            copy = new int[num+2][2];
            copy[0][0] = sc.nextInt();
            copy[0][1] = sc.nextInt();
            copy[num+1][0] = sc.nextInt();
            copy[num+1][1] = sc.nextInt();
            visited = new boolean[num];
            for(int i = 0; i < num; i++) {
                map[i][0] = sc.nextInt();
                map[i][1] = sc.nextInt();
            }
            min = Integer.MAX_VALUE;
            recur(0, 0, 0, 0);
            System.out.println("#"+t+" "+min);
        }
    }
    static int min;
    static int sum;
    public static void recur(int idx, int x, int y, int sum) {
        if(idx == map.length) {
//            sum = 0;
//            for(int i = 1; i < copy.length; i++) {
//                sum += Math.abs(copy[i][0] - copy[i-1][0]) + Math.abs(copy[i][1] - copy[i-1][1]);
//                if(min < sum) {
//                    return;
//                }
//            }
            if(min < sum)
                return;
            System.out.print(x+" "+y+".\t\t");
            sum = (Math.abs(x - copy[copy.length-1][0])) + Math.abs(y - copy[copy.length-1][1]);
            System.out.println("sum: "+sum);
            min = sum;
            return;
        }
        for(int i = 0; i < map.length; i++) {
            if(!visited[i]) {
//                copy[idx] = map[i];
                visited[i] = true;
                System.out.print(x+" "+y+".\t");
                recur(idx + 1, map[idx][0], map[idx][1], x+Math.abs(x - map[idx][0]) + y+Math.abs(y - map[idx][1]));
                visited[i] = false;
            }
        }
    }
}