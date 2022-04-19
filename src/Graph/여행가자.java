package Graph;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1976
// 유니온파인드
public class 여행가자 {
    static int N;
    static int M;
    static int[] cities;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        cities = new int[M];
        StringTokenizer token = null;
        for(int i = 0; i < parents.length; i++)
            parents[i] = i;

        for(int i = 1; i <= N; i++) {
            token = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                int flag = Integer.parseInt(token.nextToken());
                if(flag == 1)
                    union(i, j);
            }
        }

        token = new StringTokenizer(br.readLine());
        // 각 노드의 최고 부모노드(start)가 전부 같으면 노드가 연결되어 있음.
        int start = find(Integer.parseInt(token.nextToken()));
        for(int i = 1; i < M; i++) {
            int now = Integer.parseInt(token.nextToken());
            if(start != find(now)) {
                System.out.println("NO");
                System.exit(0);
            }
        }
        System.out.println("YES");
    }
    static int[] parents = new int[201];
    static int find(int x) {
        if(x == parents[x])
            return x;
        return parents[x] = find(parents[x]);
    }
    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if(x != y) {
            if(x < y)
                parents[y] = x;
            else
                parents[x] = y;
        }

    }
}
