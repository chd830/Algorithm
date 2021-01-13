package daily;

import java.util.Arrays;

public class day_0113 {
    static int[] arr = {1, 3, 5};
    static int[] sub = new int[2];
    static boolean[] visited = new boolean[arr.length];
    public static void main(String[] args) {
        subset(0);
    }
    public static void permute(int idx) {
        if(idx == sub.length) {
            System.out.println(Arrays.toString(sub));
            return;
        }
        for(int i = 0; i < arr.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                sub[idx] = arr[i];
                permute(idx+1);
                visited[i] = false;
            }
        }
    }
    public static void doublePermute(int idx) {
        if(idx == sub.length) {
            System.out.println(Arrays.toString(sub));
            return;
        }
        for(int i = 0; i < arr.length; i++) {
            sub[idx] = arr[i];
            doublePermute(idx+1);
        }
    }
    public static void combination(int idx, int subIdx) {
        if(subIdx == sub.length) {
            System.out.println(Arrays.toString(sub));
            return;
        }
        for(int i = idx; i < arr.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                sub[subIdx] = arr[i];
                combination(i, subIdx+1);
                visited[i] = false;
            }
        }

    }
    public static void doubleCombination(int idx, int subIdx) {
        if(subIdx == sub.length) {
            System.out.println(Arrays.toString(sub));
            return;
        }
        if(idx == arr.length) {
            return;
        }
        sub[subIdx] = arr[idx];
        doubleCombination(idx, subIdx+1);
        doubleCombination(idx+1, subIdx);
    }
    public static void subset(int idx) {
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
