package Concept;

import java.util.Arrays;

public class Combination {
    static int N;
    static int R;
    static int totalCnt;
    static int[] number;
    static boolean[] visit;

    public static void main(String[] args) {
        N = 4;
        R = 2;
        totalCnt = 0;
        number = new int[R];
        visit = new boolean[N];
        comb(0, 0);
        System.out.println(totalCnt);
    }
    static void comb(int cnt, int cur) {
        if(cnt == R) {
            totalCnt++;
            System.out.println(Arrays.toString(number)+" "+Arrays.toString(visit));
            return;
        }
        for(int i = cur; i < N; i++) {
            number[cnt] = i;
            visit[i] = true;
            comb(cnt+1, i+1);
            visit[i] = false;
        }
    }
}
