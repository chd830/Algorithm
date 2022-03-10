package 구현;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/16946
public class 벽부수고이동하기4 {
    static class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int N;
    static int M;
    static int[] list;
    static int[][] arr;
    static int[][] group;
    static boolean[][] visited;
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        arr = new int[N][M];
        group = new int[N][M];
        visited = new boolean[N][M];
        list = new int[N*M+1];
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j)-'0';
            }
        }
        // 벽은 1 이동가능한곳은 0
        // 본인을 포함해서 연결된 0의 개수
        int idx = 1;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(arr[i][j] == 0 && group[i][j] == 0) {
                    bfs(i, j, idx++);
                }
            }
        }
//        for(int i = 0; i < list.size(); i++)
//            System.out.print(i+": "+list.get(i)+"\t");
//        System.out.println();
//        for(int i = 0; i < N; i++)
//            System.out.println(Arrays.toString(group[i]));
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(arr[i][j] == 1) {
                    int sum = 1;
                    HashSet<Integer> set = new HashSet<>();
                    for(int d = 0; d < 4; d++) {
                        int dx = i + dir[d][0];
                        int dy = j + dir[d][1];
                        if(isIn(dx, dy) && group[dx][dy] != 0 && !set.contains(group[dx][dy])) {
                            set.add(group[dx][dy]);
                            sum += list[group[dx][dy]];
                        }
                    }
                    sb.append(sum%10);
                }
                else
                    sb.append(0);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
    static boolean isIn(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }
    static void bfs(int x, int y, int idx) {
        // bfs만들때마다 visited처리를 하면 시간초과가 남
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(x, y));
        visited[x][y] = true;
        group[x][y] = idx;
        int cnt = 1;
        while(!que.isEmpty()) {
            Node n = que.poll();
            for(int d = 0; d < 4; d++) {
                int dx = n.x + dir[d][0];
                int dy = n.y + dir[d][1];
                if(isIn(dx, dy) && !visited[dx][dy] && arr[dx][dy] == 0) {
                    group[dx][dy] = idx;
                    cnt++;
                    visited[dx][dy] = true;
                    que.add(new Node(dx, dy));
                }
            }
        }
        list[idx] = cnt;
    }
}
