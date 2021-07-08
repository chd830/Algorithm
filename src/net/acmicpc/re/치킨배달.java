package net.acmicpc.re;

import java.util.*;
import java.io.*;

// 15686
public class 치킨배달 {
    static class Pos {
        int x;
        int y;
        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int N;
    static int M;
    static int result;
    static int[] sub;
    static int[][] arr;
    static boolean[] visited;
    static List<Pos> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        result = Integer.MAX_VALUE;
        arr = new int[N][N];
        list = new ArrayList<>();
        sub = new int[M];
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(token.nextToken());
                if(arr[i][j] == 2)
                    list.add(new Pos(i, j));
            }
        }
        visited = new boolean[list.size()];
        if(M == list.size()) {
            for(int i = 0; i < sub.length; i++)
                sub[i] = i;
            findRoute();
        }
        else {
            comb(0, 0);
        }
        System.out.println(result);
    }
    static void findRoute() {
//        for(int i = 0; i < sub.length; i++) {
//            System.out.print(list.get(sub[i]).x+", "+list.get(sub[i]).y+"\t");
//        }
        int count = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(arr[i][j] == 1) {
                    min = Integer.MAX_VALUE;
                    for(int k = 0; k < sub.length; k++) {
                        min = Math.min(Math.abs(i-list.get(sub[k]).x)+ Math.abs(j-list.get(sub[k]).y), min);
                    }
                    count += min;
                }
            }
        }
//        System.out.println(count);
        result = Math.min(result, count);
    }
    static void comb(int idx, int subIdx) {
        if(subIdx == sub.length) {
            findRoute();
            return;
        }
        for(int i = idx; i < visited.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                sub[subIdx] = i;
                comb(i+1, subIdx+1);
                visited[i] = false;
            }
        }
    }
}
