package net.acmicpc;

import java.util.*;

public class DFS와BFS {
    //    public static void main(String[] args) {
    static List<Integer>[] list;
    static boolean[] check;
    public DFS와BFS() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int V = sc.nextInt();
        int[][] arr = new int[M][2];
        check = new boolean[N + 1];
        list = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for(int i = 0; i < M; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
            list[arr[i][0]].add(arr[i][1]);
            list[arr[i][1]].add(arr[i][0]);
        }
        for(int i = 1; i <= N; i++) {
            Collections.sort(list[i]);
        }
        dfs(V);
        System.out.println();
        Arrays.fill(check, false);

        bfs(V);
        System.out.println();

        sc.close();
    }

    public static void dfs(int start) {
        //지난 정점일 때는 return하고
        if(check[start]) {
            return;
        }
        //지나지 않았을 때는 true로 체크한 후
        check[start] = true;
        System.out.print(start+" ");
        for(int l : list[start]) {
            //연결된 값중에서 지나지 않은 값을 지나도록 한다.
            if(!check[l]) {
                dfs(l);
            }
        }
    }

    public static void bfs(int start) {
        Queue<Integer> que = new LinkedList<>();
        //처음에 지나는 값을 넣고 true로 만든 후
        que.add(start);
        check[start] = true;

        //끝까지 갔다가 돌아오는 동안
        while(!que.isEmpty()) {
            //지나가는 지점을 출력
            int x = que.poll();
            System.out.print(x+" ");
            //간선중에서 지나지 않은 점을 que에 추가
            for(int l : list[x]) {
                if(!check[l]) {
                    check[l] = true;
                    que.add(l);
                }
            }
        }
    }
}
