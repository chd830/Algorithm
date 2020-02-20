package com.swexpertacademy;

import java.util.Arrays;
import java.util.Scanner;

//규영이와 인영이의 카드게임. 완탐이나 백트래킹으로 풀기
public class d3_6808re {
    final static int N = 9;
    static int[] gu;
    static int[] in;
    static int[] cards;
    static int[] permute;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t <= T; t++) {
            gu = new int[N];
            in = new int[N];
            permute = new int[N];
            visited = new boolean[N];
            cards = new int[18];
            win = 0;
            lose = 0;
            for(int i = 0; i < 18; i++) {
                cards[i] = (i+1);
            }
            for(int i = 0; i < N; i++) {
                gu[i] = sc.nextInt();
            }
            int[] copy = Arrays.copyOf(gu, N);
            Arrays.sort(copy);
            for(int i = 0, g_idx = 0, i_idx = 0; i < cards.length; i++) {
                if(g_idx < N && cards[i] == copy[g_idx]) {
                    g_idx++;
                }
                else {
                    in[i_idx] = cards[i];
                    i_idx++;
                }
            }
            perm(0);
            System.out.println("#"+t+" "+win+" "+lose);
        }
    }
    static int win;
    static int lose;
    public static void perm(int idx) {
        if(idx == N) {
            int g_score = 0;
            int i_score = 0;
            for(int i = 0; i < N; i++) {
                if(permute[i] < gu[i]) {
                    g_score += gu[i] + permute[i];
                }
                else {
                    i_score += permute[i] + gu[i];
                }
            }
            if(g_score < i_score) {
                lose++;
            }
            else {
                win++;
            }
            return;
        }
        for(int i = 0; i < N; i++) {
            if(!visited[i]) {
                permute[idx] = in[i];
                visited[i] = true;
                perm(idx+1);
                visited[i] = false;
            }
        }
    }
}
