package com.swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 보물상자비밀번호 {
    static int N;
    static int K;
    static Queue<Character> que;
    static List<String> list;
    static int[] hexadecimal = new int[] {1, 16, 256, 4096, 65536, 1048576, 16777216, 268435456};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t = 1; t <= T; t++) {
            sb.append("#").append(t).append(" ");
            StringTokenizer token = new StringTokenizer(br.readLine());
            N = Integer.parseInt(token.nextToken());
            int size = N/4;
            K = Integer.parseInt(token.nextToken());
            String str = br.readLine();
            list = new ArrayList();
            que = new LinkedList<>();

            for(int i = 0; i < N; i++) {
                char num = str.charAt(i);
                que.add(num);
            }
            for(int j = 0; j < size-1; j++) {
                que.add(que.poll());
            }
            for(int i = 0; i < N/4; i++) {
                que.add(que.poll());
                makePwd(N/4);
            }
            Collections.sort(list, Collections.reverseOrder());
            String s = list.get(K-1);
            int num = 0;
            for(int i = 0, j = size-1; i < s.length(); i++) {
                if(Character.isDigit(s.charAt(i))) {
                    num += hexadecimal[j - i] * (s.charAt(i)-'0');
                }
                else {
                    num += hexadecimal[j - i] * Integer.parseInt("" + s.charAt(i), 16);
                }
            }
            sb.append(num).append("\n");
        }
        System.out.println(sb);
    }

    static void makePwd(int size) {
        int tmp = size;
        String pwd = "";
        int idx = 0;
        while(idx < que.size()) {
            char num = que.poll();
            que.add(num);
            pwd += num;
            if(--tmp == 0) {
                tmp = size;
                if(!list.contains(pwd)) {
                    list.add(pwd);
                }
                pwd = "";
            }
            idx++;
        }
    }
}
