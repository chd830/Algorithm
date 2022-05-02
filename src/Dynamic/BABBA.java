package Dynamic;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/9625
public class BABBA {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] d1 = new int[N+2];
        int[] d2 = new int[N+2];
        d1[0] = 1;
        d2[0] = 0;
        d1[1] = 0;
        d2[1] = 1;
        d1[2] = d2[1] = 1;
        for(int i = 3; i <= N+1; i++) {
            d1[i] = d1[i-1]+d1[i-2];
            d2[i] = d2[i-1]+d2[i-2];
        }
        System.out.println(d2[N+1]+" "+d1[N+1]);
    }
}
