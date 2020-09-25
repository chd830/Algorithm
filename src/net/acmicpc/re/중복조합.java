package net.acmicpc.re;

import java.util.Arrays;

public class 중복조합 {
    static int[] arr = {1, 2, 3};
    static int[] sub = new int[2];
    static boolean[] visited = new boolean[arr.length];
    public static void main(String[] args) {
        comb(0, 0);
    }
    static void comb(int idx, int subIdx) {
        if(subIdx == sub.length) {
            System.out.println(Arrays.toString(sub));
            return;
        }
        if(idx == arr.length) {
            return;
        }
        sub[subIdx] = arr[idx];
        comb(idx, subIdx+1);
        comb(idx+1, subIdx);
    }
}
