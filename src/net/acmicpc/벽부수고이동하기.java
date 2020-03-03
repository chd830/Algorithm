package net.acmicpc;

import java.util.Arrays;
import java.util.Scanner;

/*
이 케이스에서 18이 답이 나와야 함.
6 5
00000
11110
00000
01111
01111
00010
 */
public class 벽부수고이동하기 {
    static int N;
    static int M;
    static Node[][] map;
    static boolean cracking;
    static int[][] cnt;
    static int[][] move = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static class Node {
        int x;
        int y;
        char c;
        Node(int x, int y, char c) {
            this.x = x;
            this.y = y;
            this.c = c;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        cracking = false;
        map = new Node[N][M];
        cnt = new int[N][M];
        for(int i = 0; i < N; i++) {
            String str = sc.next();
            for(int j = 0; j < M; j++) {
                map[i][j] = new Node(i, j, str.charAt(j) == '1' ? '-' : 0);
            }
        }
        cnt[0][0] = 1;
        dfs(0, 0);
        print();
        System.out.println(cnt[N-1][M-1]);
    }
    public static void print() {
        for(int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(cnt[i]));
        }
        System.out.println();
    }
    public static void dfs(int x, int y) {
        //기저상태
        if(x == N && y == M) {
            return;
        }
        //움직이는 경로
        for(int i = 0; i < 4; i++) {
            int dx = x + move[i][0];
            int dy = y + move[i][1];
            if(dx >= 0 && dy >= 0 && dx < N && dy < M && cnt[dx][dy] == 0) {
                if(map[dx][dy].c == '-' && !cracking) {
                    cracking = true;
                }
                else if(map[dx][dy].c == '-' && cracking) {
                    continue;
                }
                cnt[dx][dy] = cnt[x][y]+1;
//                cnt[dx][dy] = cnt[dx][dy] != 0 ? Math.min(cnt[dx][dy],cnt[x][y] + 1) : cnt[x][y] + 1;
                print();
                dfs(dx, dy);
                cracking = false;
            }
        }
    }

}
