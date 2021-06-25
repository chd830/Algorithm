package daily;

import java.util.Arrays;

public class day_0624 {
    static int[] arr = {1, 3, 5};
    static int[] sub = new int[2];
    static boolean[] visited = new boolean[arr.length];
    public static void main(String[] args) {
//        perm(0);
//        doublePerm(0);
//        comb(0, 0);
//        doubleComb(0, 0);
        subset(0);
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
    static void doublePerm(int idx) {
        if(idx == sub.length) {
            System.out.println(Arrays.toString(sub));
            return;
        }
        for(int i = 0; i < arr.length; i++) {
                sub[idx] = arr[i];
                perm(idx+1);
        }
    }
    static void comb(int idx, int subIdx) {
        if(subIdx == sub.length) {
            System.out.println(Arrays.toString(sub));
            return;
        }
        for(int i = idx; i < arr.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                sub[subIdx] = arr[i];
                comb(i+1, subIdx+1);
                visited[i] = false;
            }
        }
    }
    static void doubleComb(int idx, int subIdx) {
        if(subIdx == sub.length) {
            System.out.println(Arrays.toString(sub));
            return;
        }
        for(int i = idx; i < arr.length; i++) {
                sub[subIdx] = arr[i];
                comb(i, subIdx+1);
        }
    }
    static void subset(int idx) {
        for(int i = 0; i < arr.length; i++) {
            System.out.print(visited[i] ? arr[i]+"\t" : "");
        }
        System.out.println();
        for(int i = idx; i < arr.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                subset(i+1);
                visited[i] = false;
            }
        }
    }
}
