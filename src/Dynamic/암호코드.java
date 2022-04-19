package Dynamic;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/2011
public class 암호코드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        if(N.equals("0")) {
            System.out.println(0);
            return;
        }
        int[] d = new int[5001];
        d[0] = 1;
        for(int i = 1; i <= N.length(); i++) {
            int n = N.charAt(i-1)-'0';
            if(n >= 1 && n <= 9)
                d[i] = d[i-1]%1000000;
            if(i == 1)
                continue;
            n = Integer.parseInt(N.substring(i-2, i));
            if(n >= 10 && n <= 26)
                d[i] += d[i-2]%1000000;
        }
        System.out.println(d[N.length()]%1000000);
    }
}
