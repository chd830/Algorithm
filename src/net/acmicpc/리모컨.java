package net.acmicpc;

import java.util.Scanner;

public class 리모컨 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //이동하려는 채널
        String str = sc.next();
        int[] chanel = new int[str.length()];
        for(int i = 0; i < str.length(); i++) {
            chanel[i] = str.charAt(i)-'0';
        }
        //고장난 버튼의 수
        int M = sc.nextInt();
        int[] error = new int[M];
        for(int i = 0; i < M; i++) {
            error[i] = sc.nextInt();
        }
        int min = 0;
        int cnt = str.length();
        boolean check = true;
        //주어진 채널보다 -로 내려가서
        //에러없이 누를 수 있는 채널을 찾고 그 채널까지의 거리찾기
        while(check) {
            outer:for(int i = 0; i < str.length(); i++) {
                for(int j = 0; j < M; j++) {
                    if(chanel[i] == error[j]) {
                        check = true;
                        chanel[str.length()-1]--;
                        cnt++;
                        break outer;
                    }
                }
                check = false;
            }
        }
        min = cnt;
        cnt = str.length();
        while(check) {
            outer:for(int i = 0; i < str.length(); i++) {
                for(int j = 0; j < M; j++) {
                    if(chanel[i] == error[j]) {
                        check = true;
                        chanel[str.length()-1]++;
                        cnt++;
                        break outer;
                    }
                    check = false;
                }
            }
        }
        min = Math.min(min, cnt);
        System.out.println(min);
    }
}
