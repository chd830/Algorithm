package 구현;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/2564
public class 경비원 {
    static class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    // 1 북 2 남 3 서 4 동
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(token.nextToken());
        int N = Integer.parseInt(token.nextToken());
        int[][] arr = new int[N+1][M+1];
        int n = Integer.parseInt(br.readLine());
        Node[] shops = new Node[n];
        for(int i = 0; i <= N; i++)
            Arrays.fill(arr[i], Integer.MAX_VALUE);
        for(int i = 0; i < n; i++) {
            token = new StringTokenizer(br.readLine());
            int direction = Integer.parseInt(token.nextToken());
            int position = Integer.parseInt(token.nextToken());
            switch (direction) {
                case 1:
                    shops[i] = new Node(0, position);
                    arr[0][position] = -1;
                    break;
                case 2:
                    shops[i] = new Node(N, position);
                    arr[N][position] = -1;
                    break;
                case 3:
                    shops[i] = new Node(position, 0);
                    arr[position][0] = -1;
                    break;
                case 4:
                    shops[i] = new Node(position, M);
                    arr[position][M] = -1;
                    break;
            }
        }
        token = new StringTokenizer(br.readLine());
        Node start = null;
        switch (Integer.parseInt(token.nextToken())) {
            case 1:
                start = new Node(0, Integer.parseInt(token.nextToken()));
                break;
            case 2:
                start = new Node(N, Integer.parseInt(token.nextToken()));
                break;
            case 3:
                start = new Node(Integer.parseInt(token.nextToken()), 0);
                break;
            case 4:
                start = new Node(Integer.parseInt(token.nextToken()), M);
                break;
        }
        Queue<Node> que = new LinkedList<>();
        que.add(start);
        arr[start.x][start.y] = 0;
        while(!que.isEmpty()) {
            Node node = que.poll();
            for(int d = 0; d < 4; d++) {
                int dx = node.x + dir[d][0];
                int dy = node.y + dir[d][1];
                if((dx >= 0 && dy >= 0 && dx <= N && dy <= M) && (dx == 0 || dy == 0 || dx == N || dy == M)) {
                    if(arr[dx][dy] == -1 || arr[dx][dy] > arr[node.x][node.y]+1) {
                        arr[dx][dy] = arr[node.x][node.y]+1;
                        que.add(new Node(dx, dy));
                    }
                }
            }
        }
        int answer = 0;
        for(int i = 0; i < n; i++) {
            answer += arr[shops[i].x][shops[i].y];
        }
//        for(int i = 0; i <= N; i++) {
//            for(int j = 0; j <= M; j++) {
//                System.out.print(arr[i][j] == Integer.MAX_VALUE ? "\t" : arr[i][j]+"\t");
//            }
//            System.out.println();
//        }
        System.out.println(answer);
    }
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
}
