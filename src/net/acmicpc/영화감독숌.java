package net.acmicpc;

import java.util.Scanner;

public class 영화감독숌 {
    static int N;
    static int idx;
    static int result;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        idx = 1;
        result = 0;
        while (true) {
            if (find(idx)) {
//                System.out.print(idx+" \n");
                result++;
            }
            if (result == N) {
                System.out.println(idx);
                break;
            }
            idx++;
        }
    }
    static boolean find(int N) {
        int cnt = 0;
        while(N >= 10) {
            if(N%10 == 6) {
                cnt++;
            }
            else {
                cnt = 0;
            }
            N /= 10;
            if(cnt == 3) {
                break;
            }
        }
        if(N == 6) {
            cnt++;
        }
        return cnt >= 3 ? true : false;
    }
}
