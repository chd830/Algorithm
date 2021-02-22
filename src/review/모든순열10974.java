package review;

import java.util.*;
import java.io.*;

public class 모든순열10974 {
    static int N;
    static int[] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        visited = new boolean[N];
        next(0);
    }
    static void print() {
        for(int i : arr) {
            System.out.print(i+" ");
        }
        System.out.println();
    }
    static void next(int idx) {
        if(idx == N) {
            print();
            return;
        }
        for(int i = 0; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                arr[idx] = i+1;
                next(idx+1);
                visited[i] = false;
            }
        }
    }
}
