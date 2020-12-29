package review;

import java.io.*;
import java.util.*;

public class 양 {
    static int N;
    static int M;
    static int sheep;
    static int wolf;
    static char[][] maps;
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        maps = new char[N][M];
        boolean[][] visited = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                maps[i][j] = str.charAt(j);
            }
        }
        Queue<Node> que = new LinkedList<>();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(!visited[i][j] && maps[i][j] != '#') {
                    int s = 0;
                    int w = 0;
                    que.add(new Node(i, j));
                    visited[i][j] = true;
                    if(maps[i][j] == 'o') {
                        s++;
                    }
                    else if(maps[i][j] == 'v') {
                        w++;
                    }
                    while(!que.isEmpty()) {
                        Node n = que.poll();
                        for(int d = 0; d < dir.length; d++) {
                            int dx = n.x + dir[d][0];
                            int dy = n.y + dir[d][1];
                            if(dx >= 0 && dy >= 0 && dx < N && dy < M && !visited[dx][dy] && maps[dx][dy] != '#') {
                                que.add(new Node(dx, dy));
                                if(maps[dx][dy] == 'o') {
                                    s++;
                                }
                                else if(maps[dx][dy] == 'v') {
                                    w++;
                                }
                                visited[dx][dy] = true;
                            }
                        }
                    }
                    if(s == 0 && w == 0) {
                        continue;
                    }
                    else if(s > w) {
                        sheep += s;
                    }
                    else {
                        wolf += w;
                    }
                }
            }
        }
        System.out.println(sheep+" "+wolf);
    }
}
