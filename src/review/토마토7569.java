package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 토마토7569 {
    static class Node {
        int x;
        int y;
        int z;
        Node(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static int[] z = {1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(token.nextToken());
        int N = Integer.parseInt(token.nextToken());
        int H = Integer.parseInt(token.nextToken());
        int[][][] map = new int[N][M][H];
        int total = 0;
        Queue<Node> que = new LinkedList<>();
        for(int i = 0; i < H; i++) {
            for(int j = 0; j < N; j++) {
                token = new StringTokenizer(br.readLine());
                for(int k = 0; k < M; k++) {
                    map[j][k][i] = Integer.parseInt(token.nextToken());
                    if(map[j][k][i] == 1) {
                        que.add(new Node(j, k, i));
                    }
                    if(map[j][k][i] != 0) {
                        total++;
                    }
                }
            }
        }
        int cnt = 0;
        while(!que.isEmpty()) {
            int size = que.size();
            if(total == N*M*H) {
                break;
            }
            for(int i = 0; i < size; i++) {
                Node n = que.poll();
                for(int d = 0; d < 4; d++) {
                    for(int s = 0; s < 2; s++) {
                        int dx = n.x + dir[d][0];
                        int dy = n.y + dir[d][1];
                        int dz = n.z + z[s];
                        if (dx >= 0 && dy >= 0 && dx < N && dy < M) {
                            if(map[dx][dy][n.z] == 0) {
                                que.add(new Node(dx, dy, n.z));
                                map[dx][dy][n.z] = 1;
                                total++;
                            }
                            if(dz >= 0 && dz < H && map[n.x][n.y][dz] == 0) {
                                que.add(new Node(n.x, n.y, dz));
                                map[n.x][n.y][dz] = 1;
                                total++;
                            }
                        }
                    }
                }
            }
            cnt++;
        }
        System.out.println(total != N*M*H ? -1 : cnt);
    }
}
