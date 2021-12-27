package BFS;

import java.util.*;

// https://www.acmicpc.net/problem/1726
public class 로봇 {
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static class Node {
        int x;
        int y;
        int pos;
        Node(int x, int y, int pos) {
            this.x = x;
            this.y = y;
            this.pos = pos;
        }
    }
    static int N;
    static int M;
    static int min;
    static int[][] arr;
    static int[][] count;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N][M];
        count = new int[N][M];
        min = Integer.MAX_VALUE;
        for(int i = 0; i < N; i++) {
            Arrays.fill(count[i], -1);
            for(int j = 0; j < M; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        Node start = new Node(sc.nextInt()-1, sc.nextInt()-1, sc.nextInt()-1);
        Node end = new Node(sc.nextInt()-1, sc.nextInt()-1, sc.nextInt()-1);
        Queue<Node> que = new LinkedList<>();
        que.add(start);
        count[start.x][start.y] = 0;
        int result = 0;
        while(!que.isEmpty()) {
            Node n = que.poll();
            if (n.x == end.x && n.y == end.y) {
                result = Math.abs(end.pos-n.pos);
                result += count[n.x][n.y];
                break;
            }
            loop: for(int d = 0; d < 4; d++) {
                for(int j = 1; j <= 3; j++) {
                    int dx = n.x + dir[d][0]*j;
                    int dy = n.y + dir[d][1]*j;
                    if(isIn(dx, dy)) {
                        if(arr[dx][dy] == 1) {
                            continue loop;
                        }
                        if(count[dx][dy] == -1) {
                            if (d == n.pos)
                                count[dx][dy] = count[n.x][n.y] + 1;
                            else {
                                count[dx][dy] = count[n.x][n.y];
                                switch (d) {
                                    case 0: case 2:
                                        if(n.pos == 3 || n.pos == 1)
                                            count[dx][dy] += 2;
                                        else
                                            count[dx][dy] += 3;
                                        break;
                                    case 1: case 3:
                                        if(n.pos == 2 || n.pos == 0)
                                            count[dx][dy] += 2;
                                        else
                                            count[dx][dy] += 3;
                                        break;
                                }
                            }
                            que.add(new Node(dx, dy, d));
                        }
                    }
                }
            }
            for(int i = 0; i < N; i++)
                System.out.println(Arrays.toString(count[i]));
            System.out.println();
        }
        System.out.println(result);
    }
    static boolean isIn(int dx, int dy) {
        return dx >= 0 && dy >= 0 && dx < N && dy < M;
    }

}
