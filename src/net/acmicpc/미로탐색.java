package net.acmicpc;

import java.util.Scanner;

public class 미로탐색 {
    static int N;
    static int M;
    static int min;
    static char[][] map;
    static boolean[][] visited;
    //    public static void main(String[] args) {
    public 미로탐색() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        min = Integer.MAX_VALUE;
        System.out.println("min: "+min);
        map = new char[N+1][M+1];
        visited = new boolean[N+1][M+1];
        for(int i = 1; i <= N; i++) {
            String str = sc.next();
            for(int j = 0; j < str.length(); j++) {
                map[i][j+1] = str.charAt(j);
            }
        }
        dfs(1, 1, 0);
        System.out.println(min);
    }
    public static void dfs(int x, int y, int value) {
        if(x == N && y == M) {
            if(min > (value + 1)) {
                min = value + 1;
            }
            return;
        }
        visited[x][y] = true;
        if(x > 1 && map[x-1][y] == '1' && !visited[x-1][y]) {
            dfs(x-1, y, value+1);
        }
        if(x < N && map[x+1][y] == '1' && !visited[x+1][y]) {
            dfs(x+1, y, value+1);
        }
        if(y > 1 && map[x][y-1] == '1' && !visited[x][y-1]) {
            dfs(x, y-1, value+1);
        }
        if(y < N && map[x][y+1] == '1' && !visited[x][y+1]) {
            dfs(x, y+1, value+1);
        }
    }
}
