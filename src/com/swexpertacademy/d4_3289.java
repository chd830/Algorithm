package com.swexpertacademy;

import java.io.*;
import java.util.*;

//서로소 집합
public class d4_3289 {
    static int n;
    static int m;
    static int[] parents;
    static int[] rank;
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++) {
            sb.append("#").append(tc).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            parents = new int[N+1];
            rank = new int[N+1];
            for(int i = 1; i <= N; i++)
                parents[i] = i;
            for(int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());//명령 집합1 집합2
                int oper = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                switch (oper) {
                    case 0:
                        union(a, b);
                        break;
                    case 1:
                        if( find(a) == find(b))
                            sb.append(1);
                        else
                            sb.append(0);
                        break;
                }
            }
        }
        System.out.println(sb.toString());

//        Scanner sc = new Scanner(System.in);
//        int T = sc.nextInt();
//        for(int t = 1; t <= T; t++) {
//            StringBuilder sb = new StringBuilder();
//            int n = sc.nextInt();
//            int m = sc.nextInt();
//            parents = new int[n+1];
//            rank = new int[n+1];
//            for(int i = 0; i <= n; i++) {
//                parents[i] = i;
//            }
//            for(int i = 0; i < m; i++) {
//                switch(sc.nextInt()) {
//                    case 0:
//                        int a = sc.nextInt();
//                        int b = sc.nextInt();
//                        union(a, b);
//                        break;
//                    case 1:
//                        a = sc.nextInt();
//                        b = sc.nextInt();
//                        if(find(a) == find(b)) {
//                            sb.append(1);
////                            System.out.print(1);
//                        }
//                        else {
//                            sb.append(0);
////                            System.out.print(0);
//                        }
//                }
//            }
//            System.out.print("#"+t+" "+sb.toString());
//        }
    }

    static int find(int x) {
        if (x == parents[x])
            return x;
        else
            parents[x] = find(parents[x]);
        return parents[x];
    }
    static void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if( rank[px] > rank[py]) {
            parents[py] = px;
        }
        else if(rank[px] < rank[py] ) {
            parents[px] = py;
        }
        else {
            rank[px]++;
            parents[py] = px;
        }
    }
}