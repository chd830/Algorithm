package net.acmicpc.re;

import java.util.*;
import java.io.*;

// 2583
public class 영역구하기 {
    static int N;
    static int M;
    static boolean[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        M = Integer.parseInt(token.nextToken());
        N = Integer.parseInt(token.nextToken());
        int K = Integer.parseInt(token.nextToken());
        arr = new boolean[N][M];
        while(K-- > 0) {
           token = new StringTokenizer(br.readLine());
           int x1 = Integer.parseInt(token.nextToken());
           int y1 = Integer.parseInt(token.nextToken());
           int x2 = Integer.parseInt(token.nextToken())-1;
           int y2 = Integer.parseInt(token.nextToken())-1;
           change(x1, y1, x2, y2);
        }
        List<Integer> list = new ArrayList<>();
        int cnt = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(!arr[i][j]) {
                    cnt ++ ;
                    list.add(count(i, j));
                }
            }
        }
        System.out.println(cnt);
        Collections.sort(list);
        for(int i : list)
            System.out.print(i+" ");
    }
    static boolean isIn(int dx, int dy) {
        return dx >= 0 && dy >= 0 && dx < N && dy < M;
    }
    static int count(int i, int j) {
        arr[i][j] = true;
        int cnt = 1;
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(i, j));
        while(!que.isEmpty()) {
            Node n = que.poll();
            for(int d = 0; d < 4; d++) {
                int dx = n.x + dir[d][0];
                int dy = n.y + dir[d][1];
                if(isIn(dx, dy) && !arr[dx][dy]) {
                    arr[dx][dy] = true;
                    que.add(new Node(dx, dy));
                    cnt++;
                }
            }
        }
        return cnt;
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
    static void change(int x1, int y1, int x2, int y2) {
        for(int i = x1; i <= x2; i++) {
            for(int j = y1; j <= y2; j++) {
                arr[i][j] = true;
            }
        }
    }
}
