package Concept;

import java.util.*;

public class 벽돌깨기 {
    static int N;
    static int W;
    static int H;
    static int min;
    static int[] sub;
    static int[][] map;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t <= T; t++) {
            N = sc.nextInt();
            H = sc.nextInt();
            W = sc.nextInt();
            sub = new int[N];
            map = new int[W][H];
            for(int i = 0; i < W; i++) {
                for(int j =0; j < H; j++) {
                    map[i][j] = sc.nextInt();
                }
            }
            min = countBricks(map);
            System.out.println(min);
            permute(0);
            System.out.println("#"+t+" "+min);
        }
    }

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
    static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static int[][] cloneMap(int[][] map) {
        int[][] temp = new int[W][H];
        for(int i = 0; i < W; i++) {
            temp[i] = map[i].clone();
        }
        return temp;
    }
    static int countBricks(int[][] map) {
        int cnt = 0;
        for(int i = 0; i < W; i++) {
            for(int j = 0 ;j < H; j++) {
                if(map[i][j] != 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
    public static void dropMarble(int[] sub) {
        int[][] clone = cloneMap(map);
        Queue<Node> que = new LinkedList();
        for(int idx = 0; idx < N; idx++) {
            int i = 0;
            while(i < W-1 && clone[i][sub[idx]] == 0) {
                i++;
            }
            if(i >= W) {
                continue;
            }
            que.add(new Node(i, sub[idx], clone[i][sub[idx]]));
            clone[i][sub[idx]] = 0;
            while(!que.isEmpty()) {
                Node n = que.poll();
                if(n.val == 1) {
                    clone[n.x][n.y] = 0;
                }
                else {
                    for(int k = 0; k < 4; k++) {
                        for(int j = 1; j < n.val; j++) {
                            int dx = n.x + (dir[k][0] * j);
                            int dy = n.y + (dir[k][1] * j);
                            if(isIn(dx, dy) && clone[dx][dy] != 0) {
                                if(clone[dx][dy] != 1) {
                                    que.add(new Node(dx, dy, clone[dx][dy]));
                                }
                                clone[dx][dy] = 0;
                            }
                        }
                    }
                }
                cleanMap(clone);
            }
        }
        print(clone);
        min = Math.min(min, countBricks(clone));
    }
    //중간에 0이 있을 때 값을 내리는 역할
    static void cleanMap(int[][] map) {
        for(int c = 0; c < H; c++) {
            for(int r = W-1, nr = W-1; r >= 0; r--) {
                if(map[r][c] != 0) {
                    int temp = map[r][c];
                    map[r][c] = 0;
                    map[nr--][c] = temp;
                }
            }
        }
    }
    static void print(int[][] clone) {
        for(int i = 0; i < W; i++) {
            for(int j = 0; j < H; j++) {
                System.out.print(clone[i][j]+" ");
            }
            System.out.print("\t\t");
            for(int j = 0; j < H; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    static boolean isIn(int dx, int dy) {
        return dx >= 0 && dy >= 0 && dx < W && dy < H;
    }
    public static void permute(int idx) {
        if(idx == N) {
            System.out.println(Arrays.toString(sub));
            dropMarble(sub);
            return;
        }
        for(int i = H-1; i >= 0; i--) {
            sub[idx] = i;
            permute(idx+1);
        }
    }
}
