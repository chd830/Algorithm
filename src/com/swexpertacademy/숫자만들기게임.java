package com.swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class 숫자만들기게임 {
    static HashMap<Integer, Integer> memo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            memo = new HashMap<>();
            sb.append("#").append(t).append(" ");
            String str = br.readLine();
            sb.append(game(str));
        }
    }
    static int game(String str) {
        if(Integer.parseInt(str) < 10) {
            return 0;
        }
        int cnt = 0;
        int max = 0;
        int len = str.length()-1;
        for(int i = 1, size = 1<<len; i < size; i++) {
            int num = str.charAt(0)-'0';
            int mul = 1;
            for(int j = 0; j < len; j++) {
                if((i&(1<<j)) == 0) { //쪼개는 위치가 아님
                    num = num*10 + str.charAt(j+1)-'0';
                }
                else {
                    mul *= num;
                    num = str.charAt(0)-'0';
                }
            }
            mul *= num; //마지막 조각을 연산
            cnt = 0;
            if(memo.containsKey(mul)) {
                cnt = memo.get(mul);
            }
            else {
                cnt = game(""+mul);
                memo.put(mul, cnt);
            }
        }
        max = Math.max(max, cnt);
        return max;
    }
}
