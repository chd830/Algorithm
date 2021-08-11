package 구현;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/3190
public class 뱀 {
    static int N;
    static int L;
    static int[][] arr;
    static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        StringTokenizer token = null;
        for (int i = 0; i < K; i++) {
            token = new StringTokenizer(br.readLine());
            arr[Integer.parseInt(token.nextToken())-1][Integer.parseInt(token.nextToken())-1] = 1;
        }
        L = Integer.parseInt(br.readLine());
        x = 0;
        y = 0;
        d = 0;
        result = 0;
        list = new ArrayList<>();
        list.add(new Node(x, y));
        int[][] next = new int[L][2];
        for(int i = 0; i < L; i++) {
            token = new StringTokenizer(br.readLine());
            next[i][0] = Integer.parseInt(token.nextToken());
            next[i][1] = token.nextToken().equals("D") ? 1 : -1;
        }
        move(next);
        System.out.println(result);
    }
    static int x;
    static int y;
    static int d;
    static int result;
    static List<Node> list;
    static int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static void move(int[][] dir) {
        int turn = 0;
        while(true) {
//            System.out.println("CUR: "+x+"\t"+y);
//            for(Node n : list)
//                System.out.println(n);
//            System.out.println();
            result++;
            x += direction[d][0];
            y += direction[d][1];
            if(!check(x, y)) {
                break;
            }
            list.add(new Node(x, y));

            if(arr[x][y] == 1)
                arr[x][y] = 0;
            else
                list.remove(0);
            if(turn < L) {
                if(result == dir[turn][0]) {
                    d += dir[turn][1];
                    if(d < 0)
                        d = 3;
                    if(d > 3)
                        d = 0;
                    turn++;
                }
            }
        }
    }
    static boolean check(int x, int y) {
        if(x < 0 || y < 0 || x >= N || y >= N)
            return false;
        for(Node n : list) {
            if(n.x == x && n.y == y)
                return false;
        }
        return true;
    }
}
