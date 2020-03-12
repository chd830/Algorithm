package Concept;

import java.util.Arrays;
import java.util.Scanner;

public class 주사위던지기 {
    static int[] dice = {1, 2, 3, 4, 5, 6};
    static int[] sub;
    static boolean[] visited = new boolean[6];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sub = new int[sc.nextInt()];
        조합(0, 0);
        System.out.println("-------------------");
        중복조합(0, 0);
        System.out.println("-------------------");
        순열(0);
        System.out.println("-------------------");
        중복순열(0);
    }
    public static void 순열(int idx) {
        if(idx == sub.length) {
            System.out.println(Arrays.toString(sub));
            return;
        }
        for(int i = 0; i < 6; i++) {
            if(!visited[i]) {
                visited[i] = true;
                sub[idx] = dice[i];
                순열(idx+1);
                visited[i] = false;
            }
        }
    }
    public static void 중복순열(int idx) {
        if(idx == sub.length) {
            System.out.println(Arrays.toString(sub));
            return;
        }
        for(int i = 0; i < 6; i++) {
            sub[idx] = dice[i];
            중복순열(idx+1);
        }
    }
    public static void 조합(int idx, int s_idx) {
        if(s_idx == sub.length) {
            System.out.println(Arrays.toString(sub));
            return;
        }
        if(idx == dice.length) {
            return;
        }
        sub[s_idx] = dice[idx];
        조합(idx+1, s_idx+1);
        조합(idx+1, s_idx);
    }
    public static void 중복조합(int idx, int s_idx) {
        if(idx == sub.length) {
            System.out.println(Arrays.toString(sub));
            return;
        }
        for(int i = s_idx; i <= 6; i++) {
            sub[idx] = i;
            중복조합(idx+1, i);
        }
//        sub[s_idx] = dice[idx];
//        중복조합(idx, s_idx+1);
//        중복조합(idx+1, s_idx);
    }
}
