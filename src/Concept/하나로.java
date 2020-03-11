package Concept;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 하나로 {
    static StringBuilder sb = new StringBuilder();
    static int[][] isLands;
    //정점들 간의 거리 그래프
    static long[][] graph;
    static double E;
    static int T;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br = new BufferedReader(new StringReader(src));
        T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            sb.append("#"+t+" ");
            N = Integer.parseInt(br.readLine());
            StringTokenizer xToken = new StringTokenizer(br.readLine());
            StringTokenizer yToken = new StringTokenizer(br.readLine());
            isLands = new int[N][2];
            for(int i = 0; i < N; i++) {
                isLands[i] = new int[] {Integer.parseInt(xToken.nextToken()), Integer.parseInt(yToken.nextToken())};
            }
            E = Double.parseDouble(br.readLine());
            //입력된 자료를 기반으로 섬 간의 가중치 그래프 그리기
            graph = new long[N][N];
            int[] from, to;
            for(int i = 0; i < N; i++) {
                from = isLands[i];
                for(int j = i+1; j < N; j++) {
                    to = isLands[j];
                    graph[i][j] = graph[j][i] = (from[0] - to[0]) * (from[0] - to[0]) + (from[1] - to[1]) * (from[1] - to[1]);
                }
            }
            double cost = prim(0) * E;
            sb.append(Math.round(cost)+"\n");
        }
        System.out.println(sb.toString());
    }
    static long prim(int start) {
        //MST에 들어가지 않은 녀석들
        PriorityQueue<Edge> que = new PriorityQueue<>();
        //모든 정점들을 관리
        Edge[] dynamicGraph = new Edge[N];
        for(int i = 0; i < dynamicGraph.length; i++) {
            dynamicGraph[i] = new Edge(i, Long.MAX_VALUE);
            if(i == start) {
                dynamicGraph[i].cost = 0;
            }
            que.add(dynamicGraph[i]);
        }
        long cost = 0;
        while(!que.isEmpty()) {
            Edge front = que.poll();
            cost += front.cost;

            for(int i = 0; i < dynamicGraph.length; i++) {
                Edge child = dynamicGraph[i];
                if(que.contains(child)) {
                    long tempCost = graph[front.idx][child.idx];
                    if(tempCost < child.cost) {
                        //child에 새 값을 넣어줘서 poll할 때 가장 작은 값을 나오게 해줌.
                        child.cost = tempCost;
                        que.remove(child);
                        que.add(child);
                    }
                }
            }
        }
        return 0;
    }

    static class Edge implements Comparable<Edge> {
        int idx;
        long cost;

        public Edge(int idx, long cost) {
            this.idx = idx;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "Edge[idx = "+idx+", cost = "+cost+"]";
        }

        @Override
        public int compareTo(Edge o) {
            return Long.compare(this.cost, o.cost);
        }
    }

    static String src="1\n" +
            "2\n" +
            "0 0\n" +
            "0 100\n" +
            "1.0\n" +
            "4\n" +
            "0 0 400 400\n" +
            "0 100 0 100\n" +
            "1.0\n" +
            "6\n" +
            "0 0 400 400 1000 2000\n" +
            "0 100 0 100 600 2000\n" +
            "0.3\n" +
            "9\n" +
            "567 5 45674 24 797 29 0 0 0\n" +
            "345352 5464 145346 54764 5875 0 3453 4545 123\n" +
            "0.0005";
}
