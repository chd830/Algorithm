package 구현;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1110
public class 더하기사이클 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        String prev = N;
        if(prev.length() < 2)
            prev = "0"+prev;
        int sum = prev.charAt(0)-'0'+prev.charAt(1)-'0';
        String s = String.valueOf(sum);
        prev = ""+prev.charAt(1)+s.charAt(s.length()-1);
        int cnt = 1;
        while(Integer.parseInt(N) != Integer.parseInt(prev)) {
            if(prev.length() < 2)
                prev = "0"+prev;
            sum = prev.charAt(0)-'0'+prev.charAt(1)-'0';
            s = String.valueOf(sum);
            prev = ""+prev.charAt(1)+s.charAt(s.length()-1);
            cnt++;
        }
        System.out.println(cnt);
    }
}
