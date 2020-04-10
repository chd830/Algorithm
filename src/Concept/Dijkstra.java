package Concept;

import java.util.Arrays;
import java.util.Scanner;

public class Dijkstra {
    public static void  main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        int[][] adj = new int[V][V];
        for(int i = 0; i < E; i++) {
            adj[sc.nextInt()][sc.nextInt()] = sc.nextInt();
        }
        int[] D = new int[V];
        Arrays.fill(D, Integer.MAX_VALUE);
        boolean[] check = new boolean[V];
        //시작점
        int start = 0;
        D[start] = 0;
        for(int i = 0; i < V-1; i++) {
            //가장 작은 값을 기억
            int min = Integer.MAX_VALUE;
            //가장 작은 값의 위치
            int idx = -1;
            for(int j = 0; j < V; j++) {
                if(!check[j] && min > D[j]) {
                    min = D[j];
                    idx = j;
                }
            }
            if(idx == -1) {
                break;
            }
            //새로운 친구로부터 갈 수 있는 경로들을 업데이트
            for(int j = 0; j < V; j++) {
                //처리하지 않았으면서 경로가 존재하고 idx까지의 거리(D[j])+idx부터 j까지의 거리(adj[idx][j])가 D[j]보다 작다면 업데이트
                if(!check[j] && adj[idx][j] != 0 && D[idx]+adj[idx][j] < D[j]) {
                    D[j] = D[idx] + adj[idx][j];
                }
            }
            //처리된 놈으로 체크
            check[idx] = true;
        }
        System.out.println(Arrays.toString(D));
    }
}
