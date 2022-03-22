package Study;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 다익스트라 {
    static final int INF = 1234567;
    static int N;
    static int[][] maps;

    static class Node implements Comparable<Node> {
        int weight;
        int idx;

        Node(int weight, int idx) {
            this.weight = weight;
            this.idx = idx;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    static void set(int x, int y, int weight) {
        maps[x][y] = weight;
        maps[y][x] = weight;
    }

    public static void main(String[] args) {
        N = 6;
        maps = new int[N][N];
        for (int i = 0; i < N; i++)
            Arrays.fill(maps[i], INF);


        set(0, 1, 7);
        set(0, 2, 9);
        set(0, 5, 14);
        set(1, 2, 10);
        set(1, 3, 15);
        set(2, 3, 11);
        set(2, 5, 2);
        set(3, 4, 6);
        set(4, 5, 9);


        int v = 0;
        PriorityQueue<Node> que = new PriorityQueue<>();
        boolean[] check = new boolean[N];
        int distance[] = new int[N];
        for (int i = 0; i < N; ++i) {
            distance[i] = INF;
        }
        // 시작점 추가 및 기본값 0으로 초기화
        que.add(new Node(v, 0));
        distance[v] = 0;
        check[v] = true;

        // 첫 시작점에서 갈 수 있는 위치 큐에 추가하기
        for (int i = 0; i < N; ++i) {
            if (!check[i] && maps[v][i] != INF) {
                distance[i] = maps[v][i];
                que.add(new Node(maps[v][i], i));
            }
        }
        while (!que.isEmpty()) {
            int curWeight = Integer.MAX_VALUE;
            int curIdx = -1;
            Node Node = que.poll();
            curWeight = Node.weight;
            curIdx = Node.idx;
            check[curIdx] = true;

            for (int i = 0; i < N; ++i) {
                // 방문하지 않았고 방문할 수 있는 지점이
                if (!check[i] && maps[curIdx][i] != INF) {
                    // 현재거리+현재거리 가 지금까지 온 거리보다 짧을 때 변경 및 que에 추가
                    if (distance[curIdx] + maps[curIdx][i] < distance[i]) {
                        distance[i] = distance[curIdx] + maps[curIdx][i];
                        que.add(new Node(distance[i], i));
                    }
                }
            }
            for (int i = 0; i < N; ++i) {
                if (distance[i] == INF) System.out.print("∞ ");
                else System.out.print(distance[i] + " ");
            }
            System.out.println("");
        }
    }
}
