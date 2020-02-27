package net.acmicpc;

import java.util.Arrays;
import java.util.Scanner;

public class 일곱난쟁이 {
    static int[] arr;
    static int[] sub;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        arr = new int[9];
        sub = new int[7];
        for(int i = 0; i < 9; i++) {
            arr[i] = sc.nextInt();
        }
        permute(0, 0);
    }
    public static void permute(int idx, int s_idx) {
        if(s_idx == sub.length) {
            int sum = 0;
            for(int i : sub) {
                sum += i;
            }
            if(sum == 100) {
                Arrays.sort(sub);
                for(int i : sub) {
                    System.out.println(i);
                }
            }
            return;
        }
        if(idx == arr.length) {
            return;
        }
        sub[s_idx] = arr[idx];
        permute(idx+1, s_idx+1);
        permute(idx+1, s_idx);
    }
}
