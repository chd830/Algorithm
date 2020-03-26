package net.acmicpc;

import java.util.PriorityQueue;
import java.util.Scanner;

public class 아기상어 {
    static int N;
    static Node start;
    static int[][] map;
    static class Node {
        int x;
        int y;
        int size;
        Node(int x, int y, int size) {
            this.x = x;
            this.y = y;
            this.size = size;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
                if(map[i][j] == 9) {
                    start = new Node(i, j, 2);
                    continue;
                }
                if(map[i][j] != 0) {
                }
            }
        }
        int size = 2;
        int cnt = 0;
        int result = 0;
    }
}
