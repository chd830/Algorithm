package com.swexpertacademy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 벽돌깨기re {
    static int N;
    static int W;
    static int H;
    static int brickCnt;
    static int[][] map;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();

        for(int t = 1; t <= T; t++) {
            sb.append("#"+t+" ");
            N = sc.nextInt();
            H = sc.nextInt();
            W = sc.nextInt();
            map = new int[W][H];
            brickCnt = 0;
            for(int i = 0; i < W; i++) {
                for(int j = 0; j < H; j++) {
                    map[i][j] = sc.nextInt();
                    if(map[i][j] != 0) {
                        brickCnt++;
                    }
                }
            }
            dropMarble(N, map, brickCnt);
        }
        System.out.println(sb);
    }
    static int answer;
    public static void dropMarble(int r, int[][] map, int brickCnt) {
        //기저조건
        if(r == 0) {
            return;
        }
        //subArray를 만들어서 가져오는 코드
        //돌을 떨어뜨려서 벽돌 깨기(깨지는 벽돌 수 가져오기
        for(int i = 0; i < H; i++) {
            int[][] clone = clonedMap(map);
            int cnt = crush(clone, i);
            //돌을 떨어뜨렸을 때 벽돌의 수가 없다면 끝내기
            if(brickCnt >= cnt) {
                answer = 0;
                return;
            }
            //벽돌 정리하기
            cleanedMap(clone);
            //다음 돌 떨어뜨리기
            dropMarble(r-1, map, brickCnt-cnt);
        }
    }

    static void cleanedMap(int[][] map) {

    }

    static class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int crush(int[][] map, int x) {
        for(int i = 0; i < 4; i++) {
            int dx = dir[i][0];
            int dy = dir[i][1];
            if(isIn(dx, dy) && map[dx][dy] != 0) {

            }
        }
    }

    static boolean isIn(int x, int y) {
        return x >= 0 && y >= 0 && x < W && y < H;
    }

    static int[][] clonedMap(int[][] map) {
        int[][] temp = new int[map.length][map[0].length];
        for(int i = 0; i < map.length; i++) {
            temp[i] = map[i].clone();
        }
        return temp;
    }
}
