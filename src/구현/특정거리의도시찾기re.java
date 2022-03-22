package 구현;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/18352
public class 특정거리의도시찾기re {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        // 도시
        int N = Integer.parseInt(token.nextToken());
        // 도로
        int M = Integer.parseInt(token.nextToken());
        // 거리정보
        int K = Integer.parseInt(token.nextToken());
        // 출발
        int X = Integer.parseInt(token.nextToken());
        int[] distance = new int[N+1];
        boolean[] visited = new boolean[N+1];
        List<Integer>[] list = new ArrayList[N+1];
        for(int i = 0; i <= N; i++)
            list[i] = new ArrayList<>();
        Arrays.fill(distance, 12345567);
        Arrays.fill(visited, false);
        distance[X] = 0;
        for(int i = 0; i < M; i++) {
            token = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(token.nextToken());
            int n2 = Integer.parseInt(token.nextToken());
            list[n1].add(n2);
        }
        Queue<Integer> que = new LinkedList<>();
        que.add(X);
        while(!que.isEmpty()) {
            int n = que.poll();
            if(visited[n])
                continue;
            visited[n] = true;
            for(int i : list[n]) {
                if(!visited[i] && distance[n]+1 < distance[i]) {
                    distance[i] = distance[n]+1;
                    que.add(i);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++) {
            if(distance[i] == K)
                sb.append(i).append("\n");
        }
        System.out.print(sb.toString().length() == 0 ? -1 : sb);
    }
}
