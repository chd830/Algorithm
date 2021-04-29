package review;

import java.util.*;
import java.io.*;

// 서울 지하철 2호선
public class acmicpc16947 {
    static List<Integer>[] list;
    static boolean[] cycle;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        list = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        StringTokenizer token = null;
        for (int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        cycle = new boolean[N+1];
        // 순환이 되는 지점을 찾기
        for (int i = 1; i <= N; i++) {
            if(isCycle(i, i, i))
                break;
            else
                cycle = new boolean[N+1];
        }
        int[] res = new int[N+1];
        for(int i = 1; i <= N; i++) {
            boolean[] visited = new boolean[N+1];
            Queue<Node> que = new LinkedList<>();
            que.add(new Node(i, 0));
            visited[i] = true;
            while(!que.isEmpty()) {
                Node n = que.poll();
                if(cycle[n.v]) {
                    res[i] = n.cnt;
                    break;
                }
                for(int j : list[n.v]) {
                    if(!visited[j]) {
                        visited[j] = true;
                        que.add(new Node(j, n.cnt + 1));
                    }
                }
            }
        }
        for(int i = 1; i <= N; i++)
            System.out.print(res[i]+" ");
    }
    static class Node {
        int v;
        int cnt;
        Node(int v, int cnt) {
            this.v = v;
            this.cnt = cnt;
        }
    }
    static boolean isCycle(int before, int v, int start) {
        cycle[v] = true;
        for(int i : list[v]) {
            if(!cycle[i]) {
                if(isCycle(v, i, start)) {
                    return true;
                }
            }
            else if(i != before && i == start)
                return true;
        }
        cycle[v] = false;
        return false;
    }
}
