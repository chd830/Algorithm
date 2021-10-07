package 구현;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/16236
public class 아기상어 {
    static class Node implements Comparable<Node> {
        int x;
        int y;
        int val;
        int dist;
        Node(int x, int y, int val, int dist) {
            this.x = x;
            this.y = y;
            this.val = val;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            if(this.val == o.val) {
                if(this.dist == o.dist)
                    return Integer.compare(this.y, o.y);
                return Integer.compare(this.dist, o.dist);
            }
            return Integer.compare(this.val, o.val);
        }
    }
    static int N;
    static int[][] arr;
    static Node shark;
    static PriorityQueue<Node> que;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        StringTokenizer token = null;
        shark = null;
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(token.nextToken());
                if(arr[i][j] == 9)
                    shark = new Node(i, j, arr[i][j], 0);
            }
        }
        for(int i = 0 ;i < N; i++)
            System.out.println(Arrays.toString(arr[i]));
        System.out.println();
        setFish();
        int size = 2;
        int count = 0;
        int time = 0;
        while(!que.isEmpty() && size > que.peek().val) {
            Node n = que.poll();
            count++;
            boolean[][] visited = new boolean[N][N];
            Queue<Node> que = new LinkedList<>();
            que.add(shark);
            visited[shark.x][shark.y] = true;
            while(!que.isEmpty()) {
                Node q = que.poll();
                if(q.x == n.x && q.y == n.y) {
                    time += Math.abs(n.x-shark.x)+Math.abs(n.y-shark.y);
                    shark = new Node(q.x, q.y, 9, 0);
                    arr[q.x][q.y] = 9;
                    break;
                }
                for(int d = 0; d < 4; d++) {
                    int dx = q.x+dir[d][0];
                    int dy = q.y+dir[d][1];
                    if(dx >= 0 && dy >= 0 && dx < N && dy < N && !visited[dx][dy] && arr[dx][dy] <= size) {
                        visited[dx][dy] = true;
                        que.add(new Node(dx, dy, arr[dx][dy], 0));
                    }
                }

            }
            if(size == count) {
                size++;
                count = 0;
            }
            setFish();
        }
        System.out.println(time);

    }
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static void setFish() {
        que = new PriorityQueue<>();
        for(int i = 0; i < N; i++) {
            for(int j =0 ; j < N; j++) {
                if(arr[i][j] != 9 && arr[i][j] != 0)
                    que.add(new Node(i, j, arr[i][j], Math.abs(i-shark.x)+Math.abs(j-shark.y)));
            }
        }
    }
}
