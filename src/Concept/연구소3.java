package Concept;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 연구소3 {
    static int[][] map;
    static int[][] copy;
    static int N;
    static int M;
    static Virus[] virus;
    static boolean[] select;
    static int virusCnt;
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int ans;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];
        copy = new int[N][M];
        virus = new Virus[10];
        virusCnt = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
                if(map[i][j] == 2) {
                    virus[virusCnt++] = new Virus(i, j);
                }
            }
        }
        select = new boolean[virusCnt];
        ans = Integer.MAX_VALUE;
        combination(0, 0);
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }
    static void deepcopy() {
        for(int i = 0; i < N; i++) {
            for(int j = 0 ;j < N; j++) {
                copy[i][j] = map[i][j];
            }
        }
    }
    static void combination(int idx, int cnt) {
        if(cnt == M) {
            //시뮬레이션 돌리기. 카피필요
            System.out.println(Arrays.toString(select));
            deepcopy();
            Queue<Virus> que = new LinkedList<>();
            for(int i = 0; i < virusCnt; i++) {
                if(!select[i]) {
                    Virus seed = virus[i];
                    que.add(seed);
                    copy[seed.x][seed.y] = 9;
                }
            }
            bfs(que);
            return;
        }
        if(idx == virusCnt) {
            return;
        }
        select[idx] = true;
        combination(idx+1, cnt+1);
        select[idx] = false;
        combination(idx+1, cnt);
    }
    static boolean check() {
        for(int i = 0; i < N; i++) {
            for(int j =0 ; j < N; j++) {
                if(copy[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
    static void bfs(Queue<Virus> que) {
        int time = 0;
        while(!que.isEmpty()) {
            int size = que.size();
            if(check()) {
                if(ans > time) {
                    ans = time;
                }
                break;
            }
            for(int i = 0; i < size; i++) {
                Virus now = que.poll();
                for(int d = 0; d < 4; d++) {
                    int dx = now.x + dir[d][0];
                    int dy = now.y + dir[d][1];
                    if(dx >= 0 && dy >= 0 && dx < N && dy < N && copy[dx][dy] == 0 || copy[dx][dy] == 2) {
                        copy[dx][dy] = 9;
                        que.add(new Virus(dx, dy));
                    }
                }
            }
            time++;
        }
    }
    static class Virus {
        int x;
        int y;
        Virus(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
