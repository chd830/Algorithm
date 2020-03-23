package net.acmicpc;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 직사각형탈출 {
    static int N;
    static int M;
    static int H;
    static int W;
    static Node end;
    static int[][] square;
    static boolean[][] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        square = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= M; j++) {
                square[i][j] = sc.nextInt();
            }
        }
        H = sc.nextInt();
        W = sc.nextInt();
        Node start = new Node(sc.nextInt(), sc.nextInt(), 0);
        end = new Node(sc.nextInt(), sc.nextInt(), 0);
        bfs(start.x, start.y);
        System.out.println(end.cnt == 0 ? -1 : end.cnt);
    }
    static class Node {
        int x;
        int y;
        int cnt;
        Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static void bfs(int x, int y) {
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(x, y, 0));
        visited[x][y] = true;
        while(!que.isEmpty()) {
            Node n = que.poll();
            if(n.x == end.x && n.y == end.y) {
                end.cnt = n.cnt;
                return;
            }
            for(int i = 0; i < 4; i++) {
                int dx = n.x + dir[i][0];
                int dy = n.y + dir[i][1];
                //하나씩 가는게 아니라 한 방향으로 쭉 갈 수 있는걸로 진행해야함.
                if(!isIn(dx, dy)) {
                    continue;
                }
                //dx, dy가 아닌n.x, n.y로 해서 이동할 수 있는지를 확인한다.
                if(movable(n.x, n.y, i)) {
                    //i방향으로 이동했을 때 방문한 위치인지 확인
                    if(visited[dx][dy]) {
                        continue;
                    }
                    visited[dx][dy] = true;
                    que.add(new Node(dx, dy, n.cnt+1));
                }
            }
        }
    }
    static boolean movable(int r, int c, int dir) {
        //위로
        if( dir == 0 ) {
            if( r - 1 > 0 ) {
                for(int i = 0; i < W; i++) {
                    if( square[r - 1][ c + i ] == 1 )
                        return false;
                }
            }
            else
                return false;
        }
        else if( dir == 1 ) {
            if( r + H <= N ) {
                for(int i = 0; i < W; i++) {
                    if( square[r + H][ c + i] == 1 )
                        return false;
                }
            }
            else
                return false;
        }
        else if( dir == 2 ) {
            if( c - 1 > 0 ) {
                for(int i = 0; i < H; i++) {
                    if( square[ r + i ][ c - 1 ] == 1 )
                        return false;
                }
            }
            else
                return false;
        }
        else if( dir == 3 ) {
            if( c + W <= M ) {
                for(int i = 0; i < H; i++) {
                    if( square[ r + i ][ c + W ] == 1 )
                        return false;
                }
            }
            else
                return false;
        }
        return true;
    }
    static boolean isIn(int x, int y) {
        return x >= 0 && y >= 0 && x <= N && y <= M;
    }
}
