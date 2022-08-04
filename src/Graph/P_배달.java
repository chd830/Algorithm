package Graph;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/12978
public class P_배달 {
    public static void main(String[] args) {
        System.out.println(solution(5, new int[][] {{1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}}, 3));
    }
    static int[] arr;
    static class Node {
        int x;
        int dist;
        Node(int x, int dist) {
            this.x = x;
            this.dist = dist;
        }
    }
    static List<Node>[] list;
    public static int solution(int N, int[][] road, int K) {
        list = new ArrayList[N+1];
        for(int i = 0; i <= N; i++)
            list[i] = new ArrayList<>();
        for(int[] r : road) {
            list[r[0]].add(new Node(r[1], r[2]));
            list[r[1]].add(new Node(r[0], r[2]));
        }
        int[] idx = new int[N+1];
        Arrays.fill(idx, Integer.MAX_VALUE);
        idx[1] = 0;
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(1, 0));
        while(!que.isEmpty()) {
            Node node = que.poll();
            for(Node n : list[node.x]) {
                System.out.println(node.x+" to\t"+n.x+"\t"+(idx[node.x]+n.dist));
                if((idx[n.x] == 0 || idx[n.x] > idx[node.x]+n.dist) && idx[node.x]+n.dist <= K) {
                    idx[n.x] = idx[node.x]+n.dist;
                    que.add(new Node(n.x, n.dist+node.dist));
                }
            }
        }
        int cnt = 0;
        for(int i = 1; i <= N; i++) {
            if(idx[i] != Integer.MAX_VALUE)
                cnt++;
        }
        System.out.println(Arrays.toString(idx));
        return cnt;
    }
}
