package DFS;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/2638
public class 치즈 {
    static int N;
    static int M;
    static int time;
    static int count;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        arr = new int[N][M];
        time = 0;
        count = 0;
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(token.nextToken());
                if(arr[i][j] == 1)
                    count++;
            }
        }
        while(count > 0) {
            find();
        }
        System.out.println(time);
    }
    static class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static boolean[][] visited;
    static boolean isIn(int dx, int dy) {
        return dx >= 0 && dy >= 0 && dx < N && dy < M;
    }
    static void find() {
        visited = new boolean[N][M];
        Queue<Node> cheeze = new LinkedList<>();
        Queue<Node> air = new LinkedList<>();
        for(int i = 0; i < N; i++) {
            arr[i][0] = 2;
            air.add(new Node(i, 0));
            visited[i][0] = true;
        }
        for(int i = 0; i < M; i++) {
            arr[0][i] = 2;
            air.add(new Node(0, i));
            visited[0][i] = true;
        }
        while(!air.isEmpty()) {
            Node n  = air.poll();
            for(int d = 0; d < 4; d++) {
                int dx = n.x + dir[d][0];
                int dy = n.y + dir[d][1];
                if(isIn(dx, dy) && !visited[dx][dy]) {
                    visited[dx][dy] = true;
                    if(arr[dx][dy] == 0 || arr[dx][dy] == 2) {
                        arr[dx][dy] = 2;
                        air.add(new Node(dx, dy));
                    }
                    else if(arr[dx][dy] == 1){
                        cheeze.add(new Node(dx, dy));
                    }
                }
            }
        }
//        print();
        check(cheeze);
    }
    static void check(Queue<Node> cheeze) {
        Queue<Node> remain = new LinkedList<>();
        while(!cheeze.isEmpty()) {
            Node n = cheeze.poll();
            int cnt = 0;
            for(int d = 0; d < 4; d++) {
                int dx = n.x + dir[d][0];
                int dy = n.y + dir[d][1];
                if(isIn(dx, dy) && arr[dx][dy] == 2)
                    cnt++;
            }
            if(cnt >= 2) {
                remain.add(n);
            }
        }
        count -= remain.size();
        while(!remain.isEmpty()) {
            Node n = remain.poll();
            arr[n.x][n.y] = 2;
        }
        time++;
    }
    static void print() {
        for(int i = 0; i < N; i++)
            System.out.println(Arrays.toString(arr[i]));
        System.out.println();
    }
    /*
    1. 바깥에서부터 접근해서 공기와 접촉하는 치즈를 구한다.
    2. 접촉한 치즈가 공기와 두 변 이상이 접촉하는지 확인한다.
    3. 두 변 이상 접촉한 치즈의 값을 없앤후 1부터 다시
     */
}
