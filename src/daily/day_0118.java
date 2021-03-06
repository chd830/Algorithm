package daily;

import java.util.Arrays;

public class day_0118 {
    static int[] arr = {1, 2, 3, 4};
    static int[] sub = new int[2];
    static boolean[] visited = new boolean[arr.length];
    public static void main(String[] args) {
//        permute(0);
//        doublePermute(0);
//        comb(0, 0);
//        doubleComb(0, 0);
        subset(0);
    }
    static void permute(int idx) {
        if(idx == sub.length) {
            System.out.println(Arrays.toString(sub));
            return;
        }
        for(int i = 0; i < arr.length; i++) {
            if(!visited[i]) {
                sub[idx] = arr[i];
                visited[i] = true;
                permute(idx+1);
                visited[i] = false;
            }
        }
    }
    static void doublePermute(int idx) {
        if(idx == sub.length) {
            System.out.println(Arrays.toString(sub));
            return;
        }
        for(int i = 0; i < arr.length; i++) {
            sub[idx] = arr[i];
            doublePermute(idx+1);
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
                comb(i + 1, subIdx + 1);
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
            doubleComb(i, subIdx+1);
        }
    }
    static void subset(int idx) {
        for(int i = 0; i < arr.length; i++) {
            if(!visited[i]) {
                System.out.print(arr[i]+"\t");
            }
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
