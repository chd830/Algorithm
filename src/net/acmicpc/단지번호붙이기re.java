package net.acmicpc;

import java.io.*;
import java.util.*;

public class 단지번호붙이기re {
    static int N;
    static int cnt;
    static char[][] map;
//    static boolean[][] visited1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        Scanner sc = new Scanner(System.in);
//        W = sc.nextInt();
        N = Integer.parseInt(br.readLine());
        map = new char[N+2][N+2];
//        visited1 = new boolean[W][W];
        List<Integer> list = new ArrayList();
        for(int i = 0; i < N; i++) {
//            String str = sc.next();
            String str = br.readLine();
            for(int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                if(map[i][j] == '1' /*&& !visited1[i][j]*/) {
//                    dfs(i, j);
//                    list.add(island);
//                    island = 0;
                    bfs(i, j);
                    list.add(cnt);
                    cnt = 0;
                }
            }
        }
//        System.out.println(list.size());
        bw.write(list.size()+"\n");
        Collections.sort(list);
        for(int i : list) {
//            System.out.println(i+" ");
            bw.write(i+"\n");
        }
        bw.flush();
    }

//    static void print() {
//        for(int i = 0; i < W; i++) {
//            System.out.println(Arrays.toString(visited1[i]));
//        }
//        System.out.println();
//    }

    static int[][] move = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public static void dfs(int x, int y) {
        for(int i = 0; i < 4; i++) {
            int nx = x + move[i][0];
            int ny = y + move[i][1];
            if(/*nx < W && nx >= 0 && ny < W && ny >= 0 &&*//* !visited1[nx][ny] && */map[nx][ny] == '1') {
//                visited1[nx][ny] = true;
                map[nx][ny] = '0';
                cnt++;
                dfs(nx, ny);
            }
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

    public static void bfs(int x, int y) {
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(x, y));
//        visited1[left][right] = true;
        while(!que.isEmpty()) {
            Node n = que.poll();
            System.out.println("("+n.x+", "+n.y+")");
            for(int i = 0; i < 4; i++) {
                int nx = n.x + move[i][0];
                int ny = n.y + move[i][1];
                if(/*nx >= 0 && ny >= 0 && nx < W && ny < W &&*//* !visited1[nx][ny] && */map[nx][ny] == '1') {
                    que.add(new Node(nx, ny));
//                    visited1[nx][ny] = true;
                    map[nx][ny] = '0';
                    cnt++;
                }
            }
        }
    }
}
