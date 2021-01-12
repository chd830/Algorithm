package daily;

import java.util.Arrays;

public class day_0112 {
    static char[] arr = {'A', 'B', 'C'};
    static char[] sub = new char[2];
    static boolean[] visited = new boolean[arr.length];

    public static void main(String[] args) {
//        순열(0);
//        중복순열(0);
//        조합(0, 0);
//        중복조합(0, 0);
        부분집합(0);
    }
    //순열
    public static void 순열(int idx) {
        if(idx == sub.length) {
            System.out.println(Arrays.toString(sub));
            return;
        }
        for(int i = 0; i < arr.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                sub[idx] = arr[i];
                순열(idx+1);
                visited[i] = false;
            }
        }
    }
    //중복순열
    public static void 중복순열(int idx) {
        if(idx == sub.length) {
            System.out.println(Arrays.toString(sub));
            return;
        }
        for(int i = 0; i < arr.length; i++) {
            sub[idx] = arr[i];
            중복순열(idx+1);
        }
    }
    //조합
    public static void 조합(int idx, int subIdx) {
        if(subIdx == sub.length) {
            System.out.println(Arrays.toString(sub));
            return;
        }
        if(idx == arr.length) {
            return;
        }
        sub[subIdx] = arr[idx];
        조합(idx+1, subIdx+1);
        조합(idx+1, subIdx);
    }
    //중복조합
    public static void 중복조합(int idx, int subIdx) {
        if(subIdx == sub.length) {
            System.out.println(Arrays.toString(sub));
            return;
        }
        if(idx == arr.length) {
            return;
        }
        sub[subIdx] = arr[idx];
        중복조합(idx, subIdx+1);
        중복조합(idx+1, subIdx);
    }
    //부분집합
    public static void 부분집합(int idx) {
        for(int i = 0; i < visited.length; i++) {
            if(visited[i]) {
                System.out.print(arr[i]+"\t");
            }
        }
        System.out.println();
        for(int i = idx; i < arr.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                부분집합(i+1);
                visited[i] = false;
            }
        }
    }
}
