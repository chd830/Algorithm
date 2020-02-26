package net.acmicpc;

import java.util.Scanner;

public class 모든순열 {
    static boolean[] visited;
    static int[] sub;
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        arr = new int[N];
        visited = new boolean[N];
        for(int i = 0; i < N; i++) {
            arr[i] = (i+1);
        }
        print();
        next_permute(N);
    }
    public static void next_permute(int N) {
        int i = N-1;
        while(i > 0 && arr[i] <= arr[i-1]) {
            i--;
        }
        if(i <= 0) {
            return;
        }
        int j = N-1;
        while(arr[j] <= arr[i-1]) {
            j--;
        }
        swap(i-1, j);
        j = N-1;
        while(i < j) {
            swap(i, j);
            i++;
            j--;
        }
        print();
        next_permute(N);
    }
    public static void print() {
        for(int a : arr) {
            System.out.print(a+" ");
        }
        System.out.println();
    }
    public static void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void recur(int s_idx) {
        if(s_idx == sub.length) {
            StringBuilder sb = new StringBuilder();
            for(int i : sub) {
                sb.append(i + " ");
            }
            System.out.println(sb.toString());
            return;
        }
        for(int i = 0; i < arr.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                sub[s_idx] = arr[i];
                recur(s_idx+1);
                visited[i] = false;
            }
        }
    }
}
