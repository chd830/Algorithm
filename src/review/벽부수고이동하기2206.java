package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//3차원배열로 해야됨.
public class 벽부수고이동하기2206 {
    static int N;
    static int M;
    static char[][] map;
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int[][][] cnt;
    static boolean[][][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        map = new char[N][M];
        cnt = new int[N][M][2];
        visited = new boolean[N][M][2];
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        Queue<Node> que = new LinkedList();
        que.add(new Node(0, 0, 1, 0));
        while(!que.isEmpty()) {
            Node n = que.poll();
            if(n.x == N-1 && n.y == M-1) {
                System.out.println(n.cnt);
                System.exit(0);
            }
            for(int d = 0; d < 4; d++) {
                int dx = n.x + dir[d][0];
                int dy = n.y + dir[d][1];
                if(dx >= 0 && dy >= 0 && dx < N && dy < M) {
                    //벽을 지나갔을 때
                    if(n.wall == 1) {
                        if (map[dx][dy] == '0' && !visited[dx][dy][n.wall]) {
                            visited[dx][dy][n.wall] = true;
                            que.add(new Node(dx, dy, n.cnt + 1, n.wall));
                        }
                    }
                    //벽을 지나가지 않았을 때
                    else {
                        if(map[dx][dy] == '1' && !visited[dx][dy][n.wall+1]) {
                            visited[dx][dy][n.wall+1] = true;
                            que.add(new Node(dx, dy, n.cnt+1, n.wall+1));
                        }
                        if(map[dx][dy] == '0' && !visited[dx][dy][n.wall]) {
                            visited[dx][dy][n.wall] = true;
                            que.add(new Node(dx, dy, n.cnt+1, n.wall));
                        }
                    }
                }
            }
        }
        System.out.println(-1);
    }
    static class Node {
        int x;
        int y;
        int cnt;
        int wall;
        Node(int x, int y, int cnt, int wall) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.wall = wall;
        }
    }
}
