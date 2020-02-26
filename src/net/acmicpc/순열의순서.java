package net.acmicpc;

import java.io.*;
import java.util.*;

public class 순열의순서 {
    static int N;
    static int cnt;
    static int[] arr;
    static int[] start;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cnt = 0;
        StringTokenizer token = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(token.nextToken());
        start = new int[N];
        for (int i = 0; i < N; i++) {
            start[i] = (i + 1);
        }
        if (K == 1) {
            nextPermute(N, Integer.parseInt(token.nextToken()));
        }
        else {
            arr = new int[N];
            for(int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(token.nextToken());
            }
            prevPermute(N, 1);
        }
    }

    public static void prevPermute(int N, int K) {
        if(Arrays.equals(start, arr)) {
            System.out.println(K);
            return;
        }
        int i = N-1;
        while(i > 0 && arr[i] >= arr[i-1]) {
            i--;
        }
        if(i == 0) {
            print(arr);
            return;
        }
        int j = N-1;
        while(arr[i-1] < arr[j]) {
            j--;
        }
        swap(arr,i-1, j);
        j = N-1;
        while(i < j) {
            swap(arr, i, j);
            i++;
            j--;
        }
        prevPermute(N, K+1);
    }

    public static void nextPermute(int N, int K) {
        if(K == 1) {
            print(start);
        }
        int i = N-1;
        while(i > 0 && start[i] <= start[i-1]) {
            i--;
        }
        if(i <= 0) {
            return;
        }
        int j = N-1;
        while(start[i-1] > start[j]) {
            j--;
        }
        swap(start, i-1, j);
        j = N-1;
        while(i < j) {
            swap(start, i, j);
            i++;
            j--;
        }
        nextPermute(N, K-1);
        return;
    }

    public static void print(int[] arr) {
        for(int i : arr) {
            System.out.print(i+" ");
        }
        System.out.println();
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
