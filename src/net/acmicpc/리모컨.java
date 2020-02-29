package net.acmicpc;

import java.util.Scanner;

public class 리모컨 {
    static boolean[] broken = new boolean[10];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            broken[x] = true;
        }
        int pow = 1;
        int cnt = 0;
        int num = n;
        int min = 0;
        while(n > 0) {
            if(n == 10) {
                if(broken[1]) {

                }

            }
            if(n < 10) {
                if(broken[n]) {
                    cnt += pow*1;
                    n--;
                }
            }
            if(broken[n%10]) {
                cnt += pow*1;
                n--;
            }
            else {
                n /= 10;
                pow *= 10;
            }
        }
        min = cnt;
        cnt = 0;
        n = num;
        pow = 1;
        while(n >= 10) {
            if(broken[n%10]) {
                cnt += pow*1;
                n++;
            }
            else {
                n /= 10;
                pow *= 10;
            }
        }
        min = Math.min(min, cnt);
        System.out.println((int)(Math.log10(num)+1)+cnt);
    }
}
