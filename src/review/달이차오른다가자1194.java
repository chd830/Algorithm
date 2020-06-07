package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//boolean 3차원배열 사용하기
public class 달이차오른다가자1194 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M][64];
        Node start = null;
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
                if(map[i][j] == '0') {
                    start = new Node(i, j, 0);
                }
            }
        }
        Queue<Node> que = new LinkedList<>();
        que.add(start);
        while(!que.isEmpty()) {
            int size = que.size();
            Node n = que.poll();
            for(int i = 0; i < size; i++) {
                for(int d = 0; d < 4; d++) {
                    int dx = n.x + dir[d][0];
                    int dy = n.y + dir[d][1];
                    if(dx < 0 || dy < 0 || dx >= N || dy >= M || map[dx][dy] == '#') {
                        continue;
                    }
                    if(map[dx][dy] == '1') {
                        System.out.println(n.cnt + 1);
                        System.exit(0);
                    }
                    else if(map[dx][dy] == '.' || map[dx][dy] == '0') {
                        que.add(new Node(dx, dy, n.cnt + 1));
                    }
                    else if(map[dx][dy] >= 'a' && map[dx][dy] <= 'z') {
                        alph[map[dx][dy]-97]++;
                        que.add(new Node(dx, dy, n.cnt+1));
                    }
                    else if(map[dx][dy] >= 'A' && map[dx][dy] <= 'Z' && alph[map[dx][dy]-65] != 0) {
                        que.add(new Node(dx, dy, n.cnt+1));
                    }
                }
            }
        }
        System.out.println(-1);
    }
    static int N;
    static int M;
    static char[][] map;
    static int[] alph = new int[26];
    static boolean[][][] visited;
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
