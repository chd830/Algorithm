package net.acmicpc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//브루트포스
public class 치킨배달 {
    static int N;
    static int M;
    static int[][] map;
    static List<Node> list;
    static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][N];
        list = new ArrayList();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
                if(map[i][j] == 2) {
                    list.add(new Node(i, j));
                }
            }
        }
        visited = new boolean[M];
        sub(new int[M]);
    }

    static boolean[] visited;
    public static void sub(int[] sub) {
    }
}
