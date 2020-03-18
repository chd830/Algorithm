package net.acmicpc;

import java.util.*;

public class 블랙잭 {
    static int M;
    static int max;
    static int[] arr;
    static int[] sub;
    static boolean[] visited;
    static List<Integer> list = new ArrayList();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N];
        sub = new int[3];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        combination(0, 0);
        Collections.sort(list);
        int prev = 0;
        for(int i : list) {
            if(i == M) {
                System.out.println(i);
                System.exit(0);
            }
            else if(i > M) {
                System.out.println(prev);
                System.exit(0);
            }
            prev = i;
//            System.out.print(i + " ");
        }
        System.out.println(list.get(list.size()-1));
    }
    public static void combination(int idx, int s_idx) {
        if(s_idx == sub.length) {
            int sum = 0;
            for(int i : sub) {
                sum += i;
            }
            list.add(sum);
            return;
        }
        if(idx == arr.length) {
            return;
        }
        sub[s_idx] = arr[idx];
        combination(idx+1, s_idx+1);
        combination(idx+1, s_idx);
    }
}
