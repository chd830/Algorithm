package recur;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1759
public class 암호만들기 {
    static StringBuilder sb;
    static boolean[] visited;
    static String[] str;
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        str = new String[M];
        visited = new boolean[M];
        token = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            str[i] = token.nextToken();
        }
        Arrays.sort(str);
        recur(0, "");
        System.out.println(sb.toString());
    }
    static boolean check(String pwd) {
        int consonant = 0;
        int gather = 0;
        for(char c : pwd.toCharArray()) {
            switch (c) {
                case 'a': case 'e': case 'i': case 'o': case 'u':
                    gather++;
                    break;
                default:
                    consonant++;
            }
        }
        return gather >= 1 && consonant >= 2;
    }
    static void recur(int idx, String pwd) {
        // 한개의 모음과 최소 두개의 자음 체크
        if(pwd.length() == N && check(pwd)) {
            sb.append(pwd).append("\n");
            return;
        }
        for(int i = idx; i < M; i++) {
            if(!visited[i]) {
                visited[i] = true;
                recur(i+1, pwd+str[i]);
                visited[i] = false;
            }
        }
    }
}
