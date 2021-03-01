package daily;

import java.util.Arrays;

public class day_0224 {
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
<<<<<<< HEAD
                sub[idx] = i+1;
=======
                sub[idx] = i;
>>>>>>> 893d9a43e4dc7d7f4e156d4950d35e025d9eddf5
                perm(idx+1);
                visited[i] = false;
            }
        }
    }
<<<<<<< HEAD
=======
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
>>>>>>> 893d9a43e4dc7d7f4e156d4950d35e025d9eddf5
    void comb(int idx, int subIdx) {
        if(subIdx == sub.length) {
            System.out.println(Arrays.toString(sub));
            return;
        }
        for(int i = idx; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
<<<<<<< HEAD
                sub[subIdx] = i+1;
=======
                sub[subIdx] = i;
>>>>>>> 893d9a43e4dc7d7f4e156d4950d35e025d9eddf5
                comb(i+1, subIdx+1);
                visited[i] = false;
            }
        }
    }
<<<<<<< HEAD
    void doublePerm(int idx) {
        if(idx == sub.length) {
            System.out.println(Arrays.toString(sub));
            return;
        }
        for(int i = 0; i < N; i++) {
            sub[idx] = i+1;
            doublePerm(idx+1);
        }
    }
=======
>>>>>>> 893d9a43e4dc7d7f4e156d4950d35e025d9eddf5
    void doubleComb(int idx, int subIdx) {
        if(subIdx == sub.length) {
            System.out.println(Arrays.toString(sub));
            return;
        }
        for(int i = idx; i < N; i++) {
<<<<<<< HEAD
            sub[subIdx] = i+1;
=======
            sub[subIdx] = i;
>>>>>>> 893d9a43e4dc7d7f4e156d4950d35e025d9eddf5
            doubleComb(i, subIdx+1);
        }
    }
    void subset(int idx) {
        for(int i = 0; i < N; i++) {
<<<<<<< HEAD
            System.out.print(visited[i] ? i+1+"\t" : "");
=======
            System.out.print(visited[i] ? i+"\t" : "");
>>>>>>> 893d9a43e4dc7d7f4e156d4950d35e025d9eddf5
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
