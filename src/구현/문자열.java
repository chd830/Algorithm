package 구현;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1120
public class 문자열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        String A = token.nextToken();
        String B = token.nextToken();
        int min = B.length();
        int len = B.length()-A.length();
        for(int i = 0; i <= len; i++) {
            int cnt = 0;
            for(int j = i; j < i+A.length(); j++) {
                if(A.charAt(j-i) != B.charAt(j))
                    cnt++;
            }
            min = Math.min(min, cnt);
        }
        System.out.println(min);
    }
}
