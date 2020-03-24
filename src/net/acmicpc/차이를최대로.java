package net.acmicpc;

import java.util.Arrays;
import java.util.Scanner;

public class 차이를최대로 {
    static int max;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        max = 0;
        visited = new boolean[N];
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
//        nextPermute(cnt);
        permute(arr, new int[N], 0);
        System.out.println(max);
    }

    public static void permute(int[] arr, int[] sub, int idx) {
            if(idx == sub.length) {
                max = Math.max(max, maxValue(sub));
                return;
            }
            for(int i = 0; i < arr.length; i++) {
                if(!visited[i]) {
                    sub[idx] = arr[i];
                    visited[i] = true;
                    permute(arr, sub, idx+1);
                    visited[i] = false;
                }
            }
    }

    public static void nextPermute(int[] arr) {
        int len = arr.length;
        int i = len-1;
        while(i > 0 && arr[i] <= arr[i-1]) {
            i--;
        }
        if(i <= 0) {
            return;
        }
        int j = len-1;
        while(arr[j] <= arr[i-1]) {
            j--;
        }
        swap(arr, i-1, j);
        j = len-1;
        while(i < j) {
            swap(arr, i, j);
            i++;
            j--;
        }
        max = Math.max(maxValue(arr), max);
        nextPermute(arr);
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static int maxValue(int[] arr) {
        int sum = 0;
        for(int i = 1; i < arr.length; i++) {
            sum += Math.abs(arr[i-1] - arr[i]);
        }
        return sum;
    }
}