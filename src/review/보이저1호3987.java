package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//들어오는 방향에 따라 같은 곳을 두번 방문할 수도 있어 이차원배열이 아닌 삼차원배열로 접근해야한다.
public class 보이저1호3987 {
    static int N;
    static int M;
    static int block;
    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        char[][] map = new char[N][M];
        block = 0;
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
                if(map[i][j] != 'C') {
                    block++;
                }
            }
        }
        token = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(token.nextToken());
        int y = Integer.parseInt(token.nextToken());
        //U, R, D, L
        int cnt = 0;
        String direction = "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            int num = bfs(x - 1, y - 1, i, map);
            if (num == -1) {
                System.out.println("Voyager");
                System.exit(0);
            }
            if (cnt < num) {
                switch (i) {
                    case 0:
                        direction = "U";
                        break;
                    case 1:
                        direction = "R";
                        break;
                    case 2:
                        direction = "D";
                        break;
                    case 3:
                        direction = "L";
                        break;
                }
                cnt = num;
            }
        }
        sb.append(direction).append("\n").append(cnt);
        System.out.println(sb);
    }

    static int bfs(int x, int y, int i, char[][] map) {
        int cnt = 1;
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(x, y));
        while (!que.isEmpty()) {
            if (cnt > block) {
                return -1;
            }
            /*
            3 3
            /.\
            ...
            \./
            2 3
             */
            Node n = que.poll();
            int dx = n.x + dir[i][0];
            int dy = n.y + dir[i][1];
            if (dx >= 0 && dy >= 0 && dx < N && dy < M) {
                if (map[dx][dy] == 'C') {
                    return cnt;
                }
                //0 >> 1, 1 >> 0, 3 >> 2, 2 >> 3
                if (map[dx][dy] == '/') {
                    switch (i) {
                        case 0:
                            i = 1;
                            break;
                        case 1:
                            i = 0;
                            break;
                        case 2:
                            i = 3;
                            break;
                        case 3:
                            i = 2;
                            break;
                    }
                }
                //0 >> 3, 3 >> 0, 2 >> 1, 1 >> 2
                else if (map[dx][dy] == '\\') {
                    switch (i) {
                        case 0:
                            i = 3;
                            break;
                        case 1:
                            i = 2;
                            break;
                        case 2:
                            i = 1;
                            break;
                        case 3:
                            i = 0;
                            break;
                    }
                }
                que.add(new Node(dx, dy));
                cnt++;
//                print(map);
            }
        }
        return cnt;
    }

    static void print(char[][] map) {
        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(map[i]));
        }
        System.out.println();
    }

    static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
