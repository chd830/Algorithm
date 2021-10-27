package BFS;

import java.util.*;
import java.io.*;

public class 탈출 {
    static class Node {
        int x;
        int y;
        int cnt;
        boolean water;
        Node(int x, int y, int cnt, boolean water) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.water = water;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());
        char[][] arr = new char[N][M];
        int[][] dir = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        Queue<Node> que = new LinkedList<>();
        Node hedgehog = null;
        Node bieber = null;
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j);
                if(arr[i][j] == 'S')
                    hedgehog = new Node(i, j, 0, false);
                else if(arr[i][j] == '*')
                    que.add(new Node(i, j, 0, true));
                else if(arr[i][j] == 'D')
                    bieber = new Node(i, j, 0, false);
            }
        }
        que.add(hedgehog);
        while(!que.isEmpty()) {
            int size = que.size();
            for(int i = 0; i < size; i++) {
                Node n = que.poll();
                for(int d = 0; d < 4; d++) {
                    int dx = n.x + dir[d][0];
                    int dy = n.y + dir[d][1];
                    if(dx >= 0 && dy >= 0 && dx < N && dy < M) {
                        if(n.water && arr[dx][dy] == '.') {
                            que.add(new Node(dx, dy, 0, n.water));
                            arr[dx][dy] = '*';
                        }
                        else if(!n.water && arr[dx][dy] == '.'){
                            que.add(new Node(dx, dy, n.cnt+1, n.water));
                            arr[dx][dy] = 'S';
                        }
                        else if(!n.water && arr[dx][dy] == 'D') {
                            System.out.println(n.cnt+1);
                            System.exit(0);
                        }
                    }
                }
            }
//            print(arr);
        }
        System.out.println("KAKTUS");
    }
    static void print(char[][] arr) {
        for(int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
        System.out.println();
    }
}
