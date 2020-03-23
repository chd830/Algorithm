package com.swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 스타일리쉬들여쓰기 {
    static int p;
    static int q;
    static int[] dap;
    static int[] dots;
    static int[] sub = new int[3];
    static int[] m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            sb.append("#"+t+" ");
            StringTokenizer token = new StringTokenizer(br.readLine());
            p = Integer.parseInt(token.nextToken());
            q = Integer.parseInt(token.nextToken());
            m = new int[3];
            dots = new int[p];
            dap = new int[3];
            for(int i = 0; i < p; i++) {
                String str = br.readLine();
                boolean check = true;
                for (int j = 0; j < str.length(); j++) {
                    char ch = str.charAt(j);
                    if (ch == '.' && check) {
                        dots[i]++;
                    } else {
                        check = false;
                        switch(ch) {
                            case '(':
                                m[0]++;
                                break;
                            case ')':
                                m[0]--;
                                break;
                            case '{':
                                m[1]++;
                                break;
                            case '}':
                                m[1]--;
                                break;
                            case '[':
                                m[2]++;
                                break;
                            case ']':
                                m[2]--;
                                break;
                        }
                    }
                }
            }
            for(int i = 0; i < q; i++) {
                String str = br.readLine();
                char ch = str.charAt(i);
                switch(ch) {
                    case '(':
                        dap[0]++;
                        break;
                    case ')':
                        dap[0]--;
                        break;
                    case '{':
                        dap[1]++;
                        break;
                    case '}':
                        dap[1]--;
                        break;
                    case '[':
                        dap[2]++;
                        break;
                    case ']':
                        dap[2]--;
                        break;
                }
            }

            comb(0, 0);
            sb.append("\n");
        }
        System.out.println(sb);
    }
    static void comb(int cur, int cnt) {
        if(cur >= 3) {
            System.out.println(Arrays.toString(sub));
            return;
        }
        for(int i = 10; i > 0; i--) {
            sub[cur] = i;
            comb(cur+1, i+1);
        }
    }
}
