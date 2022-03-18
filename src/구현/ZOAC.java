package 구현;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/16719
public class ZOAC {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int len = str.length();
        int[] check = new int[len];
        int cnt = 1;
        int idx = 0;
        int prev = 0;
        while(cnt <= len) {
            int minimum = Integer.MAX_VALUE;
            boolean flag = false;
            for(int i = idx; i < len; i++) {
                if(check[i] == 0 && minimum > str.charAt(i)-'0') {
                    idx = i;
                    minimum = str.charAt(i)-'0';
                    flag = true;
                }
            }
            if(!flag) {
                int max = 0;
                int next = 0;
                for(int i = 0; i < len; i++) {
                    if(max < check[i] && check[i] < prev) {
                        max = check[i];
                        next = i;
                    }
                }
                prev--;
                idx = next;
                continue;
            }
            prev = cnt;
            check[idx] = cnt++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < len+1; i++) {
            for(int j = 0; j < len; j++) {
                if(check[j] <= i)
                    sb.append(str.charAt(j));
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
