package net.acmicpc;

import java.util.Arrays;
import java.util.Scanner;

public class 날짜계산 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] esm = new int[3];
        for(int i = 0; i < 3; i++) {
            esm[i] = sc.nextInt();
        }
        int[] arr = new int[3];
        int cnt = 0;
        int e = 1;
        int s = 1;
        int m = 1;
        while(!Arrays.equals(esm, arr)) {
            arr[0] = e;
            arr[1] = s;
            arr[2] = m;
            e++;
            s++;
            m++;
            cnt++;
            if(e == 16) {
                e %= 15;
            }
            if(s == 29) {
                s %= 28;
            }
            if(m == 20) {
                m %= 19;
            }
        }
        System.out.println(cnt);
    }
}
