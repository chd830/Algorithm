package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로탐색2178 {
    public static int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());
        int[][] map = new int[N][M];
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(0, 0, 1));
        boolean[][] visited = new boolean[N][M];
        while(!que.isEmpty()) {
            Node n = que.poll();
            if(n.x == N-1 && n.y == M-1) {
                return n.cnt;
            }
            for(int d = 0; d < 4; d++) {
                int dx = n.x + dir[d][0];
                int dy = n.y + dir[d][1];
                if(dx >= 0 && dy >= 0 && dx < N && dy < M && !visited[dx][dy] && map[dx][dy] == 1) {
                    que.add(new Node(dx, dy, n.cnt+1));
                    visited[dx][dy] = true;
                }
            }
        }
        return 0;
    }
    public static void main(String[] args) throws IOException {
        System.out.println(solution());
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer token = new StringTokenizer(br.readLine());
//        int N = Integer.parseInt(token.nextToken());
//        int M = Integer.parseInt(token.nextToken());
//        char[][] map = new char[N][M];
//        boolean[][] visited = new boolean[N][M];
//        for(int i = 0; i < N; i++) {
//            String str = br.readLine();
//            for(int j = 0; j < M; j++) {
//                map[i][j] = str.charAt(j);
//            }
//        }
//        Queue<Node> que = new LinkedList();
//        que.add(new Node(0, 0, 1));
//        visited[0][0] = true;
//        while(!que.isEmpty()) {
//            Node cur = que.poll();
//            if(cur.x == N-1 && cur.y == M-1) {
//                System.out.println(cur.cnt);
//                break;
//            }
//            for(int d = 0; d < 4; d++) {
//                int dx = cur.x + dir[d][0];
//                int dy = cur.y + dir[d][1];
//                if(dx >= 0 && dy >= 0 && dx < N && dy < M && !visited[dx][dy] && map[dx][dy] == '1') {
//                    que.add(new Node(dx, dy, cur.cnt+1));
//                    visited[dx][dy] = true;
//                }
//            }
//        }
    }
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static class Node {
        int x;
        int y;
        int cnt;
        Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}
