package review;

import java.util.*;
import java.io.*;

// 두 동전
public class acmicpc16197 {
    static class Node {
        int x;
        int y;
        int cnt;
        Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    ", cnt=" + cnt +
                    '}';
        }
    }
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        char[][] arr = new char[N][M];
        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        Queue<Node> que = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j);
                if(arr[i][j] == 'o') {
                    que.add(new Node(i, j, 0));
                }
            }
        }

        while(!que.isEmpty()) {
            Node n1 = que.poll();
            Node n2 = que.poll();

            if(n1.cnt > 10) {
                System.out.println(-1);
                System.exit(0);
            }
            for(int d = 0; d < 4; d++) {
                int dx1 = n1.x + dir[d][0];
                int dy1 = n1.y + dir[d][1];
                int dx2 = n2.x + dir[d][0];
                int dy2 = n2.y + dir[d][1];
                boolean c1 = check(dx1, dy1);
                boolean c2 = check(dx2, dy2);

                if(c1 && c2) continue;
                if(c1 || c2) {
                    System.out.println(n1.cnt+1);
                    System.exit(0);
                }
                if(arr[dx1][dy1] == '#' && arr[dx2][dy2] == '#')
                    continue;
                if(arr[dx1][dy1] == '#') {
                    dx1 = n1.x;
                    dy1 = n1.y;
                }
                if(arr[dx2][dy2] == '#') {
                    dx2 = n2.x;
                    dy2 = n2.y;
                }
                que.add(new Node(dx1, dy1, n1.cnt+1));
                que.add(new Node(dx2, dy2, n2.cnt+1));
            }
        }
        System.out.println(-1);
    }
    static boolean check(int x, int y) {
        return !(x >= 0 && y >= 0 && x < N && y < M);
    }
}
