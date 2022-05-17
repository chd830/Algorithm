package DFS;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/3987
public class 보이저1호 {
    static int N;
    static int M;
    static Node start;
    static char[][] arr;
    static boolean[][][] visited;
    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        arr = new char[N][M];
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j);
            }
        }
        token = new StringTokenizer(br.readLine());
        start = new Node(Integer.parseInt(token.nextToken())-1, Integer.parseInt(token.nextToken())-1);
        String direction = "";
        flag = false;
        for(int i = 0; i < dir.length; i++) {
            visited = new boolean[N][M][4];
            visited[start.x][start.y][i] = true;
            int cnt = bfs(i, start.x, start.y);
            if(flag) {
                direction = direct[i];
                break;
            }
            if(max < cnt) {
                max = cnt;
                direction = direct[i];
            }
//            System.out.println();
        }
        System.out.println(direction);
        System.out.println(flag ? "Voyager" : max);
    }
    static String[] direct = {"U", "R", "D", "L"};
    static int max;
    static boolean flag;
    static int bfs(int d, int x, int y) {
        int cnt = 1;
        while(true) {
            int dx = x + dir[d][0];
            int dy = y + dir[d][1];
            if(dx >= 0 && dy >= 0 && dx < N && dy < M) {
                if(arr[dx][dy] == 'C')
                    break;
                if(arr[dx][dy] == '.' && visited[dx][dy][d]) {
                    flag = true;
                    break;
                }
                cnt++;
                if(arr[dx][dy] == '\\') {
                    if (d == 0)
                        d = 3;
                    else if (d == 1)
                        d = 2;
                    else if (d == 2)
                        d = 1;
                    else
                        d = 0;
                }
                else if(arr[dx][dy] == '/'){
                    if(d == 0)
                        d = 1;
                    else if(d == 1)
                        d = 0;
                    else if(d == 2)
                        d = 3;
                    else
                        d = 2;
                }
                visited[dx][dy][d] = true;
                x = dx;
                y = dy;
            }
            else
                break;
        }
        return cnt;
    }
}