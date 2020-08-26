package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 영역구하기2583 {
    static List<Integer> area;
    static boolean[][] visited;
    static int N;
    static int M;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        M = Integer.parseInt(token.nextToken());
        N = Integer.parseInt(token.nextToken());
        int K = Integer.parseInt(token.nextToken());
        visited = new boolean[M][N];
        for(int i = 0; i < K; i++) {
            token = new StringTokenizer(br.readLine());
            paint(new int[] {Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken())}, new int[] {Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken())});
        }
        area = new ArrayList<>();
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                if(!visited[i][j]) {
                    cnt = 0;
                    checkArea(i, j);
                    area.add(cnt);
                }
            }
        }
        if(area.size() == 0) {
            System.out.println(0);
        }
        Collections.sort(area);
        for(int i = 0; i < area.size(); i++) {
            System.out.print(area.get(i)+" ");
        }
    }
    static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static void checkArea(int x, int y) {
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[] {x, y});
        visited[x][y] = true;
        cnt++;
        while(!que.isEmpty()) {
            int[] node = que.poll();
            for(int i = 0; i < 4; i++) {
                int dx = node[0] + dir[i][0];
                int dy = node[1] + dir[i][1];
                if(dx >= 0 && dy >= 0 && dx < M && dy < N && !visited[dx][dy]) {
                    que.add(new int[] {dx, dy});
                    visited[dx][dy] = true;
                    cnt++;
                }
            }
        }
    }
    public static void paint(int[] start, int[] end) {
        for(int i = N-start[1]; i < end[1]; i++) {
            for(int j = N-start[0]; j < end[0]; j++) {
                visited[i][j] = true;
            }
        }
    }
}
