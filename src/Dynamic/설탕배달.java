package Dynamic;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/2839
public class 설탕배달 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] d = new int[5001];
        d[3] = 1;
        d[5] = 1;
        for(int i = 6; i <= N; i++) {
            if(i%5 == 0)
                d[i] = i/5;
            else if(i%3 == 0)
                d[i] = i/3;
            if(d[i-5] != 0)
                d[i] = d[i-5]+1;
            else if(d[i-3] != 0)
                d[i] = d[i-3]+1;
        }
        System.out.println(d[N] == 0 ? -1 : d[N]);
    }
}
