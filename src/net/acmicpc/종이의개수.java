package net.acmicpc;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1780
public class 종이의개수 {
    static int N;
    static int[] answer = new int[3];
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for(int i = 0; i < N; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(token.nextToken());
            }
        }
        recur(0, 0, N);
        System.out.println(answer[0]);
        System.out.println(answer[1]);
        System.out.println(answer[2]);
    }
    static boolean check(int x, int y, int size) {
        int target = arr[x][y];
        for(int i = x; i < x+size; i++) {
            for(int j = y; j < y+size; j++) {
                if(arr[i][j] != target)
                    return false;
            }
        }
        return true;
    }
    static void recur(int x, int y, int size) {
        if(check(x, y, size)) {
            answer[arr[x][y]+1]++;
            return;
        }
        int next = size/3;
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                recur(x+j*next, y+i*next, next);
            }
        }
    }
}
