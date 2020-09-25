package net.acmicpc.re;

import java.util.Arrays;

public class 순열 {
    static int[] arr = {1, 2, 3, 4, 5};
    static int[] sub = new int[2];
    static boolean[] visited = new boolean[arr.length];
    public static void main(String[] args) {
        perm(0);
    }
    static void perm(int idx) {
        if(idx == sub.length) {
            System.out.println(Arrays.toString(sub));
            return;
        }
        for(int i = 0; i < arr.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                sub[idx] = arr[i];
                perm(idx+1);
                visited[i] = false;
            }
        }
    }
}
