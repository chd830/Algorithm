package Concept;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Kruskal {
    static int[] parents;
    static int[] rank;
    //첫줄에 정점의 갯수와 간선의 갯수가 들어옴
    //간선의 정보가 정점1 정점2 가중치로 간선의 개수만큼 들어옴
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        int[][] edges = new int[E][3];
        for(int i = 0; i < E; i++) {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
            edges[i][2] = sc.nextInt();
        }
        //간선들을 오름차순으로 정렬
        Arrays.sort(edges, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                //return o1[2]-o2[2]; 빼거나 더할때 오버플로우가 날수도있다
                return Integer.compare(o1[2], o2[2]);
            }
        });
        for(int i = 0; i < V; i++) {
            makeSet(i);
        }
        //정점의 개수 -1번 반복
        int cnt = 0;
        int result = 0;
        for(int i = 0; i < E; i--) {
            int a = findSet(edges[i][0]);
            int b = findSet(edges[i][1]);
            if(a == b) {
                continue;
            }
            //간선을 선택
            union(a, b);
            result += edges[i][2];
            cnt++;
            //정점의 갯수-1만큼 반복하면 그만
            if(cnt == V-1) {
                break;
            }
        }
        System.out.println(result);

        //간선이 연결하는 두 정점이 같은 팀이 아니라면 한 팀으로 합쳐주고 간선 선택
        //같은팀이라면 패스

    }
    static void makeSet(int x) {
        parents[x] = x;
    }

    static int findSet(int x) {
        if(x == parents[x]) {
            return x;
        }
        else {
            return findSet(parents[x]);
        }
    }

    static void union(int x, int y) {
        int px = findSet(x);
        int py = findSet(y);

        if(rank[px] > rank[py]) {
            parents[py] = px;
        }
        else {
            parents[px] = py;
            if(rank[px] == rank[py]) {
                rank[py]++;
            }
        }
    }
}
