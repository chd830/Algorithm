package net.acmicpc;

import java.util.*;

public class 미로탐색 {
    static int N;
    static int M;
    static int[][] map;
    static int[][] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];
        for(int i = 0; i < N; i++) {
            String str = sc.next();
            for(int j = 0; j < str.length(); j++) {
                map[i][j] = str.charAt(j) - 48;
            }
        }
        arr = new int[N][M];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] == 1 && arr[i][j]  == 0) {
                    bfs(i, j);
                }
            }
        }
        System.out.println(arr[N-1][M-1]);
    }
    static int[][] pos = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static void bfs(int x, int y) {
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(x, y));
        arr[x][y] = 1;
        while(!que.isEmpty()) {
            Node n = que.poll();
            for(int i = 0; i < 4; i++) {
                int dx = n.x + pos[i][0];
                int dy = n.y + pos[i][1];
                if(dx >= 0 && dy >= 0 && dx < N && dy < M && map[dx][dy] == 1 && arr[dx][dy] == 0) {
                    que.add(new Node(dx, dy));
                    arr[dx][dy] = arr[n.x][n.y]+1;
                }
            }
        }
    }
}
//    static int W;
//    static int M;
//    static int island;
//    static int[][] dist;
//    static boolean[][] visited1;
//    //    public static void main(String[] args) {
//    public 미로탐색() {
//        Scanner sc = new Scanner(System.in);
//        W = sc.nextInt();
//        M = sc.nextInt();
//        island = 0;
////        min = Integer.MAX_VALUE;
//        dist = new int[W+1][M+1];
//        visited1 = new boolean[W+1][M+1];
//        for(int i = 0; i < W; i++) {
//            String str = sc.next();
//            for(int j = 0; j < str.length(); j++) {
//                dist[i+1][j+1] = Integer.parseInt("" +str.charAt(j));
//            }
//        }
////        for(int i = 0; i < W; i++) {
////            System.out.println(Arrays.toString(dist[i]));
////        }
////        System.out.println();
//        bfs(1, 1);
////        for(int i = 0; i <= W; i++) {
////            System.out.println(Arrays.toString(dist[i]));
////        }
//        System.out.println(dist[W][M]);
//    }
//    public static void bfs(int left, int right) {
//        Queue<int[]> que = new LinkedList();
//        que.add(new int[] {left, right});
//
//        while(!que.isEmpty()) {
//            int[] visited1 = que.poll();
//            visited1[visited1[0]][visited1[1]] = true;
//            if(visited1[0] > 1 && dist[visited1[0]-1][visited1[1]] >= 1 && !visited1[visited1[0]-1][visited1[1]]) {
//                que.add(new int[] {visited1[0]-1, visited1[1]});
//                dist[visited1[0]-1][visited1[1]] = dist[visited1[0]][visited1[1]]+1;
//                visited1[visited1[0]-1][visited1[1]] = true;
//            }
//            if(visited1[0] < W && dist[visited1[0]+1][visited1[1]] >= 1 && !visited1[visited1[0]+1][visited1[1]]) {
//                que.add(new int[] {visited1[0]+1, visited1[1]});
//                dist[visited1[0]+1][visited1[1]] = dist[visited1[0]][visited1[1]]+1;
//                visited1[visited1[0]+1][visited1[1]] = true;
//            }
//            if(visited1[1] > 1 && dist[visited1[0]][visited1[1]-1] >= 1 && !visited1[visited1[0]][visited1[1]-1]) {
//                que.add(new int[] {visited1[0], visited1[1]-1});
//                dist[visited1[0]][visited1[1]-1] = dist[visited1[0]][visited1[1]]+1;
//                visited1[visited1[0]][visited1[1]-1] = true;
//            }
//            if(visited1[1] < M && dist[visited1[0]][visited1[1]+1] >= 1 && !visited1[visited1[0]][visited1[1]+1]) {
//                que.add(new int[] {visited1[0], visited1[1]+1});
//                dist[visited1[0]][visited1[1]+1] = dist[visited1[0]][visited1[1]]+1;
//                visited1[visited1[0]][visited1[1]+1] = true;
//            }
////            for(int i = 0; i <= W; i++) {
////                System.out.println(Arrays.toString(dist[i]));
////            }
////            System.out.println();
//        }
//    }
////    public static void dfs(int left, int right, int items) {
////        if(left == W && right == M) {
////            if(min > items ) {
////                min = items;
////            }
////            return;
////        }
////        System.out.print("("+left+", "+right+") ");
////        visited1[left][right] = true;
////        if(left > 1 && dist[left-1][right] == '1' && !visited1[left-1][right]) {
////            dfs(left-1, right, items+1);
////        }
////        if(left < W && dist[left+1][right] == '1' && !visited1[left+1][right]) {
////            dfs(left+1, right, items+1);
////        }
////        if(right > 1 && dist[left][right-1] == '1' && !visited1[left][right-1]) {
////            dfs(left, right-1, items+1);
////        }
////        if(right < M && dist[left][right+1] == '1' && !visited1[left][right+1]) {
////            dfs(left, right+1, items+1);
////        }
////    }
//}
