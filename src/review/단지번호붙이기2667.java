package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 단지번호붙이기2667 {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N][N];
        list = new ArrayList();
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < N; j++) {
                visited[i][j] = str.charAt(j)-'0' == 1 ? false : true;
            }
        }
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!visited[i][j]) {
                    cnt = 0;
                    checkNeighbor(i, j);
                    list.add(cnt);
                }
            }
        }
        sb.append(list.size()).append("\n");
        Collections.sort(list);
        for(int i = 0; i < list.size(); i++) {
            sb.append(list.get(i)).append("\n");
        }
        System.out.println(sb);

    }
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static boolean[][] visited;
    static List<Integer> list;
    static int cnt;
    static int N;
    static class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static void checkNeighbor(int x, int y) {
        visited[x][y] = true;
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(x, y));
        cnt = 1;
        while(!que.isEmpty()) {
            Node n = que.poll();
            for(int i = 0; i < 4; i++) {
                 int dx = n.x + dir[i][0];
                 int dy = n.y + dir[i][1];
                 if(dx >= 0 && dy >= 0 && dx < N && dy < N && !visited[dx][dy]) {
                     que.add(new Node(dx, dy));
                     visited[dx][dy] = true;
                     cnt++;
                 }
            }
        }

    }
}
