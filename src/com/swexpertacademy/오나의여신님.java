package com.swexpertacademy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 오나의여신님 {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int M;
    static int move[][] = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    static char map[][];
    static Queue<Node> Points;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            sb.append("#").append(tc).append(" ");
            StringTokenizer tokens = new StringTokenizer(br.readLine());

            N = Integer.parseInt(tokens.nextToken());
            M = Integer.parseInt(tokens.nextToken());
            Points = new LinkedList<>();
            map = new char[N][M];
            Node player = null;
            for (int r = 0; r < N; r++) {
                map[r] = br.readLine().toCharArray();
                for (int c = 0; c < M; c++) {
                    if (map[r][c] == '*') {
                        Points.offer(new Node(r, c, 0, true));
                    } else if (map[r][c] == 'S') {
                        player = new Node(r, c, 0, false);
                    }
                }
            }
            Points.offer(player);
            // 이제 탐험 시작 !!
            // 끝나는 시점 : 모든 수연이 소멸할 때 까지 or 수연이가 여신에게 도달할 때 까지
            int A = Integer.MAX_VALUE;
            outer: while (!Points.isEmpty()) {
                Node n = Points.poll();

                for (int d = 0; d < move.length; d++) {
                    int dx = n.x + move[d][0];
                    int dy = n.y + move[d][1];

                    if (isIn(dx, dy)) { // 범위에 있다면 수연이는 .으로 이동, D를 만나면 땡
                        if (n.devil) {
                            if (map[dx][dy] == '.' || map[dx][dy] == 'S') {
                                map[dx][dy] = '*';
                                // 큐에 새로 들어가긴 하지만 빠지지는 않는다
                                Points.offer(new Node(dx, dy, n.cnt + 1, true));
                            }
                        } else {
                            if (map[dx][dy] == 'D') {
                                A = n.cnt +1;
                                break outer;
                            } else if (map[dx][dy] == '.') {
                                map[dx][dy] = 'S';
                                Points.offer(new Node(dx, dy, n.cnt + 1, false));
                            }

                        }
                    }
                }
            }
            if(A == Integer.MAX_VALUE)
                sb.append("GAME OVER");
            else
                sb.append(A);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static boolean isIn(int x, int y) {
        return 0 <= x && 0 <= y && x < N && y < M;
    }

    static class Node {
        int x;
        int y;
        int cnt;
        boolean devil;

        public Node(int r, int c, int cnt, boolean devil) {
            super();
            this.x = r;
            this.y = c;
            this.cnt = cnt;
            this.devil = devil;
        }
    }
}