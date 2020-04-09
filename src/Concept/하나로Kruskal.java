package Concept;

import java.util.Arrays;
import java.util.Scanner;

public class 하나로Kruskal {
    static class Edges implements Comparable<Edges>{
        int v1;
        int v2;
        long cost;
        public Edges(int v1, int v2, long cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }
        @Override
        public int compareTo(Edges o) {
            // TODO Auto-generated method stub
            return Long.compare(this.cost, o.cost);
        }
    }
    static int[] parents;
    static int[] rank;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc = 1; tc <= T; tc++) {
            //정점의 갯수 (1≤N≤1,000)
            int N = sc.nextInt();

            //N개의 x,y좌표를 입력받아서 저장해둘 배열
            int[][] arr = new int[N][2];
            //x좌표
            for(int i = 0; i < N; i++)
                arr[i][0] = sc.nextInt();
            //y좌표
            for(int i = 0; i < N; i++)
                arr[i][1] = sc.nextInt();
            //세금
            double E = sc.nextDouble();

            //정점1 정점2 가중치
            Edges[] edges = new Edges[N*(N-1)/2];
            int cnt = 0;
            for(int i = 0; i < N - 1; i++) {
                for(int j = i+1; j < N; j++) {
                    edges[cnt] = new Edges(i, j, dist(arr[i][0], arr[j][0], arr[i][1], arr[j][1]));
                    cnt++;
                }
            }
            //정렬
            Arrays.sort(edges);
            //union find 연산을 위한 준비
            parents = new int[N];
            rank = new int[N];
            for(int i = 0; i < N; i++)
                makeSet(i);
            //크루스칼 동작
            long result = 0;
            cnt = 0;
            for(int i = 0; i < (N*(N-1)/2); i++) {
                int v1 = findSet(edges[i].v1);
                int v2 = findSet(edges[i].v2);
                if( v1 == v2 )
                    continue;
                result += edges[i].cost;
                union(v1, v2);
                cnt++;
                if( cnt == N-1 )
                    break;
            }
            System.out.println("#" + tc + " " + Math.round(result*E));
        }
    }
    static long dist( int x1, int x2, int y1, int y2) {
        return (long)(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));
    }

    static void makeSet(int x) {
        parents[x] = x;
    }
    static int findSet(int x) {
        if( x == parents[x] )
            return x;
        else {
            parents[x] = findSet(parents[x]);
            return parents[x];
        }
    }
    static void union(int x, int y) {
        int px = findSet(x);
        int py = findSet(y);
        if( rank[px] > rank[py] ) {
            parents[py] = px;
        }
        else {
            parents[px] = py;
            if( rank[px] == rank[py] ) {
                rank[py]++;
            }
        }
    }
}
