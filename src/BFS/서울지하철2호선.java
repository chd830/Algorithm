package BFS;

import java.util.*;
import java.io.*;

public class 서울지하철2호선 {
    static class Node {
        int val;
        int count;
        Node(int val, int count) {
            this.val = val;
            this.count = count;
        }
    }
    static boolean[] visited;
    static List<Integer>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        list = new ArrayList[N+1];
        visited = new boolean[N+1];
        StringTokenizer token = null;
        for(int i = 0; i <= N; i++)
            list[i] = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(token.nextToken());
            int n2 = Integer.parseInt(token.nextToken());
            list[n1].add(n2);
            list[n2].add(n1);
        }
        // 순환선 찾기(DFS)
        for(int i = 1; i <= N; i++) {
            if(dfs(i, i, i))
                break;
        }
        // 경로와 순환선 사이의 거리 구하기(BFS)
        for(int i = 1; i <= N; i++) {
            boolean[] check = new boolean[N+1];
            check[i] = true;
            Queue<Node> que = new LinkedList<>();
            que.add(new Node(i, 0));
            while(!que.isEmpty()) {
                Node num = que.poll();
                if(visited[num.val]) {
                    System.out.print(num.count + " ");
                    break;
                }
                for(int n : list[num.val]) {
                    if(!check[n]) {
                        check[n] = true;
                        que.add(new Node(n, num.count+1));
                    }
                }
            }
        }
    }
    // 이전노드, 현재노드, 시작노드
    static boolean dfs(int prev, int node, int start) {
        visited[node] = true;
        for(int next : list[node]) {
            if(!visited[next]) {
                if(dfs(node, next, start))
                    return true;
            }
            else if(next != prev && next == start) {
                return true;
            }
        }
        visited[node] = false;
        return false;
    }
}