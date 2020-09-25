package net.acmicpc.re;

import java.util.Arrays;

public class 중복순열 {
    static int[] arr = {1, 2, 3, 4, 5};
    static int[] sub = new int[2];

    public static void main(String[] args) {
        perm(0);
    }

    static void perm(int idx) {
        if (idx == sub.length) {
            System.out.println(Arrays.toString(sub));
            return;
        }
        if (idx == arr.length) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            sub[idx] = arr[i];
            perm(idx + 1);
        }
    }
}
