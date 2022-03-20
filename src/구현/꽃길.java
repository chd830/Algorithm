package 구현;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/14620
public class 꽃길 {
    static class Node {
        int x;
        int y;
        int val;
        Node(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
    static int N;
    static int min;
    static int[][] arr;
    static boolean[][] visited;
    static int[][] dir = {{0, 0}, {0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        min = Integer.MAX_VALUE;
        arr = new int[N+1][N+1];
        visited = new boolean[N+1][N+1];
        for(int i = 1; i <= N; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(token.nextToken());
            }
        }
//        dfs(1, 1, 0, 0);
        dfs(0, 0);
        System.out.println(min);
    }
//    static List<Node> list = new ArrayList<>();
//    static void dfs(int x, int y, int cnt, int value) {
//        if(cnt == 3) {
//            if(min > value) {
//                min = Math.min(min, value);
//                for(Node n : list)
//                    System.out.print(n.x+", "+n.y+"\t");
//                System.out.println();
//            }
//            return;
//        }
//        if(y == N) {
//            dfs(x + 1, 0, cnt, value);
//            return;
//        }
//        if(x == N)
//            return;
//        if(arr[x][y] != 0 && !visited[x][y] && check(x, y)) {
//            visit(x, y, true);
//            list.add(new Node(x, y, 0));
//            dfs(x, y+1, cnt+1, value+sum(x, y));
//            visit(x, y, false);
//            list.remove(list.size()-1);
//        }
//        dfs(x, y+1, cnt, value);
//    }
    static void dfs(int cnt, int value) {
        if(cnt == 3) {
            min = Math.min(min, value);
            return;
        }
        // i, j 값을 하나씩 증가시키는 부분에서 문제가 생기는 것 같음
        // (dfs(x, y+1, cnt+1, value..)이렇게 접근하면 40퍼센트대에서 에러가 발생
        for(int i = 1; i < N; i++) {
            for(int j = 1; j < N; j++) {
                if(check(i, j)) {
                    visit(i, j, true);
                    dfs(cnt+1, value+sum(i, j));
                    visit(i, j, false);
                }
            }
        }
    }
    static boolean isIn(int x, int y) {
//        return x >= 0 && y >= 0 && x < N && y < N;
        return x >= 1 && y >= 1 && x <= N && y <= N;
    }
    static int sum(int x, int y) {
        int sum = 0;
        int dx = 0;
        int dy = 0;
        for(int d = 0; d < dir.length; d++) {
            dx = x + dir[d][0];
            dy = y + dir[d][1];
            sum += arr[dx][dy];
        }
        return sum;
    }
    static void visit(int x, int y, boolean flag) {
        int dx = 0;
        int dy = 0;
        for(int d = 0; d < dir.length; d++) {
            dx = x + dir[d][0];
            dy = y + dir[d][1];
            visited[dx][dy] = flag;
        }
    }
    static boolean check(int x, int y) {
        int dx = 0;
        int dy = 0;
        for(int d = 0; d < dir.length; d++) {
            dx = x + dir[d][0];
            dy = y + dir[d][1];
            if(!isIn(dx, dy) || visited[dx][dy])
                return false;
        }
        return true;
    }
}
/*
6
1 0 2 3 3 4
1 1 5 1 1 1
0 0 1 1 2 1
3 9 9 3 1 9
9 9 3 0 1 1
9 3 0 0 0 1
 */