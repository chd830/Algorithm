package review;

import java.util.*;
import java.io.*;

public class 뿌요뿌요 {
    static int R = 12;
    static int C = 6;
    static int res;
    static char[][] map = new char[R][C];
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < R; i++) {
            String str = br.readLine();
            for(int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        res = 0;
        puyo(0, 0);
        System.out.println(res);
    }
    static class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static void puyo(int i, int j) {
        boolean[][] visited = new boolean[R][C];
        if(map[i][j] != '.') {
            int cnt = 1;
            int x = i;
            int y = j;
            Queue<Node> que = new LinkedList<>();
            que.add(new Node(i, j));
            visited[i][j] = true;
            char key = map[i][j];
            while(!que.isEmpty()) {
                Node n = que.poll();
                for(int d = 0; d < 4; d++) {
                    int dx = n.x + dir[d][0];
                    int dy = n.y + dir[d][1];
                    if(isIn(dx, dy) && map[dx][dy] == key && !visited[dx][dy]) {
                        cnt++;
                        visited[dx][dy] = true;
                        que.add(new Node(dx, dy));
                    }
                }
            }
            if(cnt >= 4) {
                remove(i, j);
                rearrange();
                puyo(i, j);
            }
            else {
                if(j+1 < C) {
                    puyo(i, j+1);
                }
                else if(i+1 < R) {
                    puyo(i+1, 0);
                }
                else {
                    res++;
                    print();
                    puyo(0, 0);
                }
            }
        }
        else {
            if(j+1 < C) {
                puyo(i, j+1);
            }
            else if(i+1 < R) {
                puyo(i+1, 0);
            }
            else {
                res++;
                print();
                puyo(0, 0);
            }
        }
    }
    static void print() {
        for(int i = 0; i < R; i++) {
            System.out.println(Arrays.toString(map[i]));
        }
        System.out.println();
    }
    static boolean isIn(int dx, int dy) {
        return dx >= 0 && dy >= 0 && dx < R && dy < C;
    }
    static void remove(int x, int y) {
        char key = map[x][y];
        boolean[][] visited = new boolean[R][C];
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(x, y));
        visited[x][y] = true;
        map[x][y] = '.';
        while(!que.isEmpty()) {
            Node n = que.poll();
            for(int d = 0; d < 4; d++) {
                int dx = n.x + dir[d][0];
                int dy = n.y + dir[d][1];
                if(isIn(dx, dy) && map[dx][dy] == key && !visited[dx][dy]) {
                    visited[dx][dy] = true;
                    map[dx][dy] = '.';
                    que.add(new Node(dx, dy));
                }
            }
        }
    }
    static int isBottomDot(int y, int x){
        int tempY = -1;
        for (int i = y; i < R; i++) {
            if (map[i][x] == '.') {
                tempY = i;
            }
        }
        return tempY;
    }
    static void rearrange() {
        int tempY = 0;
        for (int i = R - 2; i >= 0; i--) {
            for (int j = 0; j < C; j++) {
                tempY = -1;
                if (map[i][j] != '.') {
                    tempY = isBottomDot(i, j);
                }
                if (tempY != -1) {
                    map[tempY][j] = map[i][j]; // 가장 마지막 . 이 나온 곳으로 옮기고,
                    map[i][j] = '.'; // 그 자리에 . 을 대입한다.
                }
            }
        }
    }
}
