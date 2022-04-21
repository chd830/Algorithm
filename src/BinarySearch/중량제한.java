package BinarySearch;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1939
public class 중량제한 {
    static class Node {
        int x;
        int val;
        Node(int x, int val) {
            this.x = x;
            this.val = val;
        }
    }
    static int N;
    static List<Node>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());
        list = new ArrayList[100001];
        for(int i = 0; i < 100001; i++)
            list[i] = new ArrayList<>();
        int min = 0;
        int max = 0;
        for(int i = 0; i < M; i++) {
            token = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(token.nextToken());
            int B = Integer.parseInt(token.nextToken());
            int val = Integer.parseInt(token.nextToken());
            list[A].add(new Node(B, val));
            list[B].add(new Node(A, val));
            max = Math.max(max, val);
        }
        token = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(token.nextToken());
        int end = Integer.parseInt(token.nextToken());
        loop: while(min <= max) {
            int mid = (min+max)/2;
            // BFS를 호출하여 시작부터 도착까지 운반가능할때 min을 업데이트
            Queue<Integer> que = new LinkedList<>();
            que.add(start);
            boolean[] visited = new boolean[N+1];
            visited[start] = true;
            while(!que.isEmpty()) {
                int n = que.poll();
                if(n == end) {
                    min = mid + 1;
                    continue loop;
                }
                for(Node next : list[n]) {
                    if(!visited[next.x] && mid <= next.val) {
                        visited[next.x] = true;
                        que.add(next.x);
                    }
                }
            }
            // 운반 불가능할 때 max를 업데이트
            max = mid-1;
        }
        System.out.println(max);
    }
}
/*
4 4
1 2 3
4 2 1
2 3 2
1 3 1
1 4
 */