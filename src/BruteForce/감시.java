package BruteForce;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/15683
public class 감시 {
    static int N;
    static int M;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        arr = new int[N][M];
        min = Integer.MAX_VALUE;
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(token.nextToken());
            }
        }
        find(0, 0);
        System.out.println(min);
    }
    static int min;
    static void count() {
        int count = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(arr[i][j] == 0)
                    count++;
            }
        }
        min = Math.min(min, count);
    }
    static void print() {
        for(int i = 0; i < N; i++)
            System.out.println(Arrays.toString(arr[i]));
    }
    static void find(int x, int y) {
        if(y == M) {
            find(x + 1, 0);
            return;
        }
        if(x == N) {
//            for(int i : list)
//                System.out.print(i+" ");
//            System.out.println();
            paintAll();
            count();
//            print();
//            System.out.println();
            removeArea();
            return;
        }
        if(arr[x][y] == 0 || arr[x][y] == -1 || arr[x][y] == 6) {
            find(x, y + 1);
            return;
        }
        camera(x, y);

    }
    static boolean isIn(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }
    static List<Integer> list = new ArrayList<>();
    static void paintAll() {
        int cnt = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(arr[i][j] >= 1 && arr[i][j] <= 5) {
                    // 방향
                    int num = list.get(cnt++);
                    for(int k = 0; k < camera[arr[i][j]-1][num].length; k++) {
                        for(int l = 1; l < Math.max(N, M); l++) {
                            int dx = i + dir[camera[arr[i][j] - 1][num][k]][0]*l;
                            int dy = j + dir[camera[arr[i][j]-1][num][k]][1]*l;
                            if(!isIn(dx, dy) || arr[dx][dy] == 6)
                                break;
                            if(arr[dx][dy] != 0)
                                continue;
                            arr[dx][dy] = -1;
                        }

                    }
                }
            }
        }
    }
    static void removeArea() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(arr[i][j] == -1)
                    arr[i][j] = 0;
            }
        }
    }
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int[][][] camera = {
            {{0}, {1}, {2}, {3}},
            {{0, 1}, {2, 3}},
            {{0, 2}, {0, 3}, {1, 2}, {1, 3}},
            {{0, 1, 2}, {0, 1, 3}, {1, 2, 3}, {0, 2, 3}},
            {{0, 1, 2, 3}}
    };
    static void camera(int x, int y) {
        for(int d = 0; d < camera[arr[x][y]-1].length; d++) {
            list.add(d);
            find(x, y+1);
            list.remove(list.size()-1);
        }
    }
}
