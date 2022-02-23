package 구현;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/9935
public class 문자열폭발 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String bomb = br.readLine();
        StringBuilder sb = new StringBuilder();
        // String에서 StringBuilderr나 StringBuffer로 변환하면 메모리 초과 X
        for(int idx = 0; idx < str.length(); idx++) {
            sb.append(str.charAt(idx));
            if(sb.length() >= bomb.length()) {
                if(sb.substring(sb.length()-bomb.length(), sb.length()).equals(bomb)) {
                    sb.delete(sb.length()-bomb.length(), sb.length());
                }
            }
            else
                continue;
        }
        System.out.println(sb.length() == 0 ? "FRULA" : sb);
    }
}
