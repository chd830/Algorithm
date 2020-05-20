package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 상범빌딩6593 {
    static int N;
    static int M;
    static int L;
    static char[][][] map;
    static boolean[][][] visited;
    static int dz[]={1,-1,0,0,0,0};
    static int dy[]={0,0,0,1,0,-1};
    static int dx[]={0,0,-1,0,1,0};
    static class Node {
        int x;
        int y;
        int z;
        int cnt;
        Node(int x, int y, int z, int cnt) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.cnt = cnt;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;
        L = -1;
        while(true) {
            token = new StringTokenizer(br.readLine());
            L = Integer.parseInt(token.nextToken());
            N = Integer.parseInt(token.nextToken());
            M = Integer.parseInt(token.nextToken());
            if(L == 0) {
                System.exit(0);
            }
            map = new char[N][M][L];
            visited = new boolean[N][M][L];
            boolean check = false;
            Queue<Node> que = new LinkedList<>();
            for(int k = 0; k < L; k++) {
                for (int i = 0; i < N; i++) {
                    String str = br.readLine();
                    for (int j = 0; j < M; j++) {
                        map[i][j][k] = str.charAt(j);
                        if(map[i][j][k] == 'S') {
                            que.add(new Node(i, j, k, 0));
                        }
                    }
                }
                br.readLine();
            }
            int min = Integer.MAX_VALUE;
            while(!que.isEmpty()) {
                Node n = que.poll();
                if(map[n.x][n.y][n.z] == 'E') {
                    min = Math.min(n.cnt, min);
                    check = true;
                    break;
                }
                for(int d = 0; d < 6; d++) {
                    int nx = n.x + dx[d];
                    int ny = n.y + dy[d];
                    int nz = n.z + dz[d];
                    if(nx >= 0 && ny >= 0 && nz >= 0 && nx < N && ny < M && nz < L && !visited[nx][ny][nz]) {
                        if(map[nx][ny][nz] != '#') {
                            visited[nx][ny][nz] = true;
                            que.add(new Node(nx, ny, nz, n.cnt+1));
                        }
                    }
                }
            }
            System.out.println(check ? "Escaped in "+min+" minute(s).": "Trapped!");
        }
    }
}
/*
3 3 3
..S
...
...
...
...
...
...
...
E..
 */
