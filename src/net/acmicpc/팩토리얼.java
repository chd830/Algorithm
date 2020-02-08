package net.acmicpc;

import java.util.*;

public class 팩토리얼 {
    static int result;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        result = 1;
        recur(sc.nextInt());
        System.out.println(result);
    }
    public static void recur(int N) {
        if(N < 1) {
            return;
        }
        result *= N;
        recur(N-1);
    }
}
