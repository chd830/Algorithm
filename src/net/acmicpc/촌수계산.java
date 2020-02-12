package net.acmicpc;

import java.util.*;

public class 촌수계산 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int start = sc.nextInt();
        int end = sc.nextInt();
        int size = sc.nextInt();
        List<Integer>[] list = new ArrayList[n+1];
        for(int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for(int i = 0; i < size; i++) {
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            list[num1].add(num2);
            list[num2].add(num1);
        }

    }
}
