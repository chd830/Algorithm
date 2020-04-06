package com.swexpertacademy;

import java.util.Arrays;
import java.util.Scanner;

public class 구간합 {
    static int[] cnt;
    static int digit;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t <= T; t++) {
            cnt = new int[10];
            countNum(sc.nextLong(), sc.nextLong(), 1);
            int sum = 0;
            for(int i = 0; i < 10; i++) {
                sum += i*cnt[i];
            }
            System.out.println("#"+t+" "+sum);
        }
    }
    static void countNum(long start, long end, int digit) {
        while(start <= end) {
            // 시작 페이지의 마지막 자리가 0이 될 때 까지 ++
            while(start % 10 != 0 && start <= end) {
                counting(start, digit);
                start++;
            }
            // 마지막 페이지의 마지막 자리가 9가 될 때 까지 --
            while(end % 10 != 9 && start <= end) {
                counting(end, digit);
                end--;
            }
            if(start > end) break;
            // 마지막 자릿수를 제거한다.
            start /= 10;
            end /= 10;
            // start ~ end 사이의 0 ~ 9 갯수를 모두 센다.
            // 현재 자릿수 만큼 곱해줘야한다.
            for(int i = 0 ; i < 10 ; ++i) {
                cnt[i] += (end - start + 1) * digit;
            }
            // 자릿수를 높인다.
            digit *= 10;
        }
    }
    private static void counting(long num, int digit) {
        while(num > 0) {
            cnt[(int)num % 10] += digit;
            num /= 10;
        }
    }
}
