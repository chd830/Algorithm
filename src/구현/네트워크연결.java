package 구현;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1922
public class 네트워크연결 {
    static class Computer implements Comparable<Computer> {
        int vertex;
        int dist;
        Computer(int vertex, int val) {
            this.vertex = vertex;
            this.dist = val;
        }

        @Override
        public String toString() {
            return "Computer{" +
                    ", to=" + vertex +
                    ", val=" + dist +
                    '}';
        }

        @Override
        public int compareTo(Computer o) {
            return Integer.compare(this.dist, o.dist);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        // 모든 거리로 가는 최단거리.
        StringTokenizer token = null;
        List<Computer>[] list = new ArrayList[N+1];
        for(int i = 0; i <= N; i++)
            list[i] = new ArrayList<>();
        for(int i = 0; i < M; i++) {
            token = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(token.nextToken());
            int to = Integer.parseInt(token.nextToken());
            int val = Integer.parseInt(token.nextToken());
            list[from].add(new Computer(to, val));
            list[to].add(new Computer(from, val));
        }
        int[] distance = new int[N+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[1] = 0;
        boolean[] visited = new boolean[N+1];
        visited[1] = true;
        int sum = 0;
        int cnt = 1;
        while(cnt != N) {
            Computer min = null;
            for(int i = 1; i <= N; i++) {
                if(visited[i]) {
                    for(Computer node : list[i]) {
                        if(!visited[node.vertex]) {
                            if (min == null) {
                                min = node;
                            } else {
                                if (min.dist > node.dist)
                                    min = node;
                            }
                        }
                    }
                }
            }
            visited[min.vertex] = true;
            sum += min.dist;
            cnt++;
        }
        System.out.println(sum);
    }
}
