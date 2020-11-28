package review;

import java.io.IOException;
import java.util.Arrays;

public class 순열 {
    /*
    A, B, C
    AB, AC, BC, BA, BC, CA, CB
     */
    static int[] arr = {1, 2, 3};
    static int[] sub = new int[2];
    static boolean[] visited = new boolean[arr.length];

    public static void main(String[] args) {
        perm(0);
    }
    public static void perm(int idx) {
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
