package com.code;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.Scanner;

public class NandM {
    static int N;
    static int M;
    static int[] arr;
    static int[] result;
    static boolean[] visited;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        result = new int[M];
        arr = new int[M];
        for (int i = 1; i <= N; i++) {
            arr[i - 1] = i;
        }
        visited = new boolean[N];
//				List<Integer> list = new ArrayList();
//				recur(0, list);
        recur(0);
        recur2(0, 0);
        recur3(0, "");
        sc.close();
        bw.close();
    }

    static void recur3(int idx, String str) throws IOException {
        if (idx == M) {
            bw.write(str.trim() + "\n");
            bw.flush();
            return;
        }
        for (int i = 0; i < N; i++) {
            recur3(idx + 1, str + " " + (i + 1));
        }
    }

    static void recur2(int idx, int s_idx) {
        if (s_idx == result.length) {
            for (int i = 0; i < result.length; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println("");
            return;
        }
        if (idx == arr.length) {
            return;
        }
        result[s_idx] = arr[idx];
        recur2(idx + 1, s_idx + 1);
        recur2(idx + 1, s_idx);
    }

    static void recur(int idx) {
        if (idx == arr.length) {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println("");
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[idx] = (i + 1);
                recur(idx + 1);
                visited[i] = false;

            }
        }
    }

    static void recur1(int idx, List<Integer> list) {
        if (list.size() == M) {
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!list.contains((i + 1))) {
                list.add((i + 1));
                recur1(idx + 1, list);
                list.remove(list.size() - 1);
            }
        }
    }
}
