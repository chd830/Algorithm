package net.acmicpc;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 달이차오른다가자 {
    static char[][] map;
    static int[][] visited;
    static int[][] pos = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int[] alph;
    static int startx;
    static int starty;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        map = new char[N][M];
        visited = new int[N][M];
        alph = new int[26];
        startx = 0;
        starty = 0;
        for(int i = 0; i < N; i++) {
            String str = sc.next();
            for(int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
                if(map[i][j] == 0) {
                    startx = i;
                    starty = j;
                }
            }
        }
        /*
        .: 빈곳
        #: 벽
        열쇠(a-f)
        문(A-F)
        0: 현재위치
        1: 출구
         */
        bfs();

//        System.out.println(visited[]);
    }
    static void print() {
        for(int i =0 ; i < visited.length; i++) {
            System.out.println(Arrays.toString(visited[i]));
        }
    }
    static class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void bfs() {
        Queue<Node> que = new LinkedList();
        que.add(new Node(startx, starty));
        visited[startx][starty] = 1;

        while(!que.isEmpty()) {
            Node n = que.poll();

//            loop: for(int i = 0; i < 4; i++) {
//                int dx = n.x +pos[i][0];
//                int dy = n.y + pos[i][1];
//                while(dx >= 0 && dx < map.length && dy >= 0 && dy < map[0].length && map[dx][dy] != '#') {
//                    if(map[dx][dy] == '1') {
//                        return;
//                    }
//                    //a-49 == 0
//                    if(map[dx][dy] >= 65 && map[dx][dy] <= 90) {
//                        if(alph[map[dx][dy] - 65] != 0) {
//                            alph[map[dx][dy] - 65]--;
//                            visited[dx][dy] = visited[n.x][n.y]+1;
//                            que.add(new Node(dx, dy));
//                        }
//                        else {
//                            continue loop;
//                        }
//                    }
//                    else if(map[dx][dy] >= 97 && map[dx][dy] <= 122) {
//                        alph[map[dx][dy] - 97]++;
//                        visited[dx][dy] = visited[n.x][n.y]+1;
//                        que.add(new Node(dx, dy));
//                    }
//                    else {
//                        System.out.println(visited[n.x][n.y]+" "+visited[dx][dy]);
//                        visited[dx][dy] = visited[n.x][n.y]+1;
//                        que.add(new Node(dx, dy));
//                    }
//                    print();
//                    dx += pos[i][0];
//                    dy += pos[i][1];
//                }
//            }
        }
    }
}
