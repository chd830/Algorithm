package 구현;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/16920
public class 확장게임 {
    static class Node implements Comparable<Node> {
        int x;
        int y;
        int val;
        Node(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    ", val=" + val +
                    '}';
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.val, o.val);
        }
    }
    static int N;
    static int M;
    static int[] moves;
    static int[] result;
    static char[][] arr;
    static boolean[][] visited;
    static List<Node>[] starts;
    static int[][] dir = {{0, 1}, {0, -1}, {1 ,0}, {-1, 0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        int P = Integer.parseInt(token.nextToken());
        arr = new char[N][M];
        visited = new boolean[N][M];
        moves = new int[P+1];
        starts = new ArrayList[P+1];
        result = new int[P+1];
        token = new StringTokenizer(br.readLine());
        for(int i = 1; i <= P; i++) {
            moves[i] = Integer.parseInt(token.nextToken());
            starts[i] = new ArrayList<>();
        }
        for(int i = 0, idx = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j);
                if(arr[i][j] == '#')
                    visited[i][j] = true;
                else if(arr[i][j] != '.') {
                    starts[arr[i][j]-'0'].add(new Node(i, j, 0));
                    visited[i][j] = true;
                    result[arr[i][j]-'0']++;
                }
            }
        }
        while(true) {
            boolean flag = false;
            // 다음에 갈 곳이 없을 때 끝냄
            for(int i = 1; i <= P; i++)
                flag = bfs(i) || flag;
            if(!flag)
                break;
        }
        for(int i = 1; i <= P; i++)
            System.out.print(result[i]+" ");
    }
    static boolean bfs(int idx) {
        Queue<Node> que = new LinkedList<>();
        for(Node node : starts[idx])
            que.add(node);
        starts[idx].clear();
        while(!que.isEmpty()) {
            Node n = que.poll();
            // 다음에 이동할 위치를 추가(n.val == moves[idx]인 이유는 작은 값은 이동할 곳이 없기 떄문)
            if(n.val == moves[idx]) {
                n.val = 0;
                starts[idx].add(n);
                continue;
            }
            for(int d = 0; d < 4; d++) {
                int dx = n.x + dir[d][0];
                int dy = n.y + dir[d][1];
                if(dx >= 0 && dy >= 0 && dx < N && dy < M && n.val < moves[idx] && !visited[dx][dy]) {
                    visited[dx][dy] = true;
                    arr[dx][dy] = arr[n.x][n.y];
                    que.add(new Node(dx, dy, n.val+1));
                    result[idx]++;
                }
            }
        }
        // 이동할 값이 있는지 유무를 반환
        return !starts[idx].isEmpty();
    }
}
