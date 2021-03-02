package daily;

import java.util.Arrays;

public class day_0302 {
    static final int N = 3;
    static int[] sub = new int[2];
    static boolean[] visited = new boolean[N];

    void perm(int idx) {
        if(idx == sub.length) {
            System.out.println(Arrays.toString(sub));
            return;
        }
        for(int i = 0; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                sub[idx] = i;
                perm(idx+1);
                visited[i] = false;
            }
        }
    }
    void comb(int idx, int subIdx) {
        if(subIdx == sub.length) {
            System.out.println(Arrays.toString(sub));
            return;
        }
        for(int i = idx; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                sub[subIdx] = i;
                comb(i+1, subIdx+1);
                visited[i] = false;
            }
        }
    }
    void doublePerm(int idx) {
        if(idx == sub.length) {
            System.out.println(Arrays.toString(sub));
            return;
        }
        for(int i = 0; i < N; i++) {
            sub[idx] = i;
            doublePerm(idx+1);
        }
    }
    void doubleComb(int idx, int subIdx) {
        if(subIdx == sub.length) {
            System.out.println(Arrays.toString(sub));
            return;
        }
        for(int i = idx; i < N; i++) {
            sub[subIdx] = i;
            doubleComb(i, subIdx+1);
        }
    }
    void subset(int idx) {
        for(int i = 0; i < N; i++) {
            System.out.print(visited[i] ? i+"\t" : "");
        }
        System.out.println();
        for(int i = idx; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                subset(i+1);
                visited[i] = false;
            }
        }
    }
}
