package 구현;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/17144
public class 미세먼지안녕 {
    static class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int R;
    static int C;
    static int[][][] arr;
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        R = Integer.parseInt(token.nextToken());
        C = Integer.parseInt(token.nextToken());
        int T = Integer.parseInt(token.nextToken());
        arr = new int[R][C][2];

        for(int i = 0; i < R; i++) {
            token = new StringTokenizer(br.readLine());
            for(int j = 0; j < C; j++) {
                arr[i][j][0] = Integer.parseInt(token.nextToken());
            }
        }
        while(T-- > 0) {
            checkDust();
            dust();
            add();
//            print();
//            System.out.println("CIRCULATION");
            air();
//            print();
        }
        System.out.println(cnt());
    }
    static void checkDust() {
        visited = new boolean[R][C];
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(arr[i][j][0] != 0)
                    visited[i][j] = true;
            }
        }
    }

    static boolean isIn(int x, int y) {
        return x >= 0 && y >= 0 && x < R && y < C;
    }
    static void add() {
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                arr[i][j][0] += arr[i][j][1];
                arr[i][j][1] = 0;
            }
        }
    }
    static int countArea(int x, int y) {
        int cnt = 0;
        for(int d = 0; d < 4; d++) {
            int dx = x + dir[d][0];
            int dy = y + dir[d][1];
            if(isIn(dx, dy) && arr[dx][dy][0] >= 0)
                cnt++;
        }
        return cnt;
    }
    static void setDust(int x, int y) {
        for(int d = 0; d < 4; d++) {
            int dx = x + dir[d][0];
            int dy = y + dir[d][1];
            if(isIn(dx, dy) && arr[dx][dy][0] >= 0) {
                arr[dx][dy][1] += arr[x][y][0]/5;
            }
        }
    }
    static boolean[][] visited;
    static void dust() {
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(visited[i][j]) {
                    int cnt = countArea(i, j);
                    setDust(i, j);
                    int tmp = arr[i][j][0];
                    arr[i][j][0] = tmp-(tmp/5)*cnt;
                }
            }
        }
    }
    static void airCirculate(int x, boolean up) {
        int tmp = -1;
        // 지금 값이 있을 때
        // 1. 현재 값에는 이전의 값을 가져온다.(-1일 때는 0)
        // 2. 현재 값을 다음에 올 값으로 지정한다.
        // 다음에 올 값(tmp)이 잇을 때
        // 1. 이 다음에 넣을 값(temp)은 현재 값이다.
        // 2. 현재 값에는 다음에 올 값을 넣는다.
        for(int i = 1; i < C; i++) {
            if(tmp > 0) {
                int temp = arr[x][i][0];
                arr[x][i][0] = tmp;
                tmp = temp;
                continue;
            }
            int temp = arr[x][i][0];
            arr[x][i][0] = tmp == -1 ? 0 : tmp;
            tmp = temp;
        }
        // up
        if(up) {
            for (int i = x-1; i >= 0; i--) {
                if(tmp > 0) {
                    int temp = arr[i][C-1][0];
                    arr[i][C-1][0] = tmp;
                    tmp = temp;
                    continue;
                }
                int temp = arr[i][C-1][0];
                arr[i][C-1][0] = tmp;
                tmp = temp;
            }
        }
        // down
        else {
            for(int i = x+1; i < R; i++) {
                if(tmp > 0) {
                    int temp = arr[i][C-1][0];
                    arr[i][C-1][0] = tmp;
                    tmp = temp;
                    continue;
                }
                int temp = arr[i][C-1][0];
                arr[i][C-1][0] = tmp;
                tmp = temp;
            }
        }
        int idx = up ? 0 : R-1;
        for(int i = C-2; i >= 0; i--) {
            if(tmp > 0) {
                int temp = arr[idx][i][0];
                arr[idx][i][0] = tmp;
                tmp = temp;
                continue;
            }
            int temp = arr[idx][i][0];
            arr[idx][i][0] = tmp;
            tmp = temp;
        }
        // up
        if(up) {
            for(int i = 1; i < x; i++) {
                if(tmp > 0) {
                    int temp = arr[i][0][0];
                    arr[i][0][0] = tmp;
                    tmp = temp;
                    continue;
                }
                int temp = arr[i][0][0];
                arr[i][0][0] = tmp;
                tmp = temp;
            }
        }
        // down
        else {
            for (int i = R-2; i > x; i--) {
                if(tmp > 0) {
                    int temp = arr[i][0][0];
                    arr[i][0][0] = tmp;
                    tmp = temp;
                    continue;
                }
                int temp = arr[i][0][0];
                arr[i][0][0] = tmp;
                tmp = temp;
            }
        }
    }
    static void air() {
        for(int i = 0; i < R; i++) {
            if(arr[i][0][0] == -1) {
                airCirculate(i, true);
                airCirculate(i+1, false);
                break;
            }
        }
    }
    static void print() {
        for(int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++)
                System.out.print(arr[i][j][0] + " ");
            System.out.println();
        }
        System.out.println();
    }
    static int cnt() {
        int count = 0;
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(arr[i][j][0] > 0)
                    count += arr[i][j][0];
            }
        }
        return count;
    }
}
