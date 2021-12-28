package BFS;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/2146
public class 다리만들기 {
    static int N;
    static int result;
    static int[][] arr;
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static boolean[][] visited;
    static class Node {
        int x;
        int y;
        int count;
        Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
    static boolean isIn(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        result = Integer.MAX_VALUE;

        for(int i = 0; i < N; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        // bfs를 사용해서 섬마다 숫자를 다르게 기입
        int count = 1;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(arr[i][j] == 1) {
                    visited = new boolean[N][N];
                    Queue<Node> que = new LinkedList<>();
                    que.add(new Node(i, j, 0));
                    arr[i][j] = count;
                    visited[i][j] = true;
                    while(!que.isEmpty()) {
                        Node n = que.poll();
                        for(int d = 0; d < 4; d++) {
                            int dx = n.x + dir[d][0];
                            int dy = n.y + dir[d][1];
                            if(isIn(dx, dy) && !visited[dx][dy] && arr[dx][dy] == 1) {
                                arr[dx][dy] = count;
                                visited[dx][dy] = true;
                                que.add(new Node(dx, dy, 0));
                            }
                        }
                    }
                    count++;
                }
            }
        }

//        print();

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(arr[i][j] != 0) {
                    visited = new boolean[N][N];
                    Queue<Node> que = new LinkedList<>();
                    que.add(new Node(i, j, 0));
                    visited[i][j] = true;
                    loop: while(!que.isEmpty()) {
                        Node n = que.poll();
                        for(int d = 0; d < 4; d++) {
                            int dx = n.x + dir[d][0];
                            int dy = n.y + dir[d][1];
                            if(isIn(dx, dy) && !visited[dx][dy] && result > n.count) {
                                visited[dx][dy] = true;
                                if(arr[dx][dy] == 0) {
                                    que.add(new Node(dx, dy, n.count+1));
                                }
                                else if(arr[dx][dy] != arr[i][j]){
                                    result = Math.min(result, n.count);
                                    break loop;
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(result);
    }
    static void print() {
        for(int i = 0; i < N; i++)
            System.out.println(Arrays.toString(arr[i]));
        System.out.println();
    }
}
