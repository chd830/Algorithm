package com.code;

import java.util.*;

public class 캐슬디펜스 {
    static class Enemy{
        int r, c;
        public Enemy(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    static int N;
    static int M;
    static int D;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        D = sc.nextInt();
        List<Enemy> list = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(sc.nextInt() == 1)
                    list.add(new Enemy(i, j));
            }
        }
        int ans = 0;
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < M; j++) {
                for(int k = 0; k < M; k++) {
                    List<Enemy> tmp = new ArrayList<>();
                    for(Enemy e : list)
                        tmp.add(new Enemy(e.r, e.c));
                    int cnt = 0;
                    int[] pos = {i,j,k};
                    while(!tmp.isEmpty()) {
                        Set<Enemy> deathNote = new HashSet<>();
                        for(int p : pos) {
                            int target = find(tmp, p);
                            if(target != -1)
                                deathNote.add(tmp.get(target));
                        }
                        cnt += deathNote.size();
                        tmp.removeAll(deathNote);
                        for(int n = tmp.size()-1; n >=0; n--) {
                            Enemy e = tmp.get(n);
                            e.r++;
                            if(e.r == N)
                                tmp.remove(n);
                        }
                    }
                    ans = Math.max(ans, cnt);
                }
            }
        }
        System.out.println(ans);
    }
    static int find(List<Enemy> list, int p) {
        int dist = 987654321;
        int res = -1;
        int minC = 100;
        for(int i = 0; i < list.size(); i++) {
            Enemy e = list.get(i);
            int tmpDist = N-e.r + Math.abs(p - e.c);
            if( tmpDist > D)
                continue;
            if( tmpDist < dist ) {
                dist = tmpDist;
                res = i;
                minC = e.c;
            }
            else if( tmpDist == dist) {
                if(minC > e.c) {
                    minC = e.c;
                    res = i;
                }
            }
        }
        return res;
    }
}