package Concept;

import java.util.Arrays;
import java.util.Scanner;

public class PrimRe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt(); //정점
        int E = sc.nextInt(); //간선
        int[][] adj = new int[V][V];
        //간선의 정보 입력
        for(int i = 0; i < E; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            adj[a][b] = c;
            adj[b][a] = c;
        }
        boolean[] check = new boolean[V];
        int[] key = new int[V]; //선택된 정점들로 도달할 수 있는 최소거리
        int[] p = new int[V]; //최소 신장트리의 구조 저장
        Arrays.fill(key, Integer.MAX_VALUE);

        //아무거나 선택(처음선택되는 친구가 루트. 부모없이 길이 0)
        p[0] = -1;
        key[0] = 0;
        //이미 하나 골랐으니 V-1개 고르기
        for(int i = 0; i < V-1; i++) {
            int min = Integer.MAX_VALUE;
            //안골라진 친구들 중에서 key가 제일 작은친구 고르기
            int idx = -1;
            for(int j = 0 ;j < V; j++) {
                if(!check[j] && key[j] < min) {
                    idx = j;
                    min = key[j];
                }
            }
            //idx: 선택이 안된 정점 중 key가 제일 작은 친구가 들어잇다
            check[idx] = true;
            //idx정점에서 출발하는 모든 간선에 대해서 key를 업데이트
            for(int j = 0; j < V; j++) {
                //check가 안되있으면서, 간선은 존재하고, 간선이 key값보다 작다면 key값을 업데이트
                if(!check[j] && adj[idx][j] != 0 && key[j] > adj[idx][j]) {
                    p[j] = idx;
                    key[j] = adj[idx][j];
                }
            }
        }
        int result = 0;
        for(int i = 0; i < V; i++) {
            result += key[i];
        }
        System.out.println(result);
        System.out.println(Arrays.toString(p));
    }
}
