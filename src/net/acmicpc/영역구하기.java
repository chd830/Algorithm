package net.acmicpc;

import java.util.*;

public class 영역구하기 {
    static int N;
    static int M;
    static int cnt;
    static int area;
    static int[][] map;
    static boolean[][] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList();
        N = sc.nextInt();
        M = sc.nextInt();
        int K = sc.nextInt();
        map = new int[M][N];
        visited = new boolean[M][N];
        for(int i = 0; i < K; i++) {
            paint(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
        }

        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] == 0 && !visited[i][j]) {
                    area = 0;
                    cnt++;
                    checkArea(i, j);
                    list.add(area);
                }
            }
        }
        System.out.println(cnt);
        Collections.sort(list);
        for(int i : list) {
            System.out.print(i+" ");
        }
    }
    static void checkArea(int x, int y) {
        visited[x][y] = true;
        area++;
        if(x+1 < M && !visited[x+1][y] && map[x+1][y] == 0) {
            checkArea(x+1, y);
        }
        if(x >= 1 && !visited[x-1][y] && map[x-1][y] == 0) {
            checkArea(x-1, y);
        }
        if(y+1 < N && !visited[x][y+1] && map[x][y+1] == 0) {
            checkArea(x, y+1);
        }
        if(y >= 1 && !visited[x][y-1] && map[x][y-1] == 0) {
            checkArea(x, y-1);
        }
    }
    static void paint(int startX, int startY, int endX, int endY) {
        int n = Math.abs(startX - endX);
        int m = Math.abs(startY - endY);
        for(int i = startX; i < startX+n; i++) {
            for(int j = startY; j < startY+m; j++) {
                map[i][j] = 1;
            }
        }
    }
}
