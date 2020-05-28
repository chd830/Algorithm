package com.swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 범준이의제주도여행계획 {
    static int N;
    static int M;
    static int[][] graph;
    static Point airport;
    static List<Point> hotels;
    static List<Point> tourSpots;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer token;
        for(int t = 1; t <= T; t++) {
            token = new StringTokenizer(br.readLine());
            N = Integer.parseInt(token.nextToken());
            M = Integer.parseInt(token.nextToken());
            graph = new int[N+1][N+1];

            for(int i = 1; i < N; i++) {
                token = new StringTokenizer(br.readLine());
                for(int j = i+1; j <= N; j++) {
                    graph[j][i] = graph[i][j] = Integer.parseInt(token.nextToken());
                }
            }
            for(int k = 0; k < N; k++) {
                System.out.println(Arrays.toString(graph[k]));
            }
            System.out.println();
            //지점정보 가져오기
            tourSpots = new ArrayList<>();
            hotels = new ArrayList<>();
            for(int n = 1; n <= N; n++) {
                token = new StringTokenizer(br.readLine());
                String type = token.nextToken();
                switch (type) {
                    case "H":
                        hotels.add(new Point(type, n));
                        break;
                    case "A":
                        airport = new Point(type, n);
                        break;
                    case "P":
                        int playTime = Integer.parseInt(token.nextToken());
                        int satis = Integer.parseInt(token.nextToken());
                        tourSpots.add(new Point(type, n, playTime, satis));
                }
                //관광지에 가장 가까운 호텔정보 설정

            }
        }
    }
    static class Point {
        String type;
        int idx;
        int playTime;
        int satis;
        Point nearH;
        Point(String type, int idx) {
            this(type, idx, 0, 0);
        }
        Point(String type, int idx, int playTime, int satis) {
            this.type = type;
            this.idx = idx;
            this.playTime = playTime;
            this.satis = satis;
        }
    }
}
