package net.acmicpc;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//1. 도착지점에서 말이 움직일 수 있는 만큼 움직인 후 걸어서 출발지점으로 가기
//2. 출발지점에서 말이 움직일 수 있는 만큼 움직인 후 걸어서 도착지점으로 가기
public class 말이되고픈원숭이 {
    static int[][] horse = {{-2, 1}, {-1, 2},{2, 1}, {1, 2}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};
    static int[][] move = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static int K;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        K = sc.nextInt();
        int W = sc.nextInt();
        int H = sc.nextInt();
        int[][] arr = new int[W][H];
        for(int i = 0; i < W; i++) {
            for(int j = 0; j < H; j++) {
                arr[i][j] = sc.nextInt();
                if(arr[i][j] == 1) {
                    arr[i][j] = -1;
                }
            }
        }
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(0, 0));
        while(!que.isEmpty()) {
            Node n = que.poll();
            if(K > 0) {
                for(int i = 0; i < 8; i++) {
                    int dx = n.x + horse[i][0];
                    int dy = n.y + horse[i][1];
                    if(dx < W && dy < H && dx >= 0 && dy >= 0 && arr[dx][dy] != -1 && arr[dx][dy] == 0) {
                        que.add(new Node(dx, dy));
                        arr[dx][dy] = arr[n.x][n.y] + 1;
                    }
                }
                K--;
            }
            else {
                for(int i = 0; i < 4; i++) {
                    int dx = n.x + move[i][0];
                    int dy = n.y + move[i][1];
                    if(dx < W && dy < H && dx >= 0 && dy >= 0 && arr[dx][dy] != -1 && arr[dx][dy] == 0) {
                        que.add(new Node(dx, dy));
                        arr[dx][dy] = arr[n.x][n.y] + 1;
                    }
                }
            }
            for(int i = 0; i < W; i++) {
                System.out.println(Arrays.toString(arr[i]));
            }
            System.out.println();
        }
        System.out.println(arr[W-1][H-1]);
    }

    static class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
