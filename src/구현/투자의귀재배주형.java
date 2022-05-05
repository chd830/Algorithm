package 구현;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/19947
public class 투자의귀재배주형 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(token.nextToken());
        int year = Integer.parseInt(token.nextToken());
        int[] d = new int[year+1];
        d[0] = H;
        for(int i = 1; i <= year; i++) {
            d[i] = (int) (d[i-1]*1.05);
            if(i >= 3)
                d[i] = (int) Math.max(d[i], d[i-3]*1.2);
            if(i >= 5)
                d[i] = (int) Math.max(d[i], d[i-5]*1.35);
        }
        System.out.println(d[year]);
    }
}
