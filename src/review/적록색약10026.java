package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 적록색약10026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        char[][] arr = new char[N][N];
        char[][] colorWeak = new char[N][N];
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < N; j++) {
                arr[i][j] = str.charAt(j);
                if(arr[i][j] == 'G') {
                    colorWeak[i][j] = 'R';
                }
                else {
                    colorWeak[i][j] = arr[i][j];
                }
            }
        }
        int cnt = 0;
        visited = new boolean[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!visited[i][j]) {
                    cnt++;
                    bfs(i, j, arr);
                }
            }
        }
        sb.append(cnt).append(" ");
        cnt = 0;
        visited = new boolean[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!visited[i][j]) {
                    cnt++;
                    bfs(i, j, colorWeak);
                }
            }
        }
        sb.append(cnt);
        System.out.println(sb);
    }
    static void bfs(int i, int j, char[][] arr) {
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(i, j));
        visited[i][j] = true;
        while(!que.isEmpty()) {
            Node n = que.poll();
            for(int d = 0; d < 4; d++) {
                int dx = n.x + dir[d][0];
                int dy = n.y + dir[d][1];
                if(dx >= 0 && dy >= 0 && dx < N && dy < N && !visited[dx][dy] && arr[dx][dy] == arr[i][j]) {
                    que.add(new Node(dx, dy));
                    visited[dx][dy] = true;
                }
            }
        }
    }
    static int N;
    static boolean[][] visited;
    static int[][] dir = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    static class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
