package BFS;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/3197
public class 백조의호수 {
    static int N;
    static int M;
    static char[][] arr;
    static boolean[][] visited;
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static Node start;
    static Queue<Node> water;
    static Queue<Node> nextWater;
    static Queue<Node> swan;
    static Queue<Node> nextSwan;
    static class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        arr = new char[N][M];
        visited = new boolean[N][M];
        swan = new LinkedList<>();
        nextSwan = new LinkedList<>();
        water = new LinkedList<>();
        nextWater = new LinkedList<>();
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j);
                if(arr[i][j] == 'L')
                    start = new Node(i, j);
                if(arr[i][j] != 'X')
                    water.add(new Node(i, j));
            }
        }
        int cnt = 1;
        swan.add(start);
        while(!turn())
            cnt++;
        System.out.println(cnt == 1 ? 0 : cnt);
    }
    static boolean turn() {
        while(!water.isEmpty()) {
            Node n = water.poll();
            for(int d = 0; d < 4; d++) {
                int dx = n.x + dir[d][0];
                int dy = n.y + dir[d][1];
                if(dx >= 0 && dy >= 0 && dx < N && dy < M && arr[dx][dy] == 'X') {
                    arr[dx][dy] = '.';
                    nextWater.add(new Node(dx, dy));
                }
            }
        }
        int size = swan.size();
        while(size-- > 0) {
            Node n = swan.poll();
            visited[n.x][n.y] = true;
            swan.add(n);
        }
        while(!swan.isEmpty()) {
            Node n = swan.poll();
            for(int d = 0; d < 4; d++) {
                int dx = n.x + dir[d][0];
                int dy = n.y + dir[d][1];
                if(dx >= 0 && dy >= 0 && dx < N && dy < M && arr[dx][dy] != 'X' && !visited[dx][dy]) {
                    if(arr[dx][dy] == 'L')
                        return true;
                    visited[dx][dy] = true;
                    swan.add(new Node(dx, dy));
                    nextSwan.add(new Node(dx, dy));
                }
            }
        }
        while(!nextWater.isEmpty())
            water.add(nextWater.poll());
        while(!nextSwan.isEmpty())
            swan.add(nextSwan.poll());
        return false;
    }
}