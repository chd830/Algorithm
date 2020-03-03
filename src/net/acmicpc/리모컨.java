package net.acmicpc;

import java.util.Scanner;

public class 리모컨 {
    static boolean[] broken = new boolean[10];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        for (int i = 0; i < M; i++) {
            broken[sc.nextInt()] = true;
        }
        //100에서 +,-버튼으로만 이동할 때의 값
        int result = Math.abs(N - 100);
        if(N == 100) {
            System.out.println(0);
            System.exit(0);
        }
        for(int i = 0; i <= 1000000; i++) {
            //고장나지 않은 버튼들로 만들 수 있는 채널 찾기
            int len = possible(i);
            if(len > 0) {
                int min = Math.abs(i-N );
                //채널에서 최솟값과 길이를 찾고 위에서 찾은 100에서 이동할 수 있는 값과 비교해서 최솟값 구하기
                if(result > len + min) {
                    result = len + min;
                }
            }
        }
        System.out.println(result);
    }
    public static int possible(int n) {
        if(n == 0) {
            if(broken[n]) {
                return 0;
            }
            else {
                return 1;
            }
        }
        int len = 0;
        while(n > 0) {
            if(broken[n%10]) {
                return 0;
            }
            len++;
            n /= 10;
        }
        return len;
    }
}