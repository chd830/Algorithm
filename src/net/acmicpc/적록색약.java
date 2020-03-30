package net.acmicpc;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 적록색약 {
    static int size;
    static int cnt1;
    static int cnt2;
    static int[][] map;
    static boolean[][] visited1;
    static boolean[][] visited2;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        cnt1 = 0;
        cnt2 = 0;
        size = sc.nextInt();
        map = new int[size][size];
        for(int i = 0; i < size; i++) {
            String color = sc.next();
            for(int j = 0 ;j < size; j++) {
                switch (color.charAt(j)) {
                    case 'R':
                        map[i][j] = 1;
                        break;
                    case 'G':
                        map[i][j] = 0;
                        break;
                    case 'B':
                        map[i][j] = 2;
                        break;
                }
            }
        }
        visited1 = new boolean[size][size];
        visited2 = new boolean[size][size];
        for(int i = 0 ;i < size; i++) {
            for(int j = 0; j < size; j++) {
                if(!visited1[i][j]) {
                    cnt1++;
                    group(i, j);
                }
                if(!visited2[i][j]) {
                    cnt2++;
                    colorWeakness(i, j);
                }
            }
        }
        System.out.println(cnt1+" "+cnt2);
    }
    static void colorWeakness(int x, int y) {
        int num = map[x][y];
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(x, y));
        visited2[x][y] = true;
        while(!que.isEmpty()) {
            Node n = que.poll();
            for(int i = 0; i < 4; i++) {
                int dx = n.x + dir[i][0];
                int dy = n.y + dir[i][1];
                if(isIn(dx, dy) && !visited2[dx][dy]) {
                    if(num == 2 && map[dx][dy] == 2) {
                        que.add(new Node(dx, dy));
                        visited2[dx][dy] = true;
                    }
                    else if(num < 2 && map[dx][dy] < 2){
                        que.add(new Node(dx, dy));
                        visited2[dx][dy] = true;
                    }
                }
            }
        }
    }

    static void group(int x, int y) {
        int num = map[x][y];
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(x, y));
        visited1[x][y] = true;
        while(!que.isEmpty()) {
            Node n = que.poll();
            for(int i = 0; i < 4; i++) {
                int dx = n.x + dir[i][0];
                int dy = n.y + dir[i][1];
                if(isIn(dx, dy) && map[dx][dy] == num && !visited1[dx][dy]) {
                    que.add(new Node(dx, dy));
                    visited1[dx][dy] = true;
                }
            }
        }
    }
    static boolean isIn(int dx, int dy) {
        return dx >= 0 && dy >= 0 && dx < size && dy < size;
    }
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
