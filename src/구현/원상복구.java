package 구현;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/22858
public class 원상복구 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());
        P = new int[N];
        D = new int[N];
        S = new int[N];
        token = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            P[i] = Integer.parseInt(token.nextToken());
        }
        token = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            D[i] = Integer.parseInt(token.nextToken());
        }
        // D는 P를 i번째로 가져옴
        while(M-- > 0) {
            shake();
        }
        for(int i = 0; i < N; i++)
            System.out.print(P[i]+" ");
    }
    static int[] D;
    static int[] P;
    static int[] S;
    static class Set implements Comparable<Set> {
        int idx;
        int val;
        Set(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }

        @Override
        public int compareTo(Set o) {
            return Integer.compare(this.idx, o.idx);
        }

        @Override
        public String toString() {
            return "Set{" +
                    "idx=" + idx +
                    ", val=" + val +
                    '}';
        }
    }
    static void shake() {
        List<Set> list = new ArrayList<>();
        for(int i = 0; i < S.length; i++) {
            list.add(new Set(D[i], i));
        }
        Collections.sort(list);
        for(int i = 0; i < list.size(); i++)
            S[i] = P[list.get(i).val];
        for(int i = 0; i < S.length; i++)
            P[i] = S[i];
    }
}