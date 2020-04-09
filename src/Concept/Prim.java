package Concept;

import java.util.*;

public class Prim {
    static int N;
    static int result;
    static double[][] dist;
    static boolean[][] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t <= T; t++) {
            N = sc.nextInt();
            result = 0;
            int[][] map = new int[N][2];
            for(int i = 0; i < 2; i++) {
                for(int j = 0; j < N; j++) {
                    map[j][i] = sc.nextInt();
                }
            }
            double E = sc.nextDouble();
            dist = new double[N][N];
            visited = new boolean[N][N];
            for(int i = 0; i < N-1; i++) {
                for(int j = i+1; j < N; j++) {
                    dist[i][j] = dist[j][i] = E*(map[i][0] - map[j][0]) * (map[i][0] - map[j][0]) + E*(map[i][1] - map[j][1]) * (map[i][1] - map[j][1]);
                }
            }
            System.out.println("#"+t+" "+result);
        }
    }
    static class Node {
        int x;
        int y;
        int v;
        Node(int x, int y, int v){
            this.x = x;
            this.y = y;
            this.v = v;
        }
    }
    public static void prim() {
        //우선 순위에서 순위를 설정하는 Comparator가 구현됨.
        PriorityQueue<Node> que = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.v > o2.v ? 1 : -1;
            }
        });
        //정점을 방문하는데 쓰는 큐
        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(1);
        ArrayList<Node> tempList;
        Node tempNode;
    }
}
