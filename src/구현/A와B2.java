package 구현;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/12919
public class A와B2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = br.readLine();
        String B = br.readLine();
        // A를 B로 바꿀수 있으면 1 없으면 0
        // dfs로 접근하기
        flag = false;
        // 문자열의 뒤에 A추가하기 -> 문자열의 뒤에 B를 추가하고 문자열을 뒤집기 -> 시간초과
        // 문자열 B에서 제거하는 쪽으로 접근
        dfs(B, A);
        System.out.println(flag ? 1 : 0);
    }
    static boolean flag;
    static void dfs(String str, String A) {
        if(str.length() == A.length()) {
            if(str.equals(A))
                flag = true;
            return;
        }
        if(str.charAt(str.length()-1) == 'A') {
            // A제거
            String tmp = "";
            for (int i = 0; i < str.length() - 1; i++) {
                tmp += str.charAt(i);
            }
            dfs(tmp, A);
        }
        if(str.charAt(0) == 'B') {
            String tmp = "";
            // 뒤집은 후 B제거
            StringBuilder sb = new StringBuilder();
            for(int i = str.length()-1; i > 0; i--)
                tmp += str.charAt(i);
            dfs(tmp, A);
        }
        else
            return;
    }
}
