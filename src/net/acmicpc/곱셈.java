package net.acmicpc;

import java.util.Scanner;

public class 곱셈 {
    static long A;
    static long B;
    static long C;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        A = sc.nextInt();
        B = sc.nextInt();
        C = sc.nextInt();
        System.out.println(mul(A, B));
    }
    //분할정복을 이용한 재귀
    static long mul(long a, long b) {
        a %= C;
        //기저케이스
        if(b == 0) {
            return 1;
        }
        //나눌 횟수가 짝수일 때
        else if(b % 2 == 0) {
            return mul(a*a, b >> 1) % C;
        }
        //나눌 횟수가 홀수일 때
        else {
            return a * mul(a, b - 1) % C;
        }
    }
}
