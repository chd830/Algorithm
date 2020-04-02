package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 집합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token;
        StringBuilder sb = new StringBuilder();
        List<Integer>[] list = new ArrayList[10];
        for(int i = 0; i < 10; i++) {
            list[i] = new ArrayList();
        }
        int N = Integer.parseInt(br.readLine());
        /*
        add xPos: S에 x를 추가한다. (1 ≤ xPos ≤ 20) S에 x가 이미 있는 경우에는 연산을 무시한다.
        remove xPos: S에서 x를 제거한다. (1 ≤ xPos ≤ 20) S에 x가 없는 경우에는 연산을 무시한다.
        check xPos: S에 x가 있으면 1을, 없으면 0을 출력한다.
        toggle xPos: S에 x가 있으면 x를 제거하고, 없으면 x를 추가한다. (1 ≤ xPos ≤ 20)
        all: S를 {1, 2, ..., 20} 으로 바꾼다.
        empty: S를 공집합으로 바꾼다.
         */
        int total = 0;
        for(int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine());
            String str = token.nextToken();
            int num = 0;
            switch (str) {
                case "add":
                    if((total&(1<<num)) != 0) {
                        continue;
                    }
                    num = Integer.parseInt(token.nextToken());
                    total = total | (1<<num);
                    break;
                case "remove":
                    if((total&(1<<num)) != 0) {
                        continue;
                    }
                    num = Integer.parseInt(token.nextToken());
                    total = total & ~(1<<num);
                    break;
                case "check":
                    num = Integer.parseInt(token.nextToken());
                    if((total&(1<<num)) != 0) {
                        sb.append("1\n");
                    }
                    else {
                        sb.append("0\n");
                    }
                    break;
                case "toggle":
                    num = Integer.parseInt(token.nextToken());
                    if((total&(1<<num)) != 0) {
                        total = total & ~(1<<num);
                    }
                    else {
                        total = total | (1<<num);
                    }
                    break;
                case "all":
                    total = 0;
                    for(int j = 1; j <= 20; j++) {
                        total += (1<<j);
                    }
                    break;
                case "empty":
                    total = 0;
                    break;
            }
        }
        System.out.println(sb.toString());
    }
}
