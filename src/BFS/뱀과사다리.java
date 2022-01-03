package BFS;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/16928
public class 뱀과사다리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        // 사다리의 수
        int N = Integer.parseInt(token.nextToken());
        // 뱀의 수
        int M = Integer.parseInt(token.nextToken());
        HashMap<Integer, Integer> next = new HashMap<>();
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            next.put(Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken()));
        }
        for(int i = 0; i < M; i++) {
            token = new StringTokenizer(br.readLine());
            next.put(Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken()));
        }
        int[] arr = new int[101];
        boolean[] visited = new boolean[101];
        Queue<Integer> que = new LinkedList<>();
        que.add(1);
        arr[1] = 0;
        visited[1] = true;
        while(!que.isEmpty()) {
            int n = que.poll();
            if(n == 100)
                break;
            for(int i = 1; i <= 6; i++) {
                int x = n+i;
                if(x > 100)
                    continue;
                if(visited[x])
                    continue;
                visited[x] = true;
                if(next.containsKey(x) && !visited[next.get(x)]) {
                    visited[next.get(x)] = true;
                    arr[next.get(x)] = arr[n]+1;
                    que.add(next.get(x));
                }
                else {
                    que.add(x);
                    arr[x] = arr[n]+1;
                }
            }
        }
        System.out.println(arr[100]);
    }
}