package Concept;

import java.util.Arrays;
import java.util.Scanner;

public class 부분집합_조합 {
    static int N;
    static int[] arr;
    static int[] sub;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        for(int i = 0; i <= N; i++) {
            sub = new int[i];
            sub(0, 0);
        }
    }
    public static void sub(int idx, int s_idx) {
        if(idx == sub.length) {
            System.out.println(Arrays.toString(sub));
            return;
        }
        if(s_idx == arr.length) {
            return;
        }
        sub[idx] = arr[s_idx];
        sub(idx+1, s_idx+1);
        sub(idx, s_idx+1);
    }

}
