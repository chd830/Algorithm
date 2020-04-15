package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 순열의순서 {
    static int[] arr;
    static int cnt;
    static StringBuilder sb = new StringBuilder();
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        cnt = 0;
        for(int i = 0; i < N; i++) {
            arr[i] = i+1;
        }
        StringTokenizer token = new StringTokenizer(br.readLine());
        switch (Integer.parseInt(token.nextToken())) {
            case 1:
                cnt = Integer.parseInt(token.nextToken());
                nextPermutation();
                break;
            case 2:
                int[] sub = new int[N];
                for(int i = 0; i < N; i++) {
                    sub[i] = Integer.parseInt(token.nextToken());
                }
                checkPermutation(sub, 1);
                break;
        }
        System.out.println(sb);
    }
    static void checkPermutation(int[] sub, int cnt) {
        if(Arrays.equals(arr, sub)) {
            sb.append(cnt);
            return;
        }
        int i = arr.length-1;
        while(i > 0 && arr[i] <= arr[i-1]) {
            i--;
        }
        if(i <= 0) {
            System.out.println(cnt);
            return;
        }
        int j = arr.length-1;
        while(arr[j] <= arr[i-1]) {
            j--;
        }
        swap(i-1, j);
        j = arr.length-1;
        while(i < j) {
            swap(i, j);
            i++;
            j--;
        }
        checkPermutation(sub, cnt+1);
    }
    static void nextPermutation() {
        if(--cnt == 0) {
            for(int a : arr) {
                sb.append(a).append(" ");
            }
            return;
        }
        int i = arr.length-1;
        while(i > 0 && arr[i] <= arr[i-1]) {
            i--;
        }
        if(i <= 0) {
            return;
        }
        int j = arr.length-1;
        while(arr[j] <= arr[i-1]) {
            j--;
        }
        swap(i-1, j);
        j = arr.length-1;
        while(i < j) {
            swap(i, j);
            i++;
            j--;
        }
        nextPermutation();
    }
    public static void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
