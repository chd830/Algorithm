package review;

import java.util.*;
import java.io.*;

public class 트리의지름 {
    static boolean[] visited;
    static List<Node>[] list;
    static int max;
    static int N;
    static class Node {
        int n;
        int weight;
        Node(int n, int weight) {
            this.n = n;
            this.weight = weight;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N+1];
        for(int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        StringTokenizer token = null;
        for(int i = 0; i < N-1; i++) {
            token = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(token.nextToken());
            int n2 = Integer.parseInt(token.nextToken());
            int n3 = Integer.parseInt(token.nextToken());
            list[n1].add(new Node(n2, n3));
            list[n2].add(new Node(n1, n3));
        }

        visited = new boolean[N+1];
        // 가장 긴 곳의 노드를 가져온다.
        Node n = getNode(1);
        visited = new boolean[N+1];
        // 가장 긴 곳의 노드를 시작으로 다른 가장 긴 곳까지의 노드가 트리의 지름이 된다.
        System.out.println(getNode(n.n).weight);

    }
    static Node getNode(int idx) {
        int num = 0;
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(idx, 0));
        visited[idx] = true;
        while(!que.isEmpty()) {
            Node q = que.poll();
            for(int i = 0; i < list[q.n].size(); i++) {
                Node node = list[q.n].get(i);
                if(!visited[node.n]) {
                    int sum = q.weight + node.weight;
                    que.add(new Node(node.n, sum));
                    if(max < sum) {
                        max = sum;
                        num = node.n;
                    }
                    visited[node.n] = true;
                }
            }
        }
        return new Node(num, max);
    }
}
