package net.acmicpc;

import java.util.*;

public class 미로탐색 {
    static int N;
    static int M;
    static int cnt;
    static int[][] map;
    static boolean[][] visited;
    //    public static void main(String[] args) {
    public 미로탐색() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        cnt = 0;
//        min = Integer.MAX_VALUE;
        map = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];
        for(int i = 0; i < N; i++) {
            String str = sc.next();
            for(int j = 0; j < str.length(); j++) {
                map[i+1][j+1] = Integer.parseInt("" +str.charAt(j));
            }
        }
//        for(int i = 0; i < N; i++) {
//            System.out.println(Arrays.toString(map[i]));
//        }
//        System.out.println();
        bfs(1, 1);
//        for(int i = 0; i <= N; i++) {
//            System.out.println(Arrays.toString(map[i]));
//        }
        System.out.println(map[N][M]);
    }
    public static void bfs(int x, int y) {
        Queue<int[]> que = new LinkedList();
        que.add(new int[] {x, y});

        while(!que.isEmpty()) {
            int[] arr = que.poll();
            visited[arr[0]][arr[1]] = true;
            if(arr[0] > 1 && map[arr[0]-1][arr[1]] >= 1 && !visited[arr[0]-1][arr[1]]) {
                que.add(new int[] {arr[0]-1, arr[1]});
                map[arr[0]-1][arr[1]] = map[arr[0]][arr[1]]+1;
                visited[arr[0]-1][arr[1]] = true;
            }
            if(arr[0] < N && map[arr[0]+1][arr[1]] >= 1 && !visited[arr[0]+1][arr[1]]) {
                que.add(new int[] {arr[0]+1, arr[1]});
                map[arr[0]+1][arr[1]] = map[arr[0]][arr[1]]+1;
                visited[arr[0]+1][arr[1]] = true;
            }
            if(arr[1] > 1 && map[arr[0]][arr[1]-1] >= 1 && !visited[arr[0]][arr[1]-1]) {
                que.add(new int[] {arr[0], arr[1]-1});
                map[arr[0]][arr[1]-1] = map[arr[0]][arr[1]]+1;
                visited[arr[0]][arr[1]-1] = true;
            }
            if(arr[1] < M && map[arr[0]][arr[1]+1] >= 1 && !visited[arr[0]][arr[1]+1]) {
                que.add(new int[] {arr[0], arr[1]+1});
                map[arr[0]][arr[1]+1] = map[arr[0]][arr[1]]+1;
                visited[arr[0]][arr[1]+1] = true;
            }
//            for(int i = 0; i <= N; i++) {
//                System.out.println(Arrays.toString(map[i]));
//            }
//            System.out.println();
        }
    }
//    public static void dfs(int x, int y, int value) {
//        if(x == N && y == M) {
//            if(min > value ) {
//                min = value;
//            }
//            return;
//        }
//        System.out.print("("+x+", "+y+") ");
//        visited[x][y] = true;
//        if(x > 1 && map[x-1][y] == '1' && !visited[x-1][y]) {
//            dfs(x-1, y, value+1);
//        }
//        if(x < N && map[x+1][y] == '1' && !visited[x+1][y]) {
//            dfs(x+1, y, value+1);
//        }
//        if(y > 1 && map[x][y-1] == '1' && !visited[x][y-1]) {
//            dfs(x, y-1, value+1);
//        }
//        if(y < M && map[x][y+1] == '1' && !visited[x][y+1]) {
//            dfs(x, y+1, value+1);
//        }
//    }
}
