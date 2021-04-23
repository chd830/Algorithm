package review;

import java.util.*;
import java.io.*;

// 1, 2, 3 더하기
public class acmicpc9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] d = new int[11];
        d[1] = 1;
        d[2] = 2;
        d[3] = 4;
        for(int i = 4; i < d.length; i++) {
            d[i] = d[i-3]+d[i-2]+d[i-1];
        }
        for(int t = 0; t < T; t++) {
            System.out.println(d[Integer.parseInt(br.readLine())]);
        }
    }
}
