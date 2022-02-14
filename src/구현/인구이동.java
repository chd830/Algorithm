package 구현;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/16234
public class 인구이동 {
    static class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int N;
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        int L = Integer.parseInt(token.nextToken());
        int R = Integer.parseInt(token.nextToken());
        int[][] arr = new int[N][N];
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(token.nextToken());
            }
        }
        int cnt = 0;
        boolean flag = true;
        while(flag) {
            flag = false;
            boolean[][] visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(!visited[i][j]) {
                        Queue<Node> que = new LinkedList<>();
                        List<Node> list = new ArrayList<>();
                        int sum = arr[i][j];
                        que.add(new Node(i, j));
                        visited[i][j] = true;
                        list.add(new Node(i, j));
                        while (!que.isEmpty()) {
                            Node n = que.poll();
                            for (int d = 0; d < 4; d++) {
                                int dx = n.x + dir[d][0];
                                int dy = n.y + dir[d][1];
                                if (isIn(dx, dy) && !visited[dx][dy] && Math.abs(arr[dx][dy] - arr[n.x][n.y]) >= L && Math.abs(arr[dx][dy] - arr[n.x][n.y]) <= R) {
                                    flag = true;
                                    visited[dx][dy] = true;
                                    que.add(new Node(dx, dy));
                                    list.add(new Node(dx, dy));
                                    sum += arr[dx][dy];
                                }
                            }
                        }
                        int average = sum / list.size();
                        for (Node n : list) {
                            arr[n.x][n.y] = average;
                        }
                    }
                }
            }
            if(flag) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
    static boolean isIn(int dx, int dy) {
        return dx >= 0 && dy >= 0 && dx < N && dy < N;
    }
}