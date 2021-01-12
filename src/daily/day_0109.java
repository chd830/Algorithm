package daily;

import java.util.*;

public class day_0109 {
    static boolean[] visited;
    static int[] arr = {1, 2, 3};
    static int[] sub;
    static StringBuilder sb;
    public static void main(String[] args) {
        visited = new boolean[arr.length];
        sub = new int[2];
        sb = new StringBuilder();
        redunPermute(0);
        sb.append("\n");
        permute( 0, 0);
        sb.append("\n");
        redunComb(0, 0);
        sb.append("\n");
        comb(0, 0);
        sb.append("\n");
        subset(0);
        System.out.println(sb);
    }
    public static void redunPermute(int idx) {
        if(idx == sub.length) {
            sb.append(Arrays.toString(sub)).append("\n");
            return;
        }
        for(int i = 0; i < arr.length; i++) {
            sub[idx] = arr[i];
            redunPermute(idx+1);
        }
    }
    public static void permute(int idx, int subIdx) {
        if(subIdx == sub.length) {
            sb.append(Arrays.toString(sub)).append("\n");
            return;
        }
        for(int i = idx; i < arr.length; i++) {
            sub[subIdx] = arr[i];
            permute(i+1, subIdx+1);
        }
    }
    public static void redunComb(int idx, int subIdx) {
        if(subIdx == sub.length) {
            sb.append(Arrays.toString(sub)).append("\n");
            return;
        }
        if(idx == arr.length) {
            return;
        }
        sub[subIdx] = arr[idx];
        redunComb(idx, subIdx+1);
        redunComb(idx+1, subIdx);
    }
    public static void comb(int idx, int subIdx) {
        if(subIdx == sub.length) {
            sb.append(Arrays.toString(sub)).append("\n");
            System.out.println(Arrays.toString(sub));
            return;
        }
        if(idx == arr.length) {
            return;
        }
        sub[subIdx] = arr[idx];
        comb(idx+1, subIdx+1);
        comb(idx+1, subIdx);
    }
    public static void subset(int idx) {
        for(int i = 0; i < visited.length; i++) {
            if(!visited[i]) {
                sb.append(arr[i]).append(" ");
            }
        }
        sb.append("\n");
        for(int i = idx; i < arr.length; i++) {
            if(!visited[i])  {
                visited[i] = true;
                subset(i+1);
                visited[i] = false;
            }
        }
    }
}